package hust.soict.hedspi.lab01;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kich thuoc cua mang: ");
        int size = scanner.nextInt();

        
        double[] array = new double[size];

       
        System.out.println("Nhap cac phan tu caa mang:");
        for (int i = 0; i < size; i++) {
            System.out.print("Phan tu " + (i + 1) + ": ");
            array[i] = scanner.nextDouble();
        }

      
        Arrays.sort(array);

      
        double sum = 0;
        for (double num : array) {
            sum += num;
        }
        double average = sum / size;

        
        System.out.println("Mang đa sap xep: " + Arrays.toString(array));
        System.out.println("Tong cac phan tu trong mang: " + sum);
        System.out.println("Gia tri trung binh cua cac phan tu trong mang: " + average);
    }
}
