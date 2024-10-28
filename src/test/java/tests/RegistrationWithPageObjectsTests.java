package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

public class RegistrationWithPageObjectsTests  extends TestBase{
    private final RegistrationPage registrationPage = new RegistrationPage();



    String firstName = RandomUtils.getRandomFirstName(),
            lastName = RandomUtils.getRandomLastName(),
            userEmail = RandomUtils.getRandomEmailAddress(),
            userNumber = RandomUtils.getRandomUserNumber(),
            streetAddress = RandomUtils.getRandomStreetAddress(),
            userGender = RandomUtils.getRandomGender(),
            userImage = RandomUtils.getRandomImage(),
           dayOfBirth = RandomUtils.getRandomDay(),
            monthOfBirth = RandomUtils.getRandomMonth(),
            yearOfBirth  = RandomUtils.getRandomYear(),
            userSubject = RandomUtils.getSubject(),
            userHobbies = RandomUtils.getHobbies(),
            userState = RandomUtils.setState(),
            userCity = RandomUtils.setCity(userState);

    @Test
    void successfulRegistrationTest(){
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(userSubject)
                .setHobbies(userHobbies)
                .uploadImage(userImage)
                .setCurrentAddress(streetAddress)
                .selectState(userState)
                .selectCity(userCity)
                .clickSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " +  monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", userSubject)
                .checkResult("Hobbies", userHobbies)
                .checkResult("Picture", userImage)
                .checkResult("Address", streetAddress)
                .checkResult("State and City", userState + " " + userCity);
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
