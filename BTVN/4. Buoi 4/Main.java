import java.util.*;
import Product.*;
import ProductManagement.*;

public class Main {
    public static void main(String[] args) {
        ProductManagement.pencilList.add(new Pencil("Bút chì", "5000", "Thiên Long", "Đen", "Gỗ", "HB"));
        ProductManagement.inkPenList.add(new InkPen("Bút mực ", "10000", "Thiên Long", "Đen", "Nhựa", "Mực dầu", "0.5mm"));
        ProductManagement.bookList.add(new Book("Sách kí ức đen", "50000", "Kim Đồng", "Tiểu thuyết", "Nguyễn Nhật Ánh", "Kim Đồng", "2010", "Tiếng Việt"));
        ProductManagement.bookList.add(new Book("Sách Đắc Nhân Vật", "100000", "NXB Trẻ", "Kỹ năng sống", "Dale Carnegie", "NXB Đồng Đen", "2010", "Tiếng Việt"));
        ProductManagement.productList.add(ProductManagement.pencilList.get(0));
        ProductManagement.productList.add(ProductManagement.inkPenList.get(0));
        ProductManagement.productList.add(ProductManagement.bookList.get(0));
        ProductManagement.productList.add(ProductManagement.bookList.get(1));
//        Login.chooseModeLogin();
//        Admin.chooseModeAdmin();
        Customer.chooseModeCustomer();
    }
}