import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManagement {
    public static List<Book> getListBook() {
        try {
            List<String> listBook = ReadFile.stringsFromPathOfFile("E:\\0000.CODE\\10. Java\\000. PROPTIT\\3.Buoi3\\Buoi_3 Tren lop\\Buoi_3\\src\\listBook.txt");
            List<Book> books = new ArrayList<Book>();
            for(String line : listBook) {
                books.add(Book.bookFromString(line));
            }
            return books;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of(new Book[0]);
    }

    public static Book findBook(String s, List<Book> books) {
        for(Book book : books) {
            if(book.compare(s)) {
                return book;
            }
        }
        System.out.println("Không tìm thấy sách qua thông tin trên");
        return null;
    }

    public static void showListBook(List<Book> books) {
        for(Book book : books) {
            book.showInformation();
            System.out.println("-------------------------------------------------");
        }
    }

    public static void deleteBook(List<Book> books) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập thông tin sách cần xóa: ");
        String infoOfDeleteBook = sc.nextLine();
        int sizeOfListBook = books.size();
        for(int i=0;i<sizeOfListBook;++i) {
            if(books.get(i).compare(infoOfDeleteBook)) {
                System.out.println("Cuốn sách bạn muốn xóa là: ");
                books.get(i).showInformation();
                books.remove(i);
                break;
            }
        }
        if(sizeOfListBook==books.size()) {
            System.out.println("Không tìm thấy sách cần xóa qua thông tin trên");
            return;
        } else {
            WriteFile.writeNewListBook(books, "E:\\0000.CODE\\10. Java\\000. PROPTIT\\3.Buoi3\\Buoi_3 Tren lop\\Buoi_3\\src\\listBook.txt");
            System.out.println("Xóa sách thành công.");
        }
    }

    public static void addBook(List<Book>books) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Nhập thông tin sách cần thêm:");
            System.out.print("Id: ");
            String id = sc.nextLine();
            System.out.print("Tiêu đề: ");
            String tieuDe = sc.nextLine();
            System.out.print("Tác giả: ");
            String tacGia = sc.nextLine();
            System.out.print("Thể loại: ");
            String theLoai = sc.nextLine();
            System.out.print("Ngày xuất bản: ");
            String nxb = sc.nextLine();
            Book newBook = new Book(id, tieuDe, new Author(tacGia), theLoai, new Day(nxb));
            books.add(newBook);
            WriteFile.writeContinueListBook(newBook, "E:\\0000.CODE\\10. Java\\000. PROPTIT\\3.Buoi3\\Buoi_3 Tren lop\\Buoi_3\\src\\listBook.txt");
        } catch (Exception e) {
            System.out.println("Thông tin thêm sách không hợp lệ.");
            return;
        }
        System.out.println("Thêm sách mới thành công.");
    }

    public static void menuFixBook() {
        System.out.println("Nhập thông tin cần sửa: ");
        System.out.println("0. Thoát.");
        System.out.println("1. Tiêu để.");
        System.out.println("2. Tác giả.");
        System.out.println("3. Thể loại.");
        System.out.println("4. Ngày xuất bản.");
    }

    public static void fixBook(String s, List<Book> books) {
        Scanner sc = new Scanner(System.in);
        Book sua = BookManagement.findBook(s, books);
        if(sua == null) {
            System.out.println("Thông tin sách không hợp lệ.");
            return;
        } else {
            System.out.println("Thông tin sách cần sửa là: ");
            sua.showInformation();
            int chooseMode = 1;
            while(chooseMode==1) {
                BookManagement.menuFixBook();
                chooseMode=Integer.parseInt(sc.nextLine());
                if(chooseMode==0) {
                    System.out.println("Chưa thay đổi thông tin sách.");
                    return;
                }
                System.out.print("Nhập thông tin mới: ");
                String newInformation = sc.nextLine();
                if(chooseMode==1) sua.setTitle(newInformation);
                else if(chooseMode==2) sua.setAuthor(new Author(newInformation));
                else if(chooseMode==3) sua.setType(newInformation);
                else if(chooseMode==4) sua.setReleaseDate(new Day(newInformation));
                else System.out.println("Chức năng sửa không hợp lệ.");

            }
            WriteFile.writeNewListBook(books, "E:\\0000.CODE\\10. Java\\000. PROPTIT\\3.Buoi3\\Buoi_3 Tren lop\\Buoi_3\\src\\listBook.txt");
            System.out.println("Sửa thông tin sách thành công");
        }
    }
}
