import com.sun.source.doctree.SinceTree;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

public class WriteFile {
    public static void writeNewListBook(List <Book> books, String pathOfFile) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(pathOfFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(Book book : books) {
            pw.printf("%s|%s|%s|%s|%s\n", book.getId(), book.getTitle(), book.getNameAuthor(), book.getType(), book.getStringReleaseDate());
            pw.flush();
        }
        pw.close();
    }
    public static void writeContinueListBook(Book book, String pathOfFile) {
        try {
            PrintWriter pw = null;
            pw = new PrintWriter(new FileWriter(pathOfFile, true)); // chọn file có địa chỉ như đường dẫn
            pw.printf("%s|%s|%s|%s|%s\n", book.getId(), book.getTitle(), book.getNameAuthor(), book.getType(), book.getStringReleaseDate());
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
