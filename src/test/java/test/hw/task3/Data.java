package test.hw.task3;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class Data {
    public static Stream<Arguments> additionalArguments() {
        return Stream.of(Arguments.of(5, 3, 15), Arguments.of(10, 10, 100));
    }
}
