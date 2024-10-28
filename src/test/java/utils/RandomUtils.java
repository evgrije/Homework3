package utils;

import com.github.javafaker.Faker;
import pages.RegistrationPage;

import java.util.Locale;

public class RandomUtils {
    RegistrationPage registrationPage = new RegistrationPage();
    static Faker faker = new Faker(new Locale("en-GB"));

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomEmailAddress() {
        return faker.internet().emailAddress();
    }

    public static String getRandomUserNumber() {
        return faker.number().digits(10);
    }

    public static String getRandomStreetAddress() {
        return faker.address().streetAddress();
    }

    public static String getRandomGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public static String getRandomImage() {
        return faker.options().option("reference.png", "test.png");
    }

    public static String getRandomMonth() {
        return faker.options().option("January", "February", "March", "April",
                "May", "June", "July", "August", "September",
                "October", "November", "December");
    }

    public static String getRandomYear() {
        return faker.number().numberBetween(1900, 2023) + "";
    }

    public static String getRandomDay() {
        return faker.number().numberBetween(1, 28) + "";
    }

    public static String getSubject() {
        return faker.options().option("English", "Chemistry", "Computer Science", "Commerce", "Economics", "Social Studies");
    }

    public static String getHobbies() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public static String setState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }
    public static String setCity(String userState) {
        if (userState.equals("NCR")) {
            return faker.options().option("Delhi", "Gurgaon", "Noida");
        }
        if (userState.equals("Uttar Pradesh")) {
            return faker.options().option("Agra", "Lucknow", "Merrut");
        }
        if (userState.equals("Haryana")) {
            return faker.options().option("Karnal", "Panipat");
        }
        if (userState.equals("Rajasthan")) {
            return faker.options().option("Jaipur", "Jaiselmer");
        } else {
            return "";
        }
    }

}
