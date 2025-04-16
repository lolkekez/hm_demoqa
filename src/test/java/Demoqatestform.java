import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import net.bytebuddy.build.Plugin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Demoqatestform {
    File pict = new File("src/resources/img.jpg");
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFieldOnForm() {
        open("/automation-practice-form");

        //заполнение формы
        $("#firstName").setValue("Oleg");
        $("#lastName").setValue("Safenreiter");
        $("#userEmail").setValue("1234567@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").setValue("29 Nov 2002").pressEnter();
        $("#subjectsInput").setValue("Biology").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(pict);
        $("#currentAddress").setValue("street 123");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        $("#submit").click();

        //проверка
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $("table").$("tbody").$("tr", 0).$("td", 0).shouldHave(text("Student Name"));
        $("table").$("tbody").$("tr", 0).$("td", 1).shouldHave(text("Oleg Safenreiter"));
        $("table").$("tbody").$("tr", 1).$("td", 0).shouldHave(text("Student Email"));
        $("table").$("tbody").$("tr", 1).$("td", 1).shouldHave(text("1234567@gmail.com"));
        $("table").$("tbody").$("tr", 2).$("td", 0).shouldHave(text("Gender"));
        $("table").$("tbody").$("tr", 2).$("td", 1).shouldHave(text("Male"));
        $("table").$("tbody").$("tr", 3).$("td", 0).shouldHave(text("Mobile"));
        $("table").$("tbody").$("tr", 3).$("td", 1).shouldHave(text("1234567890"));
        $("table").$("tbody").$("tr", 4).$("td", 0).shouldHave(text("Date of Birth"));
        //$("table").$("tbody").$("tr", 4).$("td", 1).shouldHave(text(""));
        $("table").$("tbody").$("tr", 5).$("td", 0).shouldHave(text("Subject"));
        $("table").$("tbody").$("tr", 5).$("td", 1).shouldHave(text("Biology"));
        $("table").$("tbody").$("tr", 6).$("td", 0).shouldHave(text("Hobbies"));
        $("table").$("tbody").$("tr", 6).$("td", 1).shouldHave(text("Sports"));
        $("table").$("tbody").$("tr", 7).$("td", 0).shouldHave(text("Picture"));
        $("table").$("tbody").$("tr", 7).$("td", 1).shouldHave(text("img.jpg"));
        $("table").$("tbody").$("tr", 8).$("td", 0).shouldHave(text("Address"));
        $("table").$("tbody").$("tr", 8).$("td", 1).shouldHave(text("street 123"));
        $("table").$("tbody").$("tr", 9).$("td", 0).shouldHave(text("State and City"));
        $("table").$("tbody").$("tr", 9).$("td", 1).shouldHave(text("NCR Noida"));

    }
}










