import java.util.Arrays;

public class AddMatrix {
    public static void main(String arg[]) {
        double[][] matrix1 = {  { 0, 1, 2 },
                                { 0, 1, 2 },
                                { 0, 1, 2 } };
                                
        double[][] matrix2 = {  { 0, 2, 3 },
                                { 0, 2, 3 },
                                { 0, 2, 3 } };

        double[][] matrix3 = new double[3][3];

        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix3[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
 
        for (double[] ds : matrix3) {
            System.out.println(Arrays.toString(ds));
        };
        
    }
}
