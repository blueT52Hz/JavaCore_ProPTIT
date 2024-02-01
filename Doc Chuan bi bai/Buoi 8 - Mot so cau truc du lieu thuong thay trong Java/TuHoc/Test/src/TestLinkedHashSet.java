import java.util.*;

public class TestLinkedHashSet {
    public static void main(String[] args) {
        Set<String> linkedHashSet = new java.util.LinkedHashSet<String>();
        linkedHashSet.add("one");
        linkedHashSet.add("two");
        linkedHashSet.add("three");
        linkedHashSet.add("four");
        linkedHashSet.add("five");
        linkedHashSet.add("six");
        System.out.println("Các phần tử của LinkedHashSet là: ");
        System.out.println(linkedHashSet);
    }
}
