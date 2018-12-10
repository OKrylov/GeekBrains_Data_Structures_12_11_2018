import java.util.*;

public class Main8 {

    public static void main(String[] args) {
//        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Oleg", 26);
        map.put("Petr", 31);
        map.put("Andrey", 21);


        Set<String> set = new HashSet<>();
        set.add("aaa");
        set.add("aaa");
        set.add("bbb");
        set.forEach(v -> {
            System.out.println(v);
        });

//        map.remove("Petr");
//
//        for (String key : map.keySet()) {
//            Integer value = map.get(key);
//            System.out.println(String.format("Key %s; value: %s", key, value));
//        }

        map.forEach((k, v) -> {
            System.out.println(String.format("Key %s; value: %s", k, v));
        });

//        testHashtable();

    }

    private static void testHashtable() {
        HashTable hashTable = new HashTable(10);

        hashTable.add(new Person("Petr", 1));
        hashTable.add(new Person("Petr", 15));
        hashTable.add(new Person("Petr", 57));
        hashTable.add(new Person("Petr", 21));
        hashTable.add(new Person("Petr", 18));
        hashTable.add(new Person("Petr", 49));
        hashTable.add(new Person("Petr", 81));
        hashTable.add(new Person("Petr", 27));

        hashTable.display();

        System.out.println("Search-----------");
        System.out.println(hashTable.find(15));
        System.out.println(hashTable.find(188));
        System.out.println("Remove-----------");
        System.out.println(hashTable.delete(188));
        System.out.println(hashTable.delete(21));
        hashTable.display();

        System.out.println("Size is " + hashTable.getSize());
    }
}
