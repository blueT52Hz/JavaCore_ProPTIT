import java.util.*;

public class TestHashMap {
    private static String hor = "=".repeat(50);
    public static void main(String[] args) {
        Map<String, Integer> mp = new java.util.HashMap<String, Integer>();
        mp.put("three", 3);
        mp.put("four", 4);
        mp.put("five", 5);
        mp.put("one", 1);
        mp.put("two", 2);
        mp.put("six", 6);
        System.out.println(mp);
        enter();

         //Ví dụ phương thức entrySet + putAlls:

        System.out.println("Ví dụ phương thức entrySet + putAlls:");
        Map<String, Integer> mp2 = new java.util.HashMap<String, Integer>();
        mp2.putAll(mp); // thêm các phần tử của mp vào mp2
        Set<Map.Entry<String, Integer>> entry = mp2.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Integer> tmp = iterator.next();
            System.out.println(tmp.getKey() + " " + tmp.getValue());
        }
        enter();




         // Ví dụ về phương thức values
        System.out.println("Ví dụ về phuong thức values của HashMap:");
        Collection<Integer> values = mp.values(); // trả về Collection chứa tất cả các value của HashMap
        Iterator<Integer> iterator1 = values.iterator();
        while(iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        enter();


    }
    public static void enter() {
        System.out.println(hor);
    }
}
