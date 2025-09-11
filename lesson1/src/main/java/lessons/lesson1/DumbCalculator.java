package lessons.lesson1;

import java.util.Arrays;
import java.util.List;


record Arguments(Double number1, String operation, Double number2) {
}


public class DumbCalculator {

    static List<String> operations = Arrays.asList("+", "-", "*", "/");

    public DumbCalculator(int dumpLevel) {
        System.out.println("DumbCalculator( " + dumpLevel + ")");
    }

    private Arguments serializeArgs(String[] args) {

        if (args.length != 3) {
            throw new IllegalArgumentException("Expected 3 arguments: number1 operation number2");
        }
        try {
            Double.parseDouble(args[0]);
            Double.parseDouble(args[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Expected numbers as arguments");
        }
        if (!DumbCalculator.operations.contains(args[1])) {
            throw new IllegalArgumentException("Expected operation as argument from list " + DumbCalculator.operations);
        }
        return new Arguments(Double.parseDouble(args[0]), args[1], Double.parseDouble(args[2]));

    }

    public double calculate(String[] args) {

        Arguments arguments = serializeArgs(args);
        System.out.println("Arguments: " + arguments);
        double number1 = arguments.number1();
        String operation = arguments.operation();
        double number2 = arguments.number2();

        switch (operation) {
            case "+" -> {
                return add(number1, number2);
            }
            case "-" -> {
                return subtract(number1, number2);
            }
            case "*" -> {
                return multiply(number1, number2);
            }
            case "/" -> {
                return divide(number1, number2);
            }
            default -> throw new IllegalArgumentException("Unknown operation: " + operation);
        }
    }

    private double add(double number1, double number2) {
        return number1 + number2;
    }

    private double subtract(double number1, double number2) {
        return number1 - number2;
    }

    private double multiply(double number1, double number2) {
        return number1 * number2;
    }

    private double divide(double number1, double number2) {
        return number1 / number2;
    }

}
