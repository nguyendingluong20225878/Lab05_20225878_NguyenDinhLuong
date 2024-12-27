package hust.soict.dsai.test.disc;


import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter { 
    
    public static void main(String[] args) {

        // Tạo các đối tượng DigitalVideoDisc
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

       
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        // Hoán đổi DVD
        swap(jungleDVD, cinderellaDVD);

       
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        // Thay đổi tiêu đề của DVD
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
       
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    // Phương thức hoán đổi tiêu đề giữa hai DVD
    public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        // Hoán đổi tiêu đề của hai DVD
        String tempTitle = dvd1.getTitle();
        dvd1.setTitle(dvd2.getTitle());
        dvd2.setTitle(tempTitle);
    }

    // Phương thức thay đổi tiêu đề DVD
    public static void changeTitle(DigitalVideoDisc dvd, String newTitle) {
        dvd.setTitle(newTitle);
    }
}
