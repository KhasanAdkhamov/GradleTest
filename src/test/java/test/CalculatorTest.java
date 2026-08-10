package test;

import org.junit.jupiter.api.*;

public class CalculatorTest {
    @Test
    public void myFirstTest() {
        System.out.println("Hello world");
        Assertions.assertEquals(10, 5 + 5);
    }
    @Test
    public void print() {
        System.out.println("between");
    }

    @BeforeEach
    public void mySecondTest() {
        System.out.println("запуск перед каждым тестом");
    }
    @AfterEach
    public void  myThirdTest() {
        System.out.println("end");
    }

    @AfterAll
    public static void printRe() {
        System.out.println("that is all");
    }
}
