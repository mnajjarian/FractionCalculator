
import java.util.Scanner;

public class FractionCalculator {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        //Write a short introduction method that describes the calculator program and welcomes your user
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, substract, multiply and divide fractions until you type Q to quit");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
        System.out.println("---------------------------------------------------------------------------------");

        while (true) {
            String operation = getOperation();
            Fraction frac1 = getFraction();
            Fraction frac2 = getFraction();

            switch (operation) {
                case "+": {
                    Fraction cal = frac1.add(frac2);
                    System.out.println(frac1.toString() + " + " + frac2.toString() + " = " + cal.toString());
                    break;
                }
                case "/": {
                    Fraction cal = frac1.divide(frac2);
                    System.out.println(frac1.toString() + " + " + frac2.toString() + " = " + cal.toString());
                    break;
                }
                case "*": {
                    Fraction cal = frac1.multiply(frac2);
                    System.out.println(frac1.toString() + " * " + frac2.toString() + " = " + cal.toString());
                    break;
                }
                case "-": {
                    Fraction cal = frac1.subtract(frac2);
                    System.out.println(frac1.toString() + " - " + frac2.toString() + " = " + cal.toString());
                    break;
                }
                default:
                    boolean answer = frac1.equals(frac2);
                    System.out.println(frac1.toString() + " = " + frac2.toString() + " is " + answer);
                    break;
            }
            System.out.println("-------------------------------------------------------------------------");
        }
    }

    public static String getOperation() { //Ask the user to enter in an operation
        System.out.print("please enter an operation (+, -, /, *, = or Q to quit): ");
        String operation = input.next();
        if (operation.equals("q")) {
            System.exit(0);
        }
        if (!validOperation(operation)) {
            while (!validOperation(operation)) {
                System.out.print("Invalid input (+, -, /, *, = or Q to quit): ");
                operation = input.next();
                if (operation.equals("q")) {
                    System.exit(0);
                }
            }
        }
        return operation;
    }

    private static Fraction getFraction() {
        System.out.print("please enter a fraction (a/b) or integer (a): ");
        String fraction = input.next();
        if (!validFraction(fraction)) {
            while (!validFraction(fraction)) {
                System.out.print(
                        "Invalid Fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero: ");
                fraction = input.next();
            }
        }
        int[] xy = new int[2];

        if (fraction.contains("/")) {
            String[] split = fraction.split("/");
            xy[0] = Integer.parseInt(split[0]);
            xy[1] = Integer.parseInt(split[1]);
        } else {
            xy[0] = Integer.parseInt(fraction);
            xy[1] = 1;
        }

        return new Fraction(xy[0], xy[1]);
    }

    public static boolean validOperation(String s) {
        return s.equals("=") || s.equals("+") || s.equals("/") || s.equals("*") || s.equals("-");
    }

    public static boolean validFraction(String s) {
        if (s.contains("/")) {
            String[] split = s.split("/");
            if (split[0].matches("-?\\d+")) {
                if (split[1].matches("-?\\d+")) {
                    int data1 = Integer.parseInt(split[1]);
                    return data1 > 0;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return s.matches("-?\\d+");
        }
    }

}
