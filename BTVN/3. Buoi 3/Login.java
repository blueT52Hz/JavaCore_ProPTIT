import java.util.List;
import java.util.Scanner;

public class Login {
    private static List<Admin> admins = Admin.getListAdmin();
    public static void chooseModeLogin(){
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.printf("Nhập tên đăng nhập: ");
            String username = String.valueOf(sc.nextLine());
            if(username.equals("khach")) {
                System.out.println("Đăng nhập với tư cách khách.");
                System.out.println("=============================");
                Guess.chooseModeGuess();
            } else {
                System.out.printf("Nhập mật khẩu: ");
                String password = String.valueOf(sc.nextLine());
                if(Admin.checkAdmin(admins, username, password)) {
                    System.out.println("Đăng nhập với tư cách Admin.");
                    System.out.println("=============================");
                    Admin.chooseModeAdmin();
                    System.out.println("=============================");
                } else {
                    System.out.println("Sai mật khẩu hoặc tên đăng nhập.");
                    System.out.println("=============================");
                }
            }
        }
    }
}
