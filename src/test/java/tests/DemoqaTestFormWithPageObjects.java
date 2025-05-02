package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationForm;
public class DemoqaTestFormWithPageObjects extends BaseTest {

    StudentRegistrationForm studentRegistrationForm = new StudentRegistrationForm();


    @Test
    void successFullRegistrationTest(){
        Configuration.pageLoadStrategy = "eager";
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

        studentRegistrationForm.checkResult("Student Name", "Oleg Safenreiter")
                .checkResult("Student Email", "olegsafenreiter@qaguru.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "1 November,2002")
                .checkResult("Subjects", "Biology")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "img.jpg")
                .checkResult("Address", "Street 123")
                .checkResult("State and City", "NCR Noida")
        ;


    }

}
