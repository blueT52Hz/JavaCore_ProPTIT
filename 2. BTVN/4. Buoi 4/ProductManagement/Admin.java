package ProductManagement;
import java.util.Scanner;

public class Admin extends Customer {
    public static void menuModeAdmin() {
        System.out.println(
                "|------------------------------|\n" +
                "|  Chức năng Admin:            |\n" +
                "|  0. Đăng xuất.               |\n" +
                "|  1. Thêm sản phẩm.           |\n" +
                "|  2. Xóa sản phẩm.            |\n" +
                "|  3. Sửa sản phẩm.            |\n" +
                "|  4. Chức năng của khách.     |\n" +
                "|------------------------------|");
    }

    public static void chooseModeAdmin() {
        while(true) {
            menuModeAdmin();
            System.out.print("Chọn chức năng Admin: ");
            int mode = Integer.valueOf(sc.nextLine());
            switch (mode) {
                case 0:
                    System.out.println("Đăng xuất tài khoản Admin.");
                    break;
                case 1:
                    addProduct();
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    editProductInfor();
                    break;
                case 4:
                    chooseModeCustomer();
                    break;
                default:
                    System.out.println("Chức năng không phù hợp.");
            }
        }
    }
}
