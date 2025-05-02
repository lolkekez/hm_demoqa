package pages.Components;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public CalendarComponent prepareDataCalendar(String month, String years, String day){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").shouldBe(visible, Duration.ofSeconds(10));
        $(".react-datepicker__year-select").selectOption(years);
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker").$(byText(day)).click();

        return this;
    }
}
