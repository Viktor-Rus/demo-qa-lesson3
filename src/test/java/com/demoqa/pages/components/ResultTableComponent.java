package com.demoqa.pages.components;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {

    private SelenideElement modalDialog =  $(".modal-dialog"),
                            modalHeader =  $(".modal-header");

    private final static String RESULT_HEADER_TEXT = "Thanks for submitting the form";
    public ResultTableComponent checkVisible() {
        modalDialog.should(appear);
        modalHeader.shouldHave(text(RESULT_HEADER_TEXT));

        return this;
    }

    public ResultTableComponent checkResult(String key, String value) {
        $(By.xpath("//td[text()='" + key + "']/following::td[1]")).shouldHave(text(value));
        return this;
    }
}
