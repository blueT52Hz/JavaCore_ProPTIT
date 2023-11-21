import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin {
    private String userName, passWord;
    public static Scanner sc = new Scanner(System.in);
    public Admin(String userName, String password) {
        this.userName = userName;
        this.passWord = password;
    }
    public static Admin adminFromString(String line) {
        String[] strings = line.split("\\|");
        return new Admin(strings[0], strings[1]);
    }
    public String getUserName() {
        return userName;
    }
    public String getPassWord() {
        return passWord;
    }
    public static List<Admin> getListAdmin() {
        List<String> lines = ReadFile.stringsFromPathOfFile("E:\\0000.CODE\\10. Java\\000. PROPTIT\\3.Buoi3\\Buoi_3 Tren lop\\Buoi_3\\src\\listAdmin.txt");
        List<Admin> admins = new ArrayList<Admin>();
        for(String line : lines) {
            admins.add(Admin.adminFromString(line));
        }
        return admins;
    }
    public static void showListAdmin() {
        List<Admin> admins = getListAdmin();
        for (Admin admin : admins) {
            System.out.println("Ussername: " + admin.getUserName());
            System.out.println(("Password: " + admin.getPassWord()));
        }
    }
    public static boolean checkAdmin(List<Admin> admins, String userName, String passWord) {
        for(Admin admin : admins)
            if(admin.getUserName().equals(userName))
                if(admin.getPassWord().equals(passWord)) return true;
        return false;
    }
    public static void menuAdmin() {
        System.out.println("1. Thêm sách mới.");
        System.out.println("2. Xóa sách.");
        System.out.println("3. Sửa sách.");
        System.out.println("4. Test chức năng của khách.");
        System.out.println("5. Thoát tài khoản Admin.");
        System.out.print("Chọn chức năng Admin: ");
    }
    public static void chooseModeAdmin() {
        while(true) {
            menuAdmin();
            try {
                int chooseMode = Integer.valueOf(sc.nextLine());
                System.out.println("=============================");
                if(chooseMode==1) {
                    System.out.println("Thêm sách mới.");
                    System.out.print("Nhập số sách muốn thêm: ");
                    BookManagement.addBook(Guess.books);
                    System.out.println("=============================");
                } else if(chooseMode==2) {
                    System.out.println("Xóa sách.");
                    BookManagement.deleteBook(Guess.books);
                    System.out.println("=============================");
                } else if(chooseMode==3) {
                    System.out.println("Sửa sách");
                    System.out.print("Nhập thông tin bất kỳ của sách: ");
                    String s = sc.nextLine();
                    BookManagement.fixBook(s, Guess.books);
                    System.out.println("=============================");
                } else if(chooseMode==4) {
                    System.out.println("Test chức năng của khách:");
                    Guess.chooseModeGuess();
                    System.out.println("=============================");
                } else if(chooseMode==5) {
                    System.out.println("Thoát tài khoản Admin");
                    System.out.println("=============================");
                    Login.chooseModeLogin();
                } else {
                    System.out.println("Chức năng của Admin không hợp lệ!");
                    System.out.println("=============================");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
