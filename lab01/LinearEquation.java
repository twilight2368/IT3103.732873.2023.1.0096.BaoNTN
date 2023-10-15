import java.util.Scanner;

public class LinearEquation {
    public static void main(String arg[]){
        handlingPorblem();
    }

    public static void handlingPorblem(){
        int a;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Choose one option below:");
        System.out.println("1. First Degree Equation With One Variable");
        System.out.println("2. First Degree Equation With Two Variables");
        System.out.println("3. Second Degree Equation With One Variable");
        System.out.println("Other. Exit");
        System.out.print("Input: ");
        a = myScanner.nextInt();

        switch (a) {
            case 1:
                firstDegreeEquationOneVariable();
                break;
            case 2:
                firstDegreeEquationTwoVariables();
                break;
            case 3:
                secondDegreeEquationOneVariable();
                break;        
            default:
                break;
        }

         myScanner.close();
    }

    public static void firstDegreeEquationOneVariable(){
        double coefficient[] = new double[2];

        System.out.println("Equation ax+b=0");
        Scanner input = new Scanner(System.in);
        System.out.print("Input:");
        coefficient[0] = input.nextDouble();
        coefficient[1] = input.nextDouble();

        if (coefficient[0] == 0 && coefficient[1] == 0) {
            System.out.println("Equation always has solution for every x");
        } else if (coefficient[0] == 0 && coefficient[1] != 0) {
            System.out.println("Equation has no solution for x");
        } else {
            System.out.println("x: " + (-coefficient[1]) / coefficient[0]);
        }

        input.close();
    }

    public static void firstDegreeEquationTwoVariables(){
        double[] equation1 = new double[3];
        double[] equation2 = new double[3];
        double x1, x2;
        double det;
        Scanner input = new Scanner(System.in);
        System.out.println("INput line 1 (a1 b1 c1): ");
        for (int i = 0; i < equation1.length; i++) {
            equation1[i] = input.nextDouble();
        }

        System.out.println("INput line 2 (a2 b2 c2): ");
        for (int i = 0; i < equation2.length; i++) {
            equation2[i] = input.nextDouble();
        }

        det = equation1[0] * equation2[1] - equation1[1] * equation2[0];

        if (det != 0) {
            x1 = (equation1[2] * equation2[1] - equation1[1] * equation2[2]) / det;
            x2 = (equation1[0] * equation2[2] - equation1[2] * equation2[0]) / det;
            System.out.println("x1: " + x1);
            System.out.println("x2: " + x2);
        } else {
            System.out.println("The equations have no solution");
        }
        input.close();
    }

    public static void secondDegreeEquationOneVariable(){
        double a, b, c;
        double delta;
        double x, x1, x2;

        Scanner input = new Scanner(System.in);

        System.out.print("Input a*x^2 + b*x + c:");
        a = input.nextDouble();
        b = input.nextDouble();
        c = input.nextDouble();

        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Every x are solutions");
                } else {
                    System.out.println("No solution");
                }
            } else {
                System.out.println("x: " + c / b);
            }
        } else {
            delta = b * b - 4 * a * c;

            if (delta < 0) {
                System.out.println("No solution");
            } else if (delta == 0) {
                x = -b / (2 * a);
                System.out.println("x: " + x);
            } else {
                x1 = (-b - Math.sqrt(delta)) / (2 * a);
                x2 = (-b + Math.sqrt(delta)) / (2 * a);
                System.out.println("x1: " + x1);
                System.out.println("x2: " + x2);
            }
        }

        input.close();
    }
}
