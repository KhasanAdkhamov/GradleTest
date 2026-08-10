package test.hw.task3;

import org.example.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void initialization() {
        calculator = new Calculator();
    }

    @AfterEach
    void close() {
        calculator = null;
    }


    @ParameterizedTest
    @CsvSource({"10, 20, 30", "15, 20, 35", "20, 15, 35"})
    void shouldAddNumbers(int a,  int b, int result) {
        Assertions.assertEquals(result, calculator.add(a, b));
    }

    @ParameterizedTest
    @MethodSource("test.hw.task3.Data#additionalArguments")
    void shouldBeMultiply(int a, int b, int result) {
        Assertions.assertEquals(result, calculator.multiply(a, b));
    }

    @ParameterizedTest
    @CsvSource({"1, 1, 1", "0, 2, 0", "10, 5, 2"})
    void divide1(int a, int b, int result) {
        Assertions.assertEquals(result, calculator.divide(a, b));
    }

    @Test
    void testAssert() {
        Assertions.assertAll(() -> Assertions.assertEquals(5, calculator.add(3,2)),
                ()-> Assertions.assertEquals(10, calculator.subtract(30, 15)),
                ()-> Assertions.assertEquals(20, calculator.multiply(10, 10)),
                ()-> Assertions.assertEquals(100, calculator.divide(1000, 10)));
    }
}
