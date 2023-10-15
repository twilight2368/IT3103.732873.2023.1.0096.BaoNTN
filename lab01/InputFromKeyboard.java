import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String arg[]){
        String strName;
        int iAge;
        double dHeight;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What's your name?");
        strName = keyboard.nextLine();
        System.out.println("How old are you?");
        iAge = keyboard.nextInt();
        System.out.println("How tall are you (m)?");
        dHeight = keyboard.nextDouble();

        System.out.println("Mrs/Ms." + strName + " , " + iAge + " years old. " + "Your height is " + dHeight + ".");

        keyboard.close();
    }
}
