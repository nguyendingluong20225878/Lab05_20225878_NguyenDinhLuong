package hust.soict.hedspi.lab01;
import java.util.Scanner;
//import de khai bao lop ma khong can goi day du
//Scanner nhap du lieu tu ban phim

public class SoNgayTrongThang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String thangNhap;
        int nam;

        while (true) {
         
            System.out.print("Nhap thang: ");
            thangNhap = scanner.nextLine().trim().toLowerCase();
//scanner.nextLine: doc toan bo van ban
//trim(): loai bo khoang trăng vd " lon" --> "lon"
//.toLowerCase() : chuyen tat ca thanh chu thuong vd "LON" --> "lon"
         
            System.out.print("Nhap nam: ");
            if (scanner.hasNextInt()) {//.hasNextInt 
                nam = scanner.nextInt();
                scanner.nextLine(); 
                if (nam < 0) {
                    System.out.println("Nam phai la so khong am. Vui long nhap lai.");
                    continue;
                }
            } else {
                System.out.println("Gia tri nhap cho nam khong hop le. Vui long nhap lai.");
                scanner.nextLine(); 
                continue;
            }

           
            int thang = layThangTuNhap(thangNhap);
            if (thang == -1) {
                System.out.println("Gia tri nhap cho nam khong hop le. Vui long nhap lai.");
                continue;
            }

     
            int soNgay = laySoNgayTrongThang(thang, nam);
            System.out.println("Thang " + thangNhap + " trong nam " + nam + " co " + soNgay + " ngay.");
            break;
        }

        scanner.close();
    }

   
    public static int layThangTuNhap(String thangNhap) {
        switch (thangNhap) {
            case "january": case "jan.": case "jan": case "1": return 1;
            case "february": case "feb.": case "feb": case "2": return 2;
            case "march": case "mar.": case "mar": case "3": return 3;
            case "april": case "apr.": case "apr": case "4": return 4;
            case "may": case "5": return 5;
            case "june": case "jun.": case "jun": case "6": return 6;
            case "july": case "jul.": case "jul": case "7": return 7;
            case "august": case "aug.": case "aug": case "8": return 8;
            case "september": case "sept.": case "sep": case "9": return 9;
            case "october": case "oct.": case "oct": case "10": return 10;
            case "november": case "nov.": case "nov": case "11": return 11;
            case "december": case "dec.": case "dec": case "12": return 12;
            default: return -1; 
        }
    }

   
    public static int laySoNgayTrongThang(int thang, int nam) {
        switch (thang) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return laNamNhuan(nam) ? 29 : 28;
            default:
                return 0; 
        }
    }

   
    public static boolean laNamNhuan(int nam) {
        if (nam % 4 == 0) {
            if (nam % 100 == 0) {
                return nam % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }
}
