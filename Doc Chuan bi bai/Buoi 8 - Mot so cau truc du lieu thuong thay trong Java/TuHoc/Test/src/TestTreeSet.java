import java.util.TreeSet;

public class TestTreeSet {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("three");
        treeSet.add("one");
        treeSet.add("five");
        treeSet.add("two");
        treeSet.add("four");
        System.out.println("Các phần tử trong treeSet là:");
        System.out.println(treeSet);
        System.out.println(treeSet.getFirst());
        System.out.println(treeSet.getLast());
    }
}