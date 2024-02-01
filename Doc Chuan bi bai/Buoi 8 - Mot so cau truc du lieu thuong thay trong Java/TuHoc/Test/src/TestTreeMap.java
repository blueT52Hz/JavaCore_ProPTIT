import java.util.SortedMap;

public class TestTreeMap<I extends Number, S> {
    private static String hor = "=".repeat(50);
    public static void main(String[] args) {
        SortedMap<String, Integer> sortedMap = new java.util.TreeMap<String, Integer>();
        sortedMap.put("six", 6);
        sortedMap.put("one", 1);
        sortedMap.put("three", 3);
        sortedMap.put("four", 4);
        System.out.println(sortedMap);
        enter();

        System.out.println("Test phương thức subMap:");
        SortedMap<String, Integer> map1 = sortedMap.subMap("a", "s");  // Lấy các cặp key-value có key từ fromKey đến toKey (k lấy toKey)
        System.out.println(map1);
        enter();

        System.out.println("Test phương thức headMap:");
        SortedMap<String, Integer> map2 = sortedMap.headMap("s"); // Lấy các cặp key-value có key từ đầu đến fromKey (k lấy toKey)
        System.out.println(map2);
        enter();

        System.out.println("Test phương thức tailMap");
        SortedMap<String,Integer> map3 = sortedMap.tailMap("s"); // lấy các cặp key-value có key từ fromKey đến hết Map (có lấy fromKey)
        System.out.println(map3);
        enter();

        System.out.println("Test phương thức firstKey và lastKey:");
        System.out.println("Cặp key-value đầu tiên là: " + sortedMap.firstKey() + "-" + sortedMap.get(sortedMap.firstKey()));
        System.out.println("Cặp value cuối cùng là: " + sortedMap.lastKey() + "-" + sortedMap.get(sortedMap.lastKey()));
        enter();
    }


    public static void enter() {
        System.out.println(hor);
    }
}
