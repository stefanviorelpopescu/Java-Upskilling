package tdd;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Calculator calculator = new Calculator();

        Scanner scanner = new Scanner(System.in);

        int firstNumber = scanner.nextInt();
        String operationFromInput = scanner.next();
        int secondNumber = scanner.nextInt();

        int result = calculator.compute(firstNumber, secondNumber, Operation.fromInput(operationFromInput));

        System.out.println(firstNumber + " " + operationFromInput + " " + secondNumber + " = " + result);

    }

}
