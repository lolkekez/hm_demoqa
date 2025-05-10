package pages.components;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public CalendarComponent setDateIntoCalendar(String month, String years, String day){
        $(".react-datepicker__month-select").shouldBe(visible, Duration.ofSeconds(10));
        $(".react-datepicker__year-select").selectOption(years);
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker").$(byText(day)).click();

        return this;
    }
}
