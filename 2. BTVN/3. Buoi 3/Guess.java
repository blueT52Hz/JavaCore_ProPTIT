import java.util.List;
import java.util.Scanner;

public class Guess {
    public static List<Book> books = BookManagement.getListBook();
    public static void menuGuess() {
        System.out.println("0. Thoát");
        System.out.println("1. Tìm kiếm sách.");
        System.out.println("2. Xem danh sách sách");
        System.out.print("Chọn chức năng của khách: ");
    }
    public static void chooseModeGuess() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
                menuGuess();
                int chooseMode = Integer.valueOf(sc.nextLine());
                System.out.println("=============================");
                if(chooseMode==0) break;
                else if(chooseMode==1) modeFindBook();
                else if(chooseMode==2) modeShowListBook();
                else System.out.println("Chức năng của Khách không hợp lệ.");
                System.out.println("=============================");
            } catch (Exception e) {
                System.out.println("Xảy ra lỗi khi chọn chức năng Khách.");
                System.out.println("=============================");
            }
        }
    }
    public static void modeFindBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập thông tin sách: ");
        String info = sc.nextLine();
        System.out.println("=============================");
        Book res = BookManagement.findBook(info, books);
        if(res != null) {
            System.out.println("Sách bạn cần tìm là: ");
            res.showInformation();
        } else {
            System.out.println("Thông tin sách không hợp lệ.");
        }
    }
    public static void modeShowListBook() {
        BookManagement.showListBook(books);
    }

}
