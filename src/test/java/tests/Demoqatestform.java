package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import net.bytebuddy.build.Plugin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Tag("Demoqa_clear_selenide")
public class Demoqatestform {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFieldOnFormTest() {
        open("/automation-practice-form");

        //Заполнение формы
        $("#firstName").setValue("Oleg");
        $("#lastName").setValue("Safenreiter");
        $("#userEmail").setValue("1234567@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").shouldBe(visible, Duration.ofSeconds(10));
        $(".react-datepicker__year-select").selectOption("2002");
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker").$(byText("1")).click();
        $("#subjectsInput").setValue("Biology").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img.jpg");
        $("#currentAddress").setValue("street 123");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        $("#submit").click();

        //Проверка
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Oleg Safenreiter"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("1234567@gmail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1234567890"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("1 November,2002"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Biology"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("img.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("street 123"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Noida"));
    }

    @Test
    void negativeTest() {
        open("/automation-practice-form");

        $("#submit").click();


    }
}










