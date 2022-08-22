package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CalendarComponent {

    private SelenideElement selectMonth = $(".react-datepicker__month-select"),
                            selectYear = $(".react-datepicker__year-select");


    public CalendarComponent setDate(String day, String month, String year) {
        selectMonth.selectOption(month);
        selectYear.selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
        return this;
    }
}
