package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;



public class ResultCheckComponent {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userNumberInput = $("#userNumber");

    public ResultCheckComponent checkResult(String key, String value){
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));

        return this;
    }
    public ResultCheckComponent checkNegativeResult(){
        firstNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        lastNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        userNumberInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

        return this;
    }
}
