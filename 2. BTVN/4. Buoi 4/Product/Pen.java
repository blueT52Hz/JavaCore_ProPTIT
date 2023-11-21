package Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Pen extends Product {
    private String color, material;
    public Pen(){}
    public Pen(String name, String price, String brand, String color, String material) {
        super(name, price, brand);
        this.color = color;
        this.material = material;
        maxLenOfMoreInformation = Stream.of(getColor().length(), getMaterial().length(), maxLenOfMoreInformation).max(Integer::compareTo).get();
    }
    public String getColor() {
        return "Màu sắc: " +  color;
    }
    public String getMaterial() {
        return "Chất liệu: " + material;
    }
    public List<String> getListMoreInfo() {
        List<String> tmp = new ArrayList<>();
        tmp.add(getColor());
        tmp.add(getMaterial());
        return tmp;
    }
    public boolean compare(String info) {
        if(super.compare(info)) return true;
        return getColor().toLowerCase().contains(info) || getMaterial().toLowerCase().contains(info);
    }
    public void setColor() {
        System.out.print("Nhập màu sắc: ");
        this.color = sc.nextLine();
        maxLenOfMoreInformation=Math.max(maxLenOfMoreInformation, getColor().length());
    }
    public void setMaterial() {
        System.out.print("Nhập chất liệu: ");
        this.material = sc.nextLine();
        maxLenOfMoreInformation=Math.max(maxLenOfMoreInformation, getMaterial().length());
    }
    @Override
    public void editInformation(int mode) {
        super.editInformation(mode);
        switch (mode) {
            case 0:
                setColor();
                setMaterial();
                break;
            case 4:
                setColor();
                break;
            case 5:
                setMaterial();
                break;
        }
    }
    public void showMode2() {
        super.showMode2();
        System.out.println("Màu sắc: " + color);
        System.out.println("Chất liệu: " + material);
    }
}
