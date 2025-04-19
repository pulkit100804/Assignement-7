import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Welcome to the Java Calculator! =====");
        System.out.println("Available operations:");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Square");
        System.out.println("6. Cube");
        System.out.println("7. Square Root");
        System.out.println("0. Exit");

        while (true) {
            System.out.print("\nEnter your choice of operation (0 to exit): ");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer choice.");
                sc.nextLine();
                continue;
            }

            if (choice == 0) {
                System.out.println("Exiting the calculator. Goodbye!");
                break;
            }

            double num1 = 0, num2 = 0;


            try {
                if (choice >= 1 && choice <= 4) {

                    System.out.print("Enter first number: ");
                    num1 = sc.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = sc.nextDouble();
                } else if (choice == 5 || choice == 6 || choice == 7) {

                    System.out.print("Enter a number: ");
                    num1 = sc.nextDouble();
                } else {
                    System.out.println("Invalid operation choice.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid number format. Please try again.");
                sc.nextLine();
                continue;
            }


            try {
                double result = 0;
                switch (choice) {
                    case 1:
                        result = Calculator.add(num1, num2);
                        break;
                    case 2:
                        result = Calculator.subtract(num1, num2);
                        break;
                    case 3:
                        result = Calculator.multiply(num1, num2);
                        break;
                    case 4:
                        result = Calculator.divide(num1, num2);
                        break;
                    case 5:
                        result = Calculator.square(num1);
                        break;
                    case 6:
                        result = Calculator.cube(num1);
                        break;
                    case 7:
                        result = Calculator.squareRoot(num1);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        continue;
                }
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Error in arithmetic operation: " + e.getMessage());
            }
        }


        sc.close();
    }
}
