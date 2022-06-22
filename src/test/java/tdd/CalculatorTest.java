package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tdd.Operation.*;

class CalculatorTest
{
    static final int FIRST_NUMBER = 7;
    static final int SECOND_NUMBER = 5;

    Calculator calculator = new Calculator();

    static Operation [] operations = new Operation[] {PLUS, MINUS, TIMES, DIVIDE};
    static int [] results = new int[] {FIRST_NUMBER+SECOND_NUMBER, FIRST_NUMBER-SECOND_NUMBER, FIRST_NUMBER*SECOND_NUMBER, FIRST_NUMBER/SECOND_NUMBER};
    static String [] assertErrors = new String[] {"Result should be the sum of the two numbers",
            "Result should be the difference of the two numbers",
            "Result should be the multiplication of the two numbers",
            "Result should be the integer division of the two numbers"};

    @ParameterizedTest
    @MethodSource("provideParameters")
    public void testBasicOperations(Operation operation, int expectedResult, String errorMessage) {

        int result = calculator.compute(FIRST_NUMBER, SECOND_NUMBER, operation);
        assertEquals(expectedResult, result, errorMessage);

    }

    private static Stream<Arguments> provideParameters() {
        Stream<Arguments> argumentsStream = Stream.empty();
        for (int i = 0; i < operations.length; i++) {
            argumentsStream = Stream.concat(argumentsStream, Stream.of(Arguments.of(operations[i], results[i], assertErrors[i])));
        }
        return argumentsStream;
    }

    @Disabled
    @Test
    public void pseudoParametrizedTest()
    {
        for (int i = 0; i < operations.length; i++)
        {
            int result = calculator.compute(FIRST_NUMBER, SECOND_NUMBER, operations[i]);
            assertEquals(results[i], result, assertErrors[i]);
        }
    }


    @Disabled
    @Test
    public void whenOperationIsPlusReturnSum() {
        //given
        Operation operation = PLUS;

        //when
        int result = calculator.compute(FIRST_NUMBER, SECOND_NUMBER, operation);

        //then
        assertEquals(FIRST_NUMBER + SECOND_NUMBER, result, "Result should be the sum of the two numbers");
    }

    @Disabled
    @Test
    public void whenOperationIsMinusReturnDifference() {
        //given
        Operation operation = MINUS;

        //when
        int result = calculator.compute(FIRST_NUMBER, SECOND_NUMBER, operation);

        //then
        assertEquals(FIRST_NUMBER - SECOND_NUMBER, result, "Result should be the difference of the two numbers");
    }

    @Disabled
    @Test
    public void whenOperationIsTimesReturnMultiplication() {
        //given
        Operation operation = TIMES;

        //when
        int result = calculator.compute(FIRST_NUMBER, SECOND_NUMBER, operation);

        //then
        assertEquals(FIRST_NUMBER * SECOND_NUMBER, result, "Result should be the multiplication of the two numbers");
    }

    @Disabled
    @Test
    public void whenOperationIsDivideReturnDivision() {
        //given
        Operation operation = DIVIDE;

        //when
        int result = calculator.compute(FIRST_NUMBER, SECOND_NUMBER, operation);

        //then
        assertEquals(FIRST_NUMBER / SECOND_NUMBER, result, "Result should be the integer division of the two numbers");
    }

    @Test
    public void whenOperationIsDivideAndSecondNumberIsZeroThrowException() {
        //given
        int secondNumber = 0;
        Operation operation = DIVIDE;

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.compute(FIRST_NUMBER, secondNumber, operation));

        //then
        assertEquals("No Division by 0 allowed", exception.getMessage(), "Wrong exception message");
    }

}