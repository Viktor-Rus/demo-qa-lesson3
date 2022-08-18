package com.demoqa;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestForm {


    @BeforeAll
    static void configure(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void testForm(){
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("email@email.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("9374364782");
        $("#dateOfBirthInput").click();
        $("div[class*='react-datepicker__month-dropdown-container").click();
        $("select[class='react-datepicker__month-select'] option[value='4']").click();
        $("div[class*='react-datepicker__year-dropdown-container").click();
        $("select[class='react-datepicker__year-select'] option[value='1993']").click();
        $("div[aria-label='Choose Saturday, May 29th, 1993']").click();
        $("#subjectsInput").setValue("English").sendKeys(Keys.ENTER);
        $("label[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/selenide-logo-big.png"));
        $("#currentAddress").setValue("My Address Soviet Union");
        $("#react-select-3-input").setValue("Haryana").sendKeys(Keys.ENTER);
        $("#react-select-4-input").setValue("Karnal").sendKeys(Keys.ENTER);

        $("#submit").click();

        $(By.xpath("//td[text()='Student Name']/following::td[1]")).shouldHave(text("Ivan Ivanov"));
        $(By.xpath("//td[text()='Student Email']/following::td[1]")).shouldHave(text("email@email.com"));
        $(By.xpath("//td[text()='Gender']/following::td[1]")).shouldHave(text("Male"));
        $(By.xpath("//td[text()='Mobile']/following::td[1]")).shouldHave(text("9374364782"));
        $(By.xpath("//td[text()='Date of Birth']/following::td[1]")).shouldHave(text("29 May,1993"));
        $(By.xpath("//td[text()='Subjects']/following::td[1]")).shouldHave(text("English"));
        $(By.xpath("//td[text()='Hobbies']/following::td[1]")).shouldHave(text("Sports"));
        $(By.xpath("//td[text()='Picture']/following::td[1]")).shouldHave(text("selenide-logo-big.png"));
        $(By.xpath("//td[text()='Address']/following::td[1]")).shouldHave(text("My Address Soviet Union"));
        $(By.xpath("//td[text()='State and City']/following::td[1]")).shouldHave(text("Haryana Karnal"));



    }
}
