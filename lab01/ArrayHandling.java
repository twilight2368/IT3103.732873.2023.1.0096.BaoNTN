import java.util.Arrays;

public class ArrayHandling {
    public static void main(String arg[]){
        double[] array = {0, 2, 1, 4, 3 ,5};
        
        Arrays.sort(array);

        System.out.println(Arrays.toString(array));
        System.out.println("Sum: " + sum(array));
        System.out.println("Average: " + average(array));
        
    }

    public static double sum(double[] array){
        double sum = 0;
        for (double d : array) {
            sum += d;
        }
        return sum;
    }

    public static double average(double[] array){
        return sum(array)/(array.length);
    }
}
