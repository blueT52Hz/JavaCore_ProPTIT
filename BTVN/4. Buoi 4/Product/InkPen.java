package Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class InkPen extends Pen {
    private String typeOfInk, smoothly;
    public InkPen(){}
    public InkPen(String name, String price, String brand, String color, String material, String typeOfInk, String smoothly) {
        super(name, price, brand, color, material);
        this.typeOfInk = typeOfInk;
        this.smoothly = smoothly;
        maxLenOfMoreInformation = Stream.of(maxLenOfMoreInformation, getTypeOfInk().length(), getSmoothly().length()).max(Integer::compareTo).get();
    }
    public String getTypeOfInk() {
        return "Loại mực: " + typeOfInk;
    }
    public String getSmoothly() {
        return "Độ mịn: " + smoothly;
    }
    public List<String> getListMoreInfo() {
        List<String> tmp = super.getListMoreInfo();
        tmp.add(getTypeOfInk());
        tmp.add(getSmoothly());
        return tmp;
    }
    public boolean compare(String info) {
        if(super.compare(info)) return true;
        return getTypeOfInk().contains(info) || getSmoothly().contains(info);
    }
    public void setTypeOfInk() {
        System.out.print("Nhập loại mực: ");
        this.typeOfInk = sc.nextLine();
        maxLenOfMoreInformation=Math.max(maxLenOfMoreInformation, getTypeOfInk().length());
    }
    public void setSmoothly() {
        System.out.print("Nhập độ mịn: ");
        this.smoothly = sc.nextLine();
        maxLenOfMoreInformation=Math.max(maxLenOfMoreInformation, getSmoothly().length());
    }
    public void editInformation(int mode) {
        super.editInformation(mode);
        switch (mode) {
            case 0:
                setSmoothly();
                setTypeOfInk();
                break;
            case 6:
                setSmoothly();
                break;
            case 7:
                setTypeOfInk();
                break;
            default:
                System.out.println("Chức năng không hợp lệ.");
        }
    }
    public static InkPen inkPenFromScanner() {
        InkPen inkPen = new InkPen();
        inkPen.editInformation(0);
        return inkPen;
    }
    public void showMode2() {
        super.showMode2();
        System.out.println("Loại mực: " + typeOfInk);
        System.out.println("Độ mịn: " + smoothly);
        System.out.println("---------");
    }
}
