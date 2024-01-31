package Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pencil extends Pen {
    private String stiffness;
    public Pencil() {}
    public Pencil(String name, String price, String brand, String color, String material, String stiffness) {
        super(name, price, brand, color, material);
        this.stiffness = stiffness;
        maxLenOfMoreInformation = Math.max(maxLenOfMoreInformation, getStiffness().length());
    }
    public String getStiffness() {
        return "Độ cứng: " + stiffness;
    }
    public List<String> getListMoreInfo() {
        List<String> tmp = super.getListMoreInfo();
        tmp.add(getStiffness());
        return tmp;
    }
    public boolean compare(String info) {
        if(super.compare(info)) return true;
        return getStiffness().toLowerCase().contains(info);
    }
    public void setStiffness() {
        System.out.print("Nhập độ cứng: ");
        this.stiffness = sc.nextLine();
        maxLenOfMoreInformation=Math.max(maxLenOfMoreInformation, getStiffness().length());
    }
    @Override
    public void editInformation(int mode) {
        super.editInformation(mode);
        switch (mode) {
            case 0, 6:
                setStiffness();
                break;
            default:
                System.out.println("Chức năng không hợp lệ.");
        }
    }
    public static Pencil pencilFromScanner() {
        Pencil pencil = new Pencil();
        pencil.editInformation(0);
        return pencil;
    }
    public void showMode2() {
        super.showMode2();
        System.out.println("Độ cứng: " + stiffness);
        System.out.println("---------");
    }
}
