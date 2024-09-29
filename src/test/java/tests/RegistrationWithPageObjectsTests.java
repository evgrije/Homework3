package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithPageObjectsTests  extends TestBase{
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest(){
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Egorov")
                .setEmail("alex@example.com")
                .setGender("Other")
                .setUserNumber("1234567890")
                .setDateOfBirth("30", "July", "2008")
                .setSubject("English")
                .setHobbies("[for=hobbies-checkbox-2]")
                .uploadImage("reference.png")
                .setCurrentAddress("Gorohovaya,1")
                .selectState("NCR")
                .selectCity("Delhi")
                .clickSubmit();

        registrationPage.checkResult("Student Name", "Alex" + " " + "Egorov")
                .checkResult("Student Email", "alex@example.com")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "30 July,2008")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "reference.png")
                .checkResult("Address", "Gorohovaya,1")
                .checkResult("State and City","NCR Delhi");
    }
    @Test
    void emptyForm(){
        registrationPage.openPage()
                .modalDialogNotOpen();
    }

    @Test
    void requiredFillRegistrationForm(){
        registrationPage.openPage()
                .setFirstName("Musya")
                .setLastName("Petrova")
                .setGender("Male")
                .setUserNumber("0987654321")
                .clickSubmit();
        registrationPage.checkResult("Student Name", "Musya" + " " + "Petrova")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "0987654321");
    }


}
