import java.util.*;

/**
 * Created by Adwiti on 7/30/2017.
 */
public class MapFundasForSortingAMapByKeyBeforeJava8 {

    public static void main(String[] args) {
        Map<String, String> unsortedMap = addValuesToMap();
        printMap(unsortedMap);
        System.out.println("After Sorting...");
        Map<String, String> sortedMap = sortMapUsingTreeMap(unsortedMap);
        printMap(sortedMap);

        System.out.println("sorting hashmap in descending order ");
        sortedMap = sortMapInDescendingOrder(unsortedMap);
        printMap(sortedMap);

    }

    public static Map<String, String> addValuesToMap() {
        Map<String, String> maps = new HashMap<>();
        maps.put("one", "Mon");
        maps.put("two", "Tue");
        maps.put("five", "Fri");
        maps.put("six", "Sat");
        maps.put("three", "Wed");
        maps.put("four", "Thur");
        return maps;
    }

    public static void printMap(Map<String, String> maps) {
        maps.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        });
    }

    public static Map<String, String> sortMapUsingTreeMap(Map<String, String> unsortedMap) {
        Map<String, String> sortedMap = new TreeMap<>(unsortedMap);
        return sortedMap;
    }

    public static Map<String, String> sortMapInDescendingOrder(Map<String, String> unsortedMap) {
        Map<String, String> sortedMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        sortedMap.putAll(unsortedMap);
        return sortedMap;
    }

}
