import com.codeborne.selenide.Configuration;
import net.bytebuddy.build.Plugin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Demoqatestform {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFieldOnForm() {
        open("/automation-practice-form");

        $("#firstName").setValue("123");
        $("#lastName").setValue("123");
        $("#userEmail").setValue("123");
        $("#userNumber").setValue("1234567890");
        $("#currentAddress").setValue("123");
        $("#dateOfBirthInput").setValue("29 Nov 2002").pressEnter();
        $("#subjectsInput").setValue("Biology").pressEnter();

    }
}










