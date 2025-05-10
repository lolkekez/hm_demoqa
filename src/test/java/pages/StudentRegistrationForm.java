package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationForm {

    private CalendarComponent calendarComponent = new CalendarComponent();

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadio = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            birthCalendarButton = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesCheckBox = $("#hobbiesWrapper"),
            uploadPictureButton = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitButton = $("#submit"),
            dateInput = $("#dateOfBirthInput");

    public StudentRegistrationForm openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public StudentRegistrationForm setFirstNameInput(String value){
        firstNameInput.setValue(value);

        return this;
    }

    public StudentRegistrationForm setLastNameInput(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public StudentRegistrationForm setEmailInput(String value){
        emailInput.setValue(value);

        return this;
    }

    public StudentRegistrationForm setGenderMaleRadio(){
        genderRadio.$(byText("Male")).click();

        return this;
    }

    public StudentRegistrationForm setGenderFemaleRadio(){
        genderRadio.$(byText("Female")).click();

        return this;
    }

    public StudentRegistrationForm setGenderOtherRadio(){
        genderRadio.$(byText("Other")).click();

        return this;
    }

    public StudentRegistrationForm setUserNumberInput(String value){
        userNumberInput.setValue(value);

        return this;
    }


    public StudentRegistrationForm setSubjectsInput(String value){
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public StudentRegistrationForm setHobbiesCheckBox(String value){
        hobbiesCheckBox.$(byText(value)).click();

        return this;
    }

    public StudentRegistrationForm setPicture(){
        uploadPictureButton.uploadFromClasspath("img.jpg");

        return this;
    }

    public StudentRegistrationForm setCurrentAddressInput(String value){
        currentAddressInput.setValue(value);

        return this;
    }

    public StudentRegistrationForm touchSubmitButton(){
        submitButton.click();

        return this;
    }

    public StudentRegistrationForm setStateInput(String value){
        stateInput.setValue(value).pressEnter();

        return this;
    }

    public StudentRegistrationForm setCityInput(String value){
        cityInput.setValue(value).pressEnter();

        return this;
    }

    public StudentRegistrationForm setDate(String month, String years, String day){
        dateInput.click();
        calendarComponent.setDateIntoCalendar(month, years, day);

        return this;
    }
}
