package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

    @Step("Открываем страницу Demoqa automation-practice-form")
    public StudentRegistrationForm openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    @Step("Вводим Имя {value}")
    public StudentRegistrationForm setFirstNameInput(String value){
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Водим Фамилию {value}")
    public StudentRegistrationForm setLastNameInput(String value){
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Вводим email {value}")
    public StudentRegistrationForm setEmailInput(String value){
        emailInput.setValue(value);

        return this;
    }

    @Step("Выбарем пол {value}")
    public StudentRegistrationForm setGenderRadio(String value){
        genderRadio.$(byText(value)).click();

        return this;
    }

    @Step("Вводим номер телефона {value}")
    public StudentRegistrationForm setUserNumberInput(String value){
        userNumberInput.setValue(value);

        return this;
    }

    @Step("Выбираем сабжекты {value}")
    public StudentRegistrationForm setSubjectsInput(String value){
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Выбираем хобби {value}")
    public StudentRegistrationForm setHobbiesCheckBox(String value){
        hobbiesCheckBox.$(byText(value)).click();

        return this;
    }

    @Step("Загружаем картинку {value}")
    public StudentRegistrationForm setPicture(String value){
        uploadPictureButton.uploadFromClasspath(value);

        return this;
    }

    @Step("Вводим адрес {value}")
    public StudentRegistrationForm setCurrentAddressInput(String value){
        currentAddressInput.setValue(value);

        return this;
    }

    @Step("Жмем на кнопку сабмита")
    public StudentRegistrationForm touchSubmitButton(){
        submitButton.click();

        return this;
    }

    @Step("Выбираем state {value}")
    public StudentRegistrationForm setStateInput(String value){
        stateInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Выбираем city {value}")
    public StudentRegistrationForm setCityInput(String value){
        cityInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Вводим дату {day} {month} {years}")
    public StudentRegistrationForm setDate(String month, String years, String day){
        dateInput.click();
        calendarComponent.setDateIntoCalendar(month, years, day);

        return this;
    }
}
