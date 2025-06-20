package tests;

import org.junit.jupiter.api.Test;
import pages.components.ResultCheckComponent;
import pages.StudentRegistrationForm;
import utils.DataFaker;

public class DemoqaTestFormWithFaker extends BaseTest {


    StudentRegistrationForm studentRegistrationForm = new StudentRegistrationForm();
    ResultCheckComponent resultCheckComponent = new ResultCheckComponent();

    DataFaker faker = new DataFaker();

    String firstName = faker.gerRandomFirstName(),
            lastName = faker.getRandomLastName(),
            email = faker.getRandomEmail(),
            gender = faker.getRandomGender(),
            phoneNubmer = faker.getRandomNumber(),
            day = faker.getRandomBirthDay(),
            month = faker.getRandomMonth(),
            year = faker.getRandomBirthYear(),
            subject = faker.getRandomSubject(),
            hobbies = faker.getRandomHobbies(),
            photo = faker.getRandomPhoto(),
            address = faker.getRandomAddress(),
            states = faker.getRandomState(),
            city = faker.getRandomCity(states);

    @Test
    void successFullRegistrationTest(){
        studentRegistrationForm.openPage()
                .setFirstNameInput(firstName)
                .setLastNameInput(lastName)
                .setEmailInput(email)
                .setGenderRadio(gender)
                .setUserNumberInput(phoneNubmer)
                .setDate(month, year, day)
                .setSubjectsInput(subject)
                .setHobbiesCheckBox(hobbies)
                .setPicture(photo)
                .setCurrentAddressInput(address)
                .setStateInput(states)
                .setCityInput(city)
                .touchSubmitButton();

        resultCheckComponent
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNubmer)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", photo)
                .checkResult("Address", address)
                .checkResult("State and City", states + " " + city);
    }

    @Test
    void minimumDataOnFormTest(){
        studentRegistrationForm.openPage()
                .setFirstNameInput(firstName)
                .setLastNameInput(lastName)
                .setGenderRadio(gender)
                .setUserNumberInput(phoneNubmer)
                .touchSubmitButton();

        resultCheckComponent
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNubmer);
    }

    @Test
    void negativeExampleTest(){
        studentRegistrationForm.openPage()
                .touchSubmitButton();
        resultCheckComponent.checkNegativeResult();
    }
}
