package hust.soict.hedspi.lab01;
import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Hang ma tran: ");
        int rows = scanner.nextInt();
        System.out.print("Cot ma tran: ");
        int cols = scanner.nextInt();

        
        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];

        
        System.out.println("Phan tu cua ma tran 1:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Phan tu [" + i + "][" + j + "]: ");
                matrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Phan tu cua ma tran 2:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Phan tu [" + i + "][" + j + "]: ");
                matrix2[i][j] = scanner.nextInt();
            }
        }

       
        int[][] resultMatrix = new int[rows][cols];

      
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        
        System.out.println("Ket qua:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
