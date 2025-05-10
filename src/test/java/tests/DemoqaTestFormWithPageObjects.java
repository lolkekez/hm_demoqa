package tests;

import org.junit.jupiter.api.Test;
import pages.components.ResultCheckComponent;
import pages.StudentRegistrationForm;
public class DemoqaTestFormWithPageObjects extends BaseTest {

    StudentRegistrationForm studentRegistrationForm = new StudentRegistrationForm();
    ResultCheckComponent resultCheckComponent = new ResultCheckComponent();

    @Test
    void successFullRegistrationTest(){
        studentRegistrationForm.openPage()
                .setFirstNameInput("Oleg")
                .setLastNameInput("Safenreiter")
                .setEmailInput("olegsafenreiter@qaguru.com")
                .setGenderMaleRadio()
                .setUserNumberInput("1234567890")
                .setDate("November", "2002", "1")
                .setSubjectsInput("Biology")
                .setHobbiesCheckBox("Music")
                .setPicture()
                .setCurrentAddressInput("Street 123")
                .setStateInput("NCR")
                .setCityInput("Noida")
                .touchSubmitButton();

        resultCheckComponent.checkResult("Student Name", "Oleg Safenreiter")
                .checkResult("Student Email", "olegsafenreiter@qaguru.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "1 November,2002")
                .checkResult("Subjects", "Biology")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "img.jpg")
                .checkResult("Address", "Street 123")
                .checkResult("State and City", "NCR Noida");
    }

    @Test
    void minimumDataOnFormTest(){
        studentRegistrationForm.openPage()
                .setFirstNameInput("1")
                .setLastNameInput("1")
                .setGenderFemaleRadio()
                .setUserNumberInput("1234567890")
                .touchSubmitButton();

        resultCheckComponent
                .checkResult("Student Name", "1 1")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "1234567890");
    }

    @Test
    void negativeExampleTest(){
        studentRegistrationForm.openPage()
                .touchSubmitButton();
        resultCheckComponent.checkNegativeResult();
    }
}
