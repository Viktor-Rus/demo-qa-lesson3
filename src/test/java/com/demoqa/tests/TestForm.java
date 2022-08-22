package com.demoqa.tests;


import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormTests;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestForm {
    RegistrationFormTests registrationFormTests = new RegistrationFormTests();


    @BeforeAll
    static void configure(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void testForm(){
        registrationFormTests.openPage().
                setFirstName("Ivan").
                setLastName("Ivanov").
                setUserEmail("email@email.com").
                setGender("Male").
                setUserNumber("9374364782").
                setBirthDate("29", "May", "1993").
                setSubjectsInput("English").
                setHobbies("Sports").
                setUploadPicture("src/test/resources/selenide-logo-big.png").
                setCurrentAddress("My Address Soviet Union").
                setState("Haryana").
                setCity("Karnal").
                clickSubmit();

        registrationFormTests.checkResultTableVisible().
                checkRegistrationSubmittingFormTests("Student Name","Ivan Ivanov").
                checkRegistrationSubmittingFormTests("Student Email","email@email.com").
                checkRegistrationSubmittingFormTests("Gender","Male").
                checkRegistrationSubmittingFormTests("Mobile","9374364782").
                checkRegistrationSubmittingFormTests("Date of Birth","29 May,1993").
                checkRegistrationSubmittingFormTests("Subjects","English").
                checkRegistrationSubmittingFormTests("Hobbies","Sports").
                checkRegistrationSubmittingFormTests("Picture","selenide-logo-big.png").
                checkRegistrationSubmittingFormTests("Address","My Address Soviet Union").
                checkRegistrationSubmittingFormTests("State and City","Haryana Karnal");
    }
}
