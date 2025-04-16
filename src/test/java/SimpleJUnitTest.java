import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleJUnitTest {
    @Test
    void simpleone() {
        Assertions.assertTrue(3 > 1);
    }

    @Test
    void simpletwo() {
        Assertions.assertTrue(3 > 1);
    }

    @Test
    void simplethirten() {
        Assertions.assertTrue(3 > 1);
    }
}










