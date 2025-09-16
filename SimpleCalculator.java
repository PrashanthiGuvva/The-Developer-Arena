import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continueCalc = true;
        while (continueCalc) {
            System.out.print("Enter first number: ");
            double num1 = sc.nextDouble();
            System.out.print("Enter operator (+, -, *, /): ");
            char operator = sc.next().charAt(0);
            System.out.print("Enter second number: ");
            double num2 = sc.nextDouble();
            double result = 0;
            boolean valid = true;
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Error! Division by zero.");
                        valid = false;
                    }
                    break;
                default:
                    System.out.println("Invalid operator!");
                    valid = false;
            }

            if (valid) {
                System.out.println("Result: " + result);
            }
            System.out.print("Do you want to perform another operation? (yes/no): ");
            String choice = sc.next();
            if (choice.equalsIgnoreCase("no")) {
                continueCalc = false;
            }
        }

        System.out.println("Calculator closed. Goodbye!");
        sc.close();
    }
}
