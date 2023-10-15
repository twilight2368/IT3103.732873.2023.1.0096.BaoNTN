import java.util.Arrays;
import java.util.Scanner;

public class Calendar {

    public static int[] month31days = { 1, 3, 5, 7, 8, 10, 12 };
    public static int[] month30days = { 4, 6, 9, 11 };
    public static String[][] validMonth = {
            { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" },
            { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" },
            { "Jan.", "Feb.", "Mar.", "Apr.", "May.", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec." },
    };

    public static void main(String arg[]) {
        int month;
        int year;
        String monthStr;

        Scanner input = new Scanner(System.in);
        
        System.out.print("INPUT month: ");
        monthStr = input.nextLine();
        System.out.print("INPUT year: ");
        year = input.nextInt();

        try {
            month = Integer.parseInt(monthStr);
            ouputDay(month, year);
        } catch (Exception e) {
            ouputDay(monthStr, year);
        }

        input.close();
    }

    public static boolean checkLeap(int year) {
        if (year % 4 == 0) {
            if (year % 400 == 0) {
                return true;
            } else if (year % 100 == 0) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    //Convert string month to int month
    public static int findMonth(String month) {
        for (int i = 0; i < validMonth.length; i++) {
            for (int j = 0; j < validMonth[i].length; j++) {
                if (validMonth[i][j].equals(month)) {
                    return j + 1;
                }
            }
        }
        return -1;
    }

    public static void ouputDay(String month, int year) {
        int monthInt = findMonth(month);
        ouputDay(monthInt, year);
    }

    
    public static void ouputDay(int month, int year) {
        if (year < 0) {
            System.out.println("Invalid input");
        } else {
            if (Arrays.binarySearch(month31days, month) >= 0) {
                System.out.println(31);
            } else if (Arrays.binarySearch(month30days, month) >= 0) {
                System.out.println(30);
            } else if (month == 2) {
                if (checkLeap(year)) {
                    System.out.println(29);
                } else {
                    System.out.println(28);
                }
            } else {
                System.out.println("Invalid input");
            }
        }
    }
}
