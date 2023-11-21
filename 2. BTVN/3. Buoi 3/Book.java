
public class Book {
    private String id, title, type, language;
    private Author author;
    private Day publishDate;
    private double price;

    public Book(String id, String title, String type, String language, Author author, Day publishDate, double price) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.language = language;
        this.author = author;
        this.publishDate = publishDate;
        this.price = price;
    }

    public static Book bookFromString(String s) {
        String[] strings = s.split("\\|");
        return new Book(strings[0], strings[1], strings[2], strings[3], new Author(strings[2]), new Day(strings[4]), Double.valueOf(strings[5]));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public Author getAuthor() {
        return author;
    }
    public String getNameAuthor() {
        return author.getName();
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Day getPublishDate() {
        return publishDate;
    }
    public String getStringPublishDate() {
        return publishDate.toString();
    }
    public void setPublishDate(Day publishDate) {
        this.publishDate = publishDate;
    }
    public void setPublishDate(String publishDate) {
        this.publishDate=new Day(publishDate);
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean compare(String s) {
        if(s.equals(id) || s.equals(title) || s.equals(type) || s.equals(getNameAuthor()) || s.equals(getStringPublishDate())) return true;
        return false;
    }

    public void showInformation() {
        System.out.println("Id: " + id);
        System.out.println("Tiêu đề: " + getTitle());
        System.out.println("Tác giả: " + getNameAuthor());
        System.out.println("Thể loại: " + getTitle());
        System.out.println("Ngày xuất bản: " + getStringPublishDate());
    }
}
