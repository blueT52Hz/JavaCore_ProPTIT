import java.util.*;

public class TestHashSet {
    private static String hor = "=".repeat(50);
    public static void main(String[] args) {
        Set<String> hashSet = new java.util.HashSet<String>();
        hashSet.add("one");
        hashSet.add("two");
        hashSet.add("three");
        hashSet.add("four");
        hashSet.add("five");
        hashSet.add("six");
        System.out.println("Các phần tử của hashet là: ");
        System.out.println(hashSet);
        enter();

        System.out.println("Test phương thức removeAll:");
        Set<String> hashSet2 = new java.util.HashSet<String>();
        hashSet2.add("three");
        hashSet2.add("five");
        hashSet2.add("ten");
        hashSet2.removeAll(hashSet);
        System.out.println(hashSet2);
        enter();

        System.out.println("Test phương thức retainAll:");
        Set<String> hashSet3 = new java.util.HashSet<String>();
        hashSet3.add("three");
        hashSet3.add("five");
        hashSet3.add("ten");
        hashSet3.retainAll(hashSet);
        System.out.println(hashSet3);
        enter();

        System.out.println("Test phương thức addAll:");
        Set<String> hashSet4 = new java.util.HashSet<String>();
        hashSet4.addAll(hashSet);
        for(String element : hashSet4) {
            System.out.println(element);
        }
        enter();

        System.out.println("Test phương thức toArray:");
        Set<String> hashSet5 = new java.util.HashSet<String>();
        hashSet5.addAll(hashSet);
        // khi để là [0] thì java sẽ tạo mảng mới có kích thước phù hợp với kích thước của Set
        String[] a = hashSet5.toArray(new String[0]);
        for(String element:a) System.out.println(element);
        enter();
    }
    public static void enter() {
        System.out.println(hor);
    }
}
