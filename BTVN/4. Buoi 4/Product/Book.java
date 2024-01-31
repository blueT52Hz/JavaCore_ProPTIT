package Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Book extends Product {
    private String type, author, publishCompany, publishDate, language;
    public Book() {
        super();
    }
    public Book(String name, String price, String brand, String type, String author, String publishCompany, String publishDate, String language) {
        super(name, price, brand);
        this.type = type;
        this.author = author;
        this.publishCompany = publishCompany;
        this.publishDate = publishDate;
        this.language = language;
        maxLenOfMoreInformation = Stream.of(maxLenOfMoreInformation, getType().length(), getAuthor().length(), getPublishCompany().length(), getPublishDate().length(), getLanguage().length()).max(Integer::compareTo).get();
    }

    public String getType() {
        return "Thể loại: " + type;
    }
    public String getAuthor() {
        return "Tác giả: " + author;
    }
    public String getPublishCompany() {
        return "Nhà xuất bản: " + publishCompany;
    }
    public String getPublishDate() {
        return "Năm xuất bản: " + publishDate;
    }
    public String getLanguage() {
        return "Ngôn ngữ: " + language;
    }
    @Override
    public List<String> getListMoreInfo() {
        List<String> tmp = new ArrayList<>();
        tmp.add(getType());
        tmp.add(getAuthor());
        tmp.add(getPublishCompany());
        tmp.add(getPublishDate());
        tmp.add(getLanguage());
        return tmp;
    }
    @Override
    public boolean compare(String info) {
        if(super.compare(info)) return true;
//        super.compare(info);
        return getType().toLowerCase().contains(info) || getAuthor().toLowerCase().contains(info) || getPublishDate().toLowerCase().contains(info) || getPublishCompany().toLowerCase().contains(info) || getLanguage().contains(info);
    }
    public void setType() {
        System.out.print("Nhập thể loại: ");
        this.type = sc.nextLine();
        maxLenOfMoreInformation=Math.max(maxLenOfMoreInformation, getType().length());
    }
    public void setAuthor() {
        System.out.print("Nhập tác giả: ");
        this.author = sc.nextLine();
        maxLenOfMoreInformation=Math.max(maxLenOfMoreInformation, getAuthor().length());
    }
    public void setPublishCompany() {
        System.out.print("Nhập nhà xuất bản: ");
        this.publishCompany = sc.nextLine();
        maxLenOfMoreInformation=Math.max(maxLenOfMoreInformation, getPublishCompany().length());
    }
    public void setPublishDate() {
        System.out.print("Nhập năm xuất bản: ");
        this.publishDate = sc.nextLine();
    }
    public void setLanguage() {
        System.out.print("Nhập ngôn ngữ: ");
        this.language = sc.nextLine();
        maxLenOfMoreInformation=Math.max(maxLenOfMoreInformation, getLanguage().length());
    }
    @Override
    public void editInformation(int mode) {
        super.editInformation(mode);
        switch (mode) {
            case 0:
                setType();
                setAuthor();
                setPublishCompany();
                setPublishDate();
                setLanguage();
                break;
            case 4:
                setType();
                break;
            case 5:
                setAuthor();
                break;
            case 6:
                setPublishCompany();
                break;
            case 7:
                setPublishDate();
                break;
            case 8:
                setLanguage();
                break;
            default:
                System.out.println("Chức năng không phù hợp.");

        }

    }
    public static Book bookFromScanner() {
        Book tmp = new Book();
        tmp.editInformation(0);
        return tmp;
    }
    public void showMode2() {
        super.showMode2();
        System.out.println("Thể loại: " + type);
        System.out.println("Tác giả: " + author);
        System.out.println("Nhà xuất bản: " + publishCompany);
        System.out.println("Năm xuất bản: " + publishDate);
        System.out.println("Ngôn ngữ: " + language);
        System.out.println("---------");
    }
}