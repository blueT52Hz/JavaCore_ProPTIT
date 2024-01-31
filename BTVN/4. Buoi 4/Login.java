import java.util.Scanner;
import ProductManagement.*;

public class Login{
    public static void chooseModeLogin() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("Nhập tên đăng nhập: ");
            String username = sc.nextLine();
            if (username.equals("khach")) {
                System.out.println("----------");
                System.out.println("Đăng nhập với tư cách khách.");
                System.out.println("---------");
                Customer.chooseModeCustomer();
            }
            else if(username.equalsIgnoreCase("Thoat")) break;
            else {
                System.out.print("Nhập mật khẩu: ");
                String pasword = sc.nextLine();
                System.out.println("----------");
                if (username.equals("admin") && pasword.equals("admin")) {
                    System.out.println("Dăng nhập với tư cách Admin.");
                    System.out.println("----------");
                    Admin.chooseModeAdmin();
                } else {
                    System.out.println("Tên đăng nhập hoặc mật khẩu không đúng.");
                    System.out.println("----------");
                }
            }
        }
    }
}
