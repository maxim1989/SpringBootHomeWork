package pro.sky.mlfedorov.sandbox.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceImplParameterizedTest {
    private final CalculatorServiceImpl out = new CalculatorServiceImpl();

    @ParameterizedTest
    @MethodSource("provideParamsForSuccessfulPlus")
    public void shouldReturnValidSum(Integer num1, Integer num2, Integer expected) {
        Integer result = out.plus(num1, num2);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForSuccessfulMinus")
    public void shouldReturnValidDiff(Integer num1, Integer num2, Integer expected) {
        Integer result = out.minus(num1, num2);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForSuccessfulMultiply")
    public void shouldReturnValidMultiply(Integer num1, Integer num2, Integer expected) {
        Integer result = out.multiply(num1, num2);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForSuccessfulDivide")
    public void shouldReturnValidDivide(Integer num1, Integer num2, Double expected) {
        Double result = out.divide(num1, num2);
        assertEquals(expected, result);
    }

    public static Stream<Arguments> provideParamsForSuccessfulPlus() {
        return Stream.of(
                Arguments.of(3, 2, 5),
                Arguments.of(1, 0, 1)
        );
    }

    public static Stream<Arguments> provideParamsForSuccessfulMinus() {
        return Stream.of(
                Arguments.of(7, 2, 5),
                Arguments.of(1, 0, 1)
        );
    }

    public static Stream<Arguments> provideParamsForSuccessfulMultiply() {
        return Stream.of(
                Arguments.of(3, 2, 6),
                Arguments.of(1, 1, 1)
        );
    }

    public static Stream<Arguments> provideParamsForSuccessfulDivide() {
        return Stream.of(
                Arguments.of(12, 2, 6.0),
                Arguments.of(3, 2, 1.5)
        );
    }
}
