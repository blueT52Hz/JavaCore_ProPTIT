package ProductManagement;

import Product.*;

import java.io.PrintStream;
import java.util.*;
public class ProductManagement extends Scan {

    public static List<Product> productList = new ArrayList<>();
    public static List<Notebook> notebookList = new ArrayList<>();
    public static List<Pencil> pencilList = new ArrayList<>();
    public static List<InkPen> inkPenList = new ArrayList<>();
    public static List<Book> bookList = new ArrayList<>();

//    Thêm sản phẩm============================================================

    public static void menuProduct() {
        System.out.println(
                "|-------------------------|\n" +
                "|  Các loại sản phẩm:     |\n" +
                "|  1. Notebook.           |\n" +
                "|  2. Bút chì.            |\n" +
                "|  3. Bút mực.            |\n" +
                "|  4. Sách                |\n" +
                "|-------------------------|");
    }
    public static void addProduct() {
        System.out.println("Thêm sản phẩm.\n----------");
        System.out.print("Nhập số sản phẩm muốn thêm: ");
        int numberOfProduct = Integer.valueOf(sc.nextLine());
        while(numberOfProduct-- > 0) {
            menuProduct();
            System.out.print("Chọn loại sản phẩm cần thêm: ");
            int type = Integer.valueOf(sc.nextLine());
            if(type==1) notebookList.add(Notebook.notebookFromScanner());
            else if(type==2) pencilList.add(Pencil.pencilFromScanner());
            else if(type==3) inkPenList.add(InkPen.inkPenFromScanner());
            else if(type==4) bookList.add(Book.bookFromScanner());
        }
        productList.clear();
        for(Notebook notebook : notebookList) productList.add(notebook);
        for(Pencil pencil : pencilList) productList.add(pencil);
        for(InkPen inkPen : inkPenList) productList.add(inkPen);
        for(Book book : bookList) productList.add(book);
        System.out.println("Thêm sản phẩm thành công.");
        System.out.println("---------");
    }

//    Xóa sản phẩm=========================================================
    public static void removeProduct() {
        System.out.print("Nhập số sản phẩm cần xóa: ");
        int numberOfRemove = Integer.valueOf(sc.nextLine());
        while(numberOfRemove > 0 && !productList.isEmpty()) {
            System.out.print("Nhập thông tin sản phẩm cần xóa (Nhập 0 để hủy): ");
            String info = sc.nextLine();
            System.out.println("----------");
            if(info.equals("0")) break;
            List<Product> productsFound = findProduct(info);
            if(productsFound.isEmpty()) {
                System.out.println("Không tìm thấy sản phẩm có thông tin trên.");
                continue;
            }
            else {
                System.out.println("Danh sách sản phẩm có thông tin trên là:");
                showProduct(productsFound);
                System.out.print("Nhập id sản phẩm cần xóa: ");
                String id = sc.nextLine();
                boolean checkFoundId = true;
                for(Product product : productsFound) {
                    if(product.getId().equals(id)) {
                        notebookList.remove(product);
                        pencilList.remove(product);
                        inkPenList.remove(product);
                        bookList.remove(product);
                        productList.remove(product);
                        numberOfRemove--;
                        System.out.println("Xóa sản phẩm thành công.");
                        checkFoundId = false;
                        break;
                    }
                }
                if(checkFoundId) System.out.println("Không sản phẩm được tìm thấy nào có ID trên.");
            }
        }
        if(productList.isEmpty()) System.out.println("Danh sách sản phẩm rỗng.");
        System.out.println("----------");
    }

//    Sửa thông tin sản phẩm====================================================
    public static void editProductInfor() {
        System.out.print("Nhập thông tin sản phẩm cần sửa: ");
        String info = sc.nextLine().toLowerCase();
        System.out.println("----------");
        List<Product> productsFound = findProduct(info);
        if(productsFound.isEmpty()) {
            System.out.println("Không có sản phẩm nào có thông tin trên.\n----------");
        } else {
            System.out.println("Danh sách sản phẩm có thông tin trên là: ");
            showProduct(productsFound);
            System.out.print("Nhập id sản phẩm muốn sửa: ");
            String id = sc.nextLine();
            for(Product product : productsFound) {
                if(product.getId().equals(id)) {
                    product.editInformation(Integer.valueOf(sc.nextLine()));
                    System.out.println("---------");
                    System.out.println("Sửa thông tin sản phẩm thành công");
                    System.out.println("----------");
                    return;
                }
            }
        }


    }
//    Tìm kiếm sản phẩm========================================================
    public static List<Product> findProduct(String info) {
        info = info.toLowerCase();
        List<Product> productList = new ArrayList<Product>();
        for (Product product : ProductManagement.productList) if(product.compare(info.toLowerCase())) productList.add(product);
        return productList;
    }
//    Xem sản phẩm===============================================================
    public static void showProduct(List<Product> productList) {
        if(productList==null || productList.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
            System.out.println("----------");
            return;
        }
        System.out.println("" +
                "|---------------------------------------|\n" +
                "|  Các chức năng hiển thị sản phẩm:     |\n" +
                "|  1. Hiển thị dạng bảng.               |\n" +
                "|  2. Hiển thị dạng danh sách.          |\n" +
                "|---------------------------------------|");
        System.out.print("Chọn chức năng hiển thị sản phẩm: ");
        int mode = Integer.valueOf(sc.nextLine());
        System.out.println("----------");
        if(mode==1) {
            System.out.println("Hiển thị dạng bảng: ");
            showMode1(productList);
        } else {
            System.out.println("Hiển thị dạng danh sách: ");
            showMode2(productList);
        }
    }

    public int tinhLe(int maxLen, String info) {
        return (maxLen-info.length())/2;
    }
    public static void showMode1(List<Product> productList){
        int[] l = new int[] {Product.maxLenOfId+10, Product.maxLenOfName+10, Product.maxLenOfPrice+10, Product.maxLenOfBrand+10, Product.maxLenOfMoreInformation+5};
        String hyphenLine = "-".repeat(l[0]+l[1]+l[2]+l[3]+l[4]+6);
        System.out.println(hyphenLine);
        int le1, le2, le3, le0, le4;
        le0 = (l[0]-"ID".length()+1)/2;
        le1 = (l[1]-"Tên sản phẩm".length()+1)/2;
        le2 = (l[2]-"Giá bán".length()+1)/2;
        le3 = (l[3]-"Thương hiệu".length()+1)/2;
        le4 = (l[4]-"Thông tin thêm".length()+1)/2;
        System.out.printf(String.format(
                "|%-" + le0 + "s%-"+ (l[0]-le0) + "s|%-" + le1 + "s%-" + (l[1]-le1) + "s|%-" + le2 + "s%-" + (l[2]-le2) + "s|%-" + le3 + "s%-" + (l[3]-le3) + "s|%-" + le4 + "s%-" + (l[4]-le4) + "s|\n",
                " ", "ID", " " , "Tên sản phẩm", " ", "Giá bán", " ", "Thương hiệu", " ", "Thông tin thêm"));
        System.out.println(hyphenLine);
        for (Product product : productList) {
            List<String> moreInfo = product.getListMoreInfo();
            for (int i=0;i<moreInfo.size();++i){
                if(i== (moreInfo.size()-1)/2) {
                    le0 = (l[0]-product.getId().length()+1)/2;
                    le1 = (l[1]-product.getName().length()+1)/2;
                    le2 = (l[2]-product.getPrice().length()+1)/2;
                    le3 = (l[3]-product.getBrand().length()+1)/2;
                    System.out.printf(String.format(
                            "|%-" + le0 + "s%-"+ (l[0]-le0) + "s|%-" + le1 + "s%-" + (l[1]-le1) + "s|%-" + le2 + "s%-" + (l[2]-le2) + "s|%-" + le3 + "s%-" + (l[3]-le3) + "s|",
                            " ", product.getId(), " " , product.getName(), " ", product.getPrice(), " ", product.getBrand()));
                }
                else System.out.printf(String.format("|%-"+l[0] + "s|%-"+l[1]+ "s|%-"+l[2]+ "s|%-"+l[3]+ "s|", "", "", "", ""));
                System.out.print(String.format("%-" + l[4] + "s|\n", moreInfo.get(i)));
            }
            System.out.println(hyphenLine);
        }
    }
    public static void showMode2(List<Product> productList) {
        for(Product product : productList) product.showMode2();
    }


}
