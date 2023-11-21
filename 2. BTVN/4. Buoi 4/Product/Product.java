package Product;

import java.util.ArrayList;
import java.util.List;

public abstract class Product extends Scan{
    public static int numberOfProduct=0;
    public static int maxLenOfId = 5;
    public static int maxLenOfName = "Tên sản phẩm".length();
    public static int maxLenOfPrice = "Giá bán".length();
    public static int maxLenOfBrand = "Thương hiệu".length();
    public static int maxLenOfMoreInformation = "Thông tin thêm".length();

    private String id, name, brand, price;
    public Product() {
        numberOfProduct++;
        this.id=String.format("%04d", String.valueOf(numberOfProduct));
    }

    public Product(String name, String price, String brand) {
        numberOfProduct++;
        this.id = String.format("%04d", numberOfProduct);
        this.name = name;
        this.brand = brand;
        this.price = price;
        maxLenOfName = Math.max(maxLenOfName, getName().length());
        maxLenOfBrand = Math.max(maxLenOfBrand, getBrand().length());
        maxLenOfPrice = Math.max(maxLenOfPrice, getPrice().length());
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getBrand() {
        return brand;
    }
    public String getPrice() {
        return price;
    }
    public List<String> getListMoreInfo(){
        return new ArrayList<>();
    };
    public void getMenuEditInfo() {
        System.out.println("fhsdfjhdsfsd");
    }
    public boolean compare(String info) {
        return getName().toLowerCase().contains(info) || getBrand().toLowerCase().contains(info) || price.equals(info);
    }
    public void setName() {
        System.out.print("Nhập tên sản phẩm: ");
        this.name = sc.nextLine();
        maxLenOfName = Math.max(maxLenOfName, getName().length());
    }
    public void setBrand() {
        System.out.print("Nhập thương hiệu: ");
        this.brand = sc.nextLine();
        maxLenOfBrand = Math.max(maxLenOfBrand, getBrand().length());
    }
    public void setPrice() {
        System.out.print("Nhập giá: ");
        price = sc.nextLine();
        maxLenOfPrice = Math.max(maxLenOfPrice, getPrice().length());
    }
    public void editInformation(int mode) {
        switch (mode) {
            case 0:
                setName();
                setPrice();
                setBrand();
                break;
            case 1:
                setName();
                break;
            case 2:
                setPrice();
                break;
            case 3:
                setBrand();
                break;
        }
    }
    public void showMode2() {
        System.out.println("Id: " + id);
        System.out.println("Tên sản phẩm: " + name);
        System.out.println("Giá bán: " + price);
        System.out.println("Thương hiệu: " + brand);
    }
}
