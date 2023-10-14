import java.util.Scanner;

public class Calculate {
    public static void main(String arg[]) {
        String user_input1, user_input2;
        double num1, num2;
        Scanner user_input = new Scanner(System.in);

        System.out.println("Input a:");
        user_input1 = user_input.nextLine();
        System.out.println("Input the b:");
        user_input2 = user_input.nextLine();

        num1 = Double.parseDouble(user_input1);
        num2 = Double.parseDouble(user_input2);

        System.out.println("Result: ");
        sum(num1, num2);
        difference(num1, num2);
        product(num1, num2);
        quotient(num1, num2);

        user_input.close();

    }

    public static void sum(double a, double b) {
        System.out.println("a + b = " + (a+b));
    }

    public static void difference(double a, double b) {
        System.out.println("a - b = " + (a-b));
    }

    public static void product(double a, double b) {
        System.out.println("a * b = " + (a*b));
    }

    public static void quotient(double a, double b) {
        if (b != 0) {
            System.out.println("a / b = " + (a/b));
        }else{
            System.out.println("a / b = no result");
        }
    }
}
