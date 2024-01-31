package Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Notebook extends Product {
    private String numOfPage, type, colorOfcover, material, size;
    public Notebook() {
    }
    public Notebook(String name, String price, String brand, String numOfPage, String type, String colorOfcover, String material, String size) {
        super(name, price, brand);
        this.numOfPage = numOfPage;
        this.type = type;
        this.colorOfcover = colorOfcover;
        this.material = material;
        this.size = size;
        maxLenOfMoreInformation = Stream.of(maxLenOfMoreInformation, getNumOfPage().length(), getType().length(), getColorOfcover().length(), getMaterial().length(), getSize().length()).max(Integer::compareTo).get();
    }
    public String getNumOfPage() {
        return "Số trang: " + numOfPage;
    }
    public String getType() {
        return "Thể loại: " + type;
    }
    public String getColorOfcover() {
        return "Màu sắc bìa: " + colorOfcover;
    }
    public String getMaterial() {
        return "Chất liệu giấy: " + material;
    }
    public String getSize() {
        return "Kích cỡ: " + size;
    }
    public List<String> getListMoreInfo() {
        List<String> tmp = new ArrayList<>();
        tmp.add(getNumOfPage());
        tmp.add(getType());
        tmp.add(getColorOfcover());
        tmp.add(getMaterial());
        tmp.add(getSize());
        return tmp;
    }
    public boolean compare(String info) {
        if(super.compare(info)) return true;
        return (String.format(numOfPage)).equals(info) || getType().toLowerCase().contains(info) || getColorOfcover().toLowerCase().contains(info) || getMaterial().toLowerCase().contains(info) || getSize().toLowerCase().contains(info);
    }
    public void setNumOfPage() {
        System.out.print("Nhập số trang: ");
        this.numOfPage = sc.nextLine();
        maxLenOfMoreInformation=Math.max(maxLenOfMoreInformation, getNumOfPage().length());
    }
    public void setType() {
        System.out.print("Nhập loại vở: ");
        this.type = sc.nextLine();
        maxLenOfMoreInformation=Math.max(maxLenOfMoreInformation, getType().length());
    }
    public void setColorOfcover() {
        System.out.print("Nhập màu bìa: ");
        this.colorOfcover = sc.nextLine();
        maxLenOfMoreInformation=Math.max(maxLenOfMoreInformation, getColorOfcover().length());
    }
    public void setMaterial() {
        System.out.print("Nhập chất liệu vở: ");
        this.material = sc.nextLine();
        maxLenOfMoreInformation=Math.max(maxLenOfMoreInformation, getMaterial().length());
    }
    public void setSize() {
        System.out.print("Nhập kích thước: ");
        this.size = sc.nextLine();
        maxLenOfMoreInformation=Math.max(maxLenOfMoreInformation, getSize().length());
    }
    @Override
    public void editInformation(int mode){
        super.editInformation(mode);
        switch (mode) {
            case 0:
                setType();
                setColorOfcover();
                setMaterial();
                setSize();
                setNumOfPage();
                break;
            case 4:
                setType();
                break;
            case 5:
                setColorOfcover();
                break;
            case 6:
                setMaterial();
                break;
            case 7:
                setSize();
                break;
            case 8:
                setNumOfPage();
                break;
            default:
                System.out.println("Chức năng không phù hợp.");

        }

    }
    public static Notebook notebookFromScanner() {
        Notebook notebook = new Notebook();
        notebook.editInformation(0);
        return notebook;
    }
    public void showMode2() {
        super.showMode2();
        System.out.println("Số trang: " + numOfPage);
        System.out.println("Loại vở: " + type);
        System.out.println("Màu sắc bìa: " + colorOfcover);
        System.out.println("Chất liệu giấy: " + material);
        System.out.println("Kích thước: " + size);
        System.out.println("---------");
    }

}
