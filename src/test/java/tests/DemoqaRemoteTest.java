package tests;

import com.codeborne.selenide.Configuration;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.components.ResultCheckComponent;
import pages.StudentRegistrationForm;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import java.util.Map;

import static io.qameta.allure.Allure.step;

@Tag("demoqa_tests")
public class DemoqaRemoteTest extends RemoteBaseTest{


    StudentRegistrationForm studentRegistrationForm = new StudentRegistrationForm();
    ResultCheckComponent resultCheckComponent = new ResultCheckComponent();

    @Test
    @Tag("Positive")
    void successFullRegistrationTest(){

        step("Open form", () -> {
            studentRegistrationForm.openPage();
        });

        step("Заполнение формы", () -> {
            studentRegistrationForm.setFirstNameInput("Oleg")
                    .setLastNameInput("Safenreiter")
                    .setEmailInput("olegsafenreiter@qaguru.com")
                    .setGenderRadio("Male")
                    .setUserNumberInput("1234567890")
                    .setDate("November", "2002", "1")
                    .setSubjectsInput("Biology")
                    .setHobbiesCheckBox("Music")
                    .setPicture("img.jpg")
                    .setCurrentAddressInput("Street 123")
                    .setStateInput("NCR")
                    .setCityInput("Noida")
                    .touchSubmitButton();
        });

        step("Проверка результатов", () -> {
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
        });
    }

    @Test
    @Tag("Positive")
    void minimumDataOnFormTest(){
        studentRegistrationForm.openPage()
                .setFirstNameInput("1")
                .setLastNameInput("1")
                .setGenderRadio("Female")
                .setUserNumberInput("1234567890")
                .touchSubmitButton();
        step("Проверка результатов", () -> {resultCheckComponent

                .checkResult("Student Name", "1 1")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "1234567890");
        });
    }

    @Test
    @Tag("Negative")
    void negativeExampleTest(){
        studentRegistrationForm.openPage()
                .touchSubmitButton();
        step("Проверка результатов", () -> {resultCheckComponent.checkNegativeResult();});
    }
}
