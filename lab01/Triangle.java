import java.util.Scanner;

public class Triangle {
    public static void main(String arg[]) {
            int num;
            Scanner input = new Scanner(System.in);

            num = input.nextInt();

            printStarTriangle(num);

            input.close();
    }

    public static void printStarTriangle(int num) {
        int n = 0;

        if (num % 2 == 0) n = 0;

        String array[][] = new String[num][num * 2 - n];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num * 2 - n; j++) {
                array[i][j] = " ";
            }
        }
        for (int i = 0; i < num; i++) {
            for (int j = num - n - i; j <= num + i; j++) {
                array[i][j] = "*";
            }
        }
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num * 2 - n; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }

    }
}
