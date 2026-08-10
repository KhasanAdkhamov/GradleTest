package test.hw.task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PalindromeTest {
    @ParameterizedTest
    @ValueSource(strings = {"radar", "level", "a"})
    void isPalindromeTest(String value) {
        String reverse = new StringBuilder(value).reverse().toString();
        Assertions.assertEquals(value, reverse);

    }
}
