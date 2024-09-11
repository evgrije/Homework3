
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
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest(){
        open("/automation-practice-form");
        $x("//*[@id='firstName']").setValue("Alex");
        $x("//*[@id='lastName']").setValue("Sidorov");
        $x("//*[@id='userEmail']").setValue("alex@example.ru");
        $("#genterWrapper").find(".custom-control-label").click();
        $x("//*[@id='userNumber']").setValue("7900123123");
        $("#dateOfBirthInput").setValue("15 Jun 2002");
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").find("[for=hobbies-checkbox-2]").click();
        $("#uploadPicture").uploadFromClasspath("reference.png");
        $("#currentAddress").setValue("Gorohovaya,1");
        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();

        $(".modal-content").shouldHave(text("Alex Sidorov"));
        $(".modal-content").shouldHave(text("alex@example.ru"));
        $(".modal-content").shouldHave(text("Male"));
        $(".modal-content").shouldHave(text("7900123123"));
        $(".modal-content").shouldHave(text("11 June,202415"));
        $(".modal-content").shouldHave(text("English"));
        $(".modal-content").shouldHave(text("Reading"));
        $(".modal-content").shouldHave(text("reference.png"));
        $(".modal-content").shouldHave(text("Gorohovaya,1"));
        $(".modal-content").shouldHave(text("Uttar Pradesh Agra"));






    }
}
