package pages;


import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableResultComponent;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private SelenideElement firstNameInput = $x("//*[@id='firstName']"),
            lastNameInput = $x("//*[@id='lastName']"),
            userEmailInput = $x("//*[@id='userEmail']"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $x("//*[@id='userNumber']"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            imageUpload = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateSelector = $("#state"),
            citySelector = $("#city"),
            submitButton = $("#submit"),
            tableResult = $(".modal-content");

    CalendarComponent calendarComponent = new CalendarComponent();
    public RegistrationPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setEmail(String value){
        userEmailInput.setValue(value);

        return this;
    }
    public RegistrationPage setGender(String value){
        genderWrapper.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setUserNumber(String value){
        userNumberInput.setValue(value);

        return this;
    }
    public RegistrationPage setDateOfBirth(String day, String month, String year){
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
    public RegistrationPage setSubject(String value){
        subjectInput.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage setHobbies(String value){
        hobbiesWrapper.find(value).click();

        return this;
    }
    public RegistrationPage uploadImage(String value){
        imageUpload.uploadFromClasspath(value);

        return this;
    }
    public RegistrationPage setCurrentAddress(String value){
        currentAddressInput.setValue(value);

        return this;
    }
    public RegistrationPage selectState(String value){
        stateSelector.click();
        stateSelector.$(byText(value)).click();

        return this;
    }
    public RegistrationPage selectCity(String value){
        citySelector.click();
        citySelector.$(byText(value)).click();

        return this;
    }
    public RegistrationPage clickSubmit(){
        submitButton.click();

        return this;
    }
    public RegistrationPage checkResult(String key, String value){
        tableResult.shouldHave(text("Thanks for submitting the form"));
        new TableResultComponent().checkFilledField(key, value);

        return this;
    }

}
