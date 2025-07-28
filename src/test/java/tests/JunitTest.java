package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;

@Tag("Junit tests")
public class JunitTest {
    @BeforeEach
    void setUp() {
        open("https://market.yandex.ru/");
    }

    @ParameterizedTest(name = "В результате поиска по товарам {0} отображаем категории фильтров в сайдбаре")
    @Tag("BLOCKER")
    @ValueSource(strings = {
            "Шорты",
            "Футболка",
            "Штаны"
    })
    void sideBarShouldBeHaveSectionForFashionTest(String searchQuery) {
        $("#header-search").setValue(searchQuery).pressEnter();
        $$("[data-zone-name='categoryFilterItem']").shouldHave(sizeGreaterThan(0));
    }

    @ParameterizedTest(name = "В результате поиска по товарам {0} отображаем категории фильтров в зависимости от товара")
    @Tag("BLOCKER")
    @CsvSource(value = {
            "Шорты, Шорты для взрослых",
            "Футболка, Футболки для взрослых",
            "Штаны, Брюки для взрослых"
    })
    void sideBarShouldBeHaveParametrizedFilterForFashionTest(String searchQuery, String expectedFilter) {
        $("#header-search").setValue(searchQuery).pressEnter();
        $("[data-zone-name='categoryFilter']").shouldHave(text(expectedFilter));
    }

    @ParameterizedTest(name = "В результате поиска по напиткам {0} отображаем категории фильтров ")
    @Tag("BLOCKER")
    @CsvFileSource(resources = "/test_data/sideBarShouldBeHaveParametrizedFilterForDevice.csv")
    void sideBarShouldBeHaveParametrizedFilterForDeviceTest(String searchQuery, String expectedFilter1) {
        $("#header-search").setValue(searchQuery).pressEnter();
        $("[data-grabber='SearchFilters']").shouldHave(text(expectedFilter1));
    }
}

