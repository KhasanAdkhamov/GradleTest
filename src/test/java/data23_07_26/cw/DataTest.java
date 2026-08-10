package data23_07_26.cw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class DataTest {
    @ParameterizedTest
    @CsvSource({"15, 15, 30", "10, 10, 20", "40, 40, 80"})
    public void parametrizedTest(int a, int b, int result) {
        Assertions.assertEquals(result, a + b);

    }

    @ParameterizedTest
    @MethodSource("data23_07_26.cw.Data#findUsers")
    public void testWithParam(String param) {
        System.out.println(param);
    }
}
