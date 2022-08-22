package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultTableComponent;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {

    private CalendarComponent calendarComponents = new CalendarComponent();
    private ResultTableComponent resultTableComponent = new ResultTableComponent();

    private static final String HEADER_FORM_REGISTRATION = "Student Registration Form";
    private SelenideElement firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            userNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            selectState =  $("#state input"),
            selectCity =  $("#city input"),
            summit =    $("#submit"),
            form = $(".practice-form-wrapper");



    public RegistrationFormTests openPage(){
        open("/automation-practice-form");
        form.shouldHave(text(HEADER_FORM_REGISTRATION));
        return this;
    }

    public RegistrationFormTests setFirstName(String name) {
        firstName.setValue(name);
        return this;
    }

    public RegistrationFormTests setLastName(String name) {
        lastName.setValue(name);
        return this;
    }

    public RegistrationFormTests setUserEmail(String email) {
        userEmail.setValue(email);
        return this;
    }

    public RegistrationFormTests setGender(String gender) {
        $x("//label[text()='" + gender + "']").click();
        return this;
    }
    public RegistrationFormTests setUserNumber(String number) {
        userNumber.setValue(number);
        return this;
    }

    public RegistrationFormTests setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponents.setDate(day, month, year);
        return this;
    }



    public RegistrationFormTests setSubjectsInput(String subjects) {
        subjectsInput.setValue(subjects).sendKeys(Keys.ENTER);
        return this;
    }
    public RegistrationFormTests setHobbies(String hobbies) {
        $x("//label[text()='" + hobbies + "']").click();
        return this;
    }

    public RegistrationFormTests setUploadPicture(String pathPicture) {
        uploadPicture.uploadFile(new File(pathPicture));
        return this;
    }

    public RegistrationFormTests setCurrentAddress(String address) {
        currentAddress.setValue(address);
        return this;
    }

    public RegistrationFormTests setState(String state) {
        selectState.setValue(state).sendKeys(Keys.ENTER);
        return this;
    }

    public RegistrationFormTests setCity(String city) {
        selectCity.setValue(city).sendKeys(Keys.ENTER);
        return this;
    }

    public RegistrationFormTests clickSubmit() {
        summit.click();
        return this;
    }


    public RegistrationFormTests checkResultTableVisible() {
        resultTableComponent.checkVisible();

        return  this;
    }

    public RegistrationFormTests checkRegistrationSubmittingFormTests(String key, String value) {
        resultTableComponent.checkResult(key, value);

        return  this;
    }

}
