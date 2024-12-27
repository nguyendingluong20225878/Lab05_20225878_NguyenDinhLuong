import java.util.Scanner;

public class EquationSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

  
        System.out.println("Phuong trinh bac nhat (ax + b = 0):");
        System.out.print("Nhap a: ");
        double a1 = scanner.nextDouble();
        System.out.print("Nhap b: ");
        double b1 = scanner.nextDouble();
        solveFirstDegreeEquation(a1, b1);


        System.out.println("\nHe phuong trinh bac nhat hai an:");
        System.out.print("Nhap A11: ");
        double A11 = scanner.nextDouble();
        System.out.print("Nhap A12: ");
        double A12 = scanner.nextDouble();
        System.out.print("Nhap b1: ");
        double b2 = scanner.nextDouble();
        System.out.print("Nhap A21: ");
        double A21 = scanner.nextDouble();
        System.out.print("Nhap A22: ");
        double A22 = scanner.nextDouble();
        System.out.print("Nhap b2: ");
        double b3 = scanner.nextDouble();
        solveSystemOfEquations(A11, A12, b2, A21, A22, b3);


        System.out.println("\nPhuong trinh bac hai (ax^2 + bx + c = 0):");
        System.out.print("Nhap a: ");
        double a2 = scanner.nextDouble();
        System.out.print("Nhap b: ");
        double b4 = scanner.nextDouble();
        System.out.print("Nhap c: ");
        double c = scanner.nextDouble();
        solveSecondDegreeEquation(a2, b4, c);
    }


    public static void solveFirstDegreeEquation(double a, double b) {
        if (a == 0) {
            if (b == 0) {
                System.out.println("PT VSN.");
            } else {
                System.out.println("PT VN.");
            }
        } else {
            double x = -b / a;
            System.out.println("x = " + x);
        }
    }

    
    public static void solveSystemOfEquations(double A11, double A12, double b1, double A21, double A22, double b2) {
        double D = A11 * A22 - A21 * A12;
        double D1 = b1 * A22 - b2 * A12;
        double D2 = A11 * b2 - A21 * b1;

        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                System.out.println("HPT VSN.");
            } else {
                System.out.println("HPT VN.");
            }
        } else {
            double X1 = D1 / D;
            double X2 = D2 / D;
            System.out.println(" X1 = " + X1 + ", X2 = " + X2);
        }
    }


    public static void solveSecondDegreeEquation(double a, double b, double c) {
        if (a == 0) {
            solveFirstDegreeEquation(b, c);
            return;
        }

        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Phuong trinh co hai nghiem phan biet: x1 = " + x1 + ", x2 = " + x2);
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            System.out.println("Phuong trinh co nghiem kep: x = " + x);
        } else {
            System.out.println("Phuong trinh vo nghiem .");
        }
    }
}
