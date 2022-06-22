package tdd;

public class Calculator
{
    public int compute(int firstNumber, int secondNumber, Operation operation)
    {
        switch (operation) {
            case PLUS:
                return firstNumber + secondNumber;
            case MINUS:
                return firstNumber - secondNumber;
            case TIMES:
                return firstNumber * secondNumber;
            case DIVIDE:
                if (secondNumber == 0 ) {
                    throw new IllegalArgumentException("No Division by 0 allowed");
                }
                return firstNumber / secondNumber;
            case MOD:
                throw new UnsupportedOperationException("MOD not supported yet");
        }
        return 42;
    }
}
