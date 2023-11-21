import javax.crypto.spec.PSource;

public class Main {
    public static void main(String[] args) {
        Human hm = new Human("Tung", "Nam", 18);
//        hm = new CollageStudent("Tung", "Nam", 18, "4y3874", )
        hm = new CollageStudent(hm, "kh01", 1.2);
        System.out.println(hm.getName());
    }

}
