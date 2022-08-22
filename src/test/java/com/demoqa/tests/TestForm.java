package com.demoqa.tests;



import com.demoqa.pages.RegistrationFormTests;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class TestForm  extends BaseTests{
    RegistrationFormTests registrationFormTests = new RegistrationFormTests();
    Faker faker = new Faker(new Locale("en-GB"));

    String firstName,
            lastName,
            userEmail,
            userNumber,
            day,
            month,
            year,
            currentAddress;

    @BeforeEach
    void prepareTestData(){
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        userEmail = faker.internet().emailAddress();
        userNumber = faker.phoneNumber().subscriberNumber(10);
        day = faker.number().numberBetween(1,30) + "";
        month = "May";
        year = faker.number().numberBetween(1990,2020) + "";
        currentAddress= faker.address().fullAddress();
    }


    @Test
    void testForm(){
        registrationFormTests.openPage().
                setFirstName(firstName).
                setLastName(lastName).
                setUserEmail(userEmail).
                setGender("Male").
                setUserNumber(userNumber).
                setBirthDate(day, month, year).
                setSubjectsInput("English").
                setHobbies("Sports").
                setUploadPicture("src/test/resources/selenide-logo-big.png").
                setCurrentAddress(currentAddress).
                setState("Haryana").
                setCity("Karnal").
                clickSubmit();

        String expectedFullName = String.format("%s %s",firstName, lastName );
        String expectedBirthDate = String.format("%s %s,%s",day, month,year);

        registrationFormTests.checkResultTableVisible().
                checkRegistrationSubmittingFormTests("Student Name",expectedFullName).
                checkRegistrationSubmittingFormTests("Student Email",userEmail).
                checkRegistrationSubmittingFormTests("Gender","Male").
                checkRegistrationSubmittingFormTests("Mobile",userNumber).
                checkRegistrationSubmittingFormTests("Date of Birth",expectedBirthDate).
                checkRegistrationSubmittingFormTests("Subjects","English").
                checkRegistrationSubmittingFormTests("Hobbies","Sports").
                checkRegistrationSubmittingFormTests("Picture","selenide-logo-big.png").
                checkRegistrationSubmittingFormTests("Address",currentAddress).
                checkRegistrationSubmittingFormTests("State and City","Haryana Karnal");
    }
}
