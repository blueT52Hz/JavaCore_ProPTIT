package ProductManagement;

import java.util.List;
import java.util.Scanner;
import Product.*;
import ProductManagement.ProductManagement;

public class Customer extends ProductManagement {
    public static void menuCustomer() {
        System.out.println("|---------------------------------|");
        System.out.println("|  Chức năng của khách:           |");
        System.out.println("|  0. Thoát.                      |");
        System.out.println("|  1. Tìm kiếm sản phẩm.          |");
        System.out.println("|  2. Xem danh sách sản phẩm.     |");
        System.out.println("|---------------------------------|");
    }
    public static void chooseModeCustomer() {
        while(true) {
            menuCustomer();
            System.out.print("Chọn chức năng của khách: ");
            int mode = Integer.valueOf(sc.nextLine());
            switch (mode) {
                case 0:
                    System.out.println("Thoát tài khoản khách.");
                    System.out.println("----------");
                    return;
                case 1:
                    System.out.println("Chức năng tìm kiếm sản phầm.");
                    System.out.print("Nhập thông tin sản phẩm: ");
                    String info = sc.nextLine().toLowerCase();
                    System.out.println("---------");
                    List<Product> productsFound = findProduct(info);
                    if (productsFound.isEmpty())
                        System.out.println("Không tìm thấy sản phầm có thông tin trên.\n----------");
                    else showProduct(productsFound);
                    break;
                case 2:
                    System.out.println("Xem danh sách sản phẩm.");
                    System.out.println("----------");
                    showProduct(productList);
                    break;
                default:
                    System.out.println("Chức năng không phù hợp.");
            }
        }
    }

}
