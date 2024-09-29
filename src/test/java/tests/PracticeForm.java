package tests;

import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {
    @BeforeAll
    static void BeforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";

    }

    @Test
    void fillFormTest(){
        open("/automation-practice-form");
        $x("//*[@id='firstName']").setValue("Alex");
        $x("//*[@id='lastName']").setValue("Sidorov");
        $x("//*[@id='userEmail']").setValue("alex@example.ru");
        $("#genterWrapper").find(".custom-control-label").click(); //можно было написать так: $("#genterWrapper").parent().click();
        $x("//*[@id='userNumber']").setValue("7900123123");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        /* может быть такое что два элемента одинакого выводятся
        на одной области (поэтому селенид должен понимать что конкретно выбирать
        поэтому здесь мы смотрим на один селектор и исключаем другой
         */



        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").find("[for=hobbies-checkbox-2]").click();

        /* аналог:
        $("#hobbiesWrapper").$(byText("Sports")).click();
         */

        $("#uploadPicture").uploadFromClasspath("reference.png");

        /* аналог:
        $("#uploadPicture").uploadFile(new File("/Users/evgeniakuznecova/IdeaProjects/Homework3/src/test/resources/reference.png"));
         */

        $("#currentAddress").setValue("Gorohovaya,1");
        $("#state").click();
        $("#react-select-3-option-1").click();

        /* аналог:
        $("#stateCity-wrapper").$(byText("NCR"))click(); - поиск по тексту
         */

        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();

        $(".modal-content").shouldHave(text("Alex Sidorov"));
        $(".modal-content").shouldHave(text("alex@example.ru"));
        $(".modal-content").shouldHave(text("Male"));
        $(".modal-content").shouldHave(text("7900123123"));
        $(".modal-content").shouldHave(text("30 July,2008"));
        $(".modal-content").shouldHave(text("English"));
        $(".modal-content").shouldHave(text("Reading"));
        $(".modal-content").shouldHave(text("reference.png"));
        $(".modal-content").shouldHave(text("Gorohovaya,1"));
        $(".modal-content").shouldHave(text("Uttar Pradesh Agra"));




    }
}
