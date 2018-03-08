package Day2;

import java.util.Scanner;

/**
 * Matrix Multiplication
 * @author rharutyunyan
 */
public class MatrixMultiplication {

    public static void main(String[] args) {
        int[][]Matrix1 = createMatrix();
        int[][]Matrix2 = createMatrix();
        System.out.println();
        System.out.println("The Result of multiplication is: ");
        int[][] ResultMatrix = multiplicator(Matrix1, Matrix2);
        printMatrix(ResultMatrix);
    }


    public static int[][] multiplicator(int[][] Matrix1, int[][] Matrix2) {

        int row_m1 = Matrix1.length;
        int col_m1 = Matrix1[0].length;
        int row_m2 = Matrix2.length;
        int col_m2 = Matrix2[0].length;

        if (col_m1 != row_m2) {
            throw new IllegalArgumentException("Number of Rows of Matrix1 doesn't match with number of Columns of Matrix 2.");
        }

        int[][] ResultMatrix = new int[row_m1][col_m2];
        for (int i = 0; i < row_m1; i++) {
            for (int j = 0; j < col_m2; j++) {
                ResultMatrix[i][j] = 0;
            }
        }

        for (int i = 0; i < row_m1; i++) { // aRow
            for (int j = 0; j < col_m2; j++) { // bColumn
                for (int k = 0; k < col_m1; k++) { // aColumn
                    ResultMatrix[i][j] += Matrix1[i][k] * Matrix2[k][j];
                }
            }
        }

        return ResultMatrix;
    }

    public static void printMatrix(int[][] Matrix){
        int row = Matrix.length;
        int col = Matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                System.out.print(Matrix[i][j] + " ");
            System.out.println();
        }
    }

    public static int[][] createMatrix(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Matrix's sizes(row , column) : ");
        int row1 = input.nextInt();
        int col1 = input.nextInt();
        System.out.println("Enter the Matrix: ");
        int[][]Matrix1 = new int[row1][col1];
        for(int i = 0 ; i < row1 ; i++)
            for(int j = 0 ; j < col1 ; j++)
                Matrix1[i][j] = input.nextInt();
        return Matrix1;
    }
}
