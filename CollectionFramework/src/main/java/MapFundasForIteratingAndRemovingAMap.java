import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Adwiti on 7/30/2017.
 */
public class MapFundasForIteratingAndRemovingAMap {
    public static void main(String[] args) {

        Map<String, String> mapOfStrings = new HashMap<String, String>();
        mapOfStrings.put("1", "one");
        mapOfStrings.put("2", "two");
        mapOfStrings.put("3", "three");
        mapOfStrings.put("4", "four");

        IterateHashMapUsingKeySet(mapOfStrings);
        IterateHashMapUsingEntrySet(mapOfStrings);
        IterateMapUsingJava8(mapOfStrings);
        removeAKeyWhileIteratingAMapUsingJava8(mapOfStrings);
        removeValuesWhileIteratingAMapUsingJava8(mapOfStrings);
        removeAkeyWhileIteratingAMap(mapOfStrings);
    }

    /**
     * @param mapOfStrings iterating a map using key set, we can iterate a map but cannot modify it.
     */
    public static void IterateHashMapUsingKeySet(Map<String, String> mapOfStrings) {
        System.out.println("Iterating Using Key Set...");
        Set<String> keys = mapOfStrings.keySet();
        for (String key : keys) {
            System.out.println(key + " : " + mapOfStrings.get(key));
            //mapOfStrings.remove(key); will give concurrent modification exception
        }
    }

    public static void IterateHashMapUsingEntrySet(Map<String, String> mapOfStrings) {
        System.out.println("Iterating using Entry set...");
        Set<Map.Entry<String, String>> entries = mapOfStrings.entrySet();
        for (Map.Entry entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            //mapOfStrings.remove(entry.getKey()); this will give concurrent modification exception
        }
    }

    public static void IterateMapUsingJava8(Map<String, String> mapOfStrings) {
        System.out.println("Iterate using java 8 for each loop...");
        mapOfStrings.forEach((k, v) -> {
            System.out.println(k + " : " + v);
        });
    }

    public static void removeAKeyWhileIteratingAMapUsingJava8(Map<String, String> mapOfStrings) {
        System.out.println("Removing a key while iterating in java 8...");
        mapOfStrings.entrySet().removeIf(entry -> entry.getKey().equalsIgnoreCase("1"));
    }

    public static void removeValuesWhileIteratingAMapUsingJava8(Map<String, String> mapOfStrings) {
        System.out.println("Removing a value while iterating in java 8...");
        mapOfStrings.entrySet().removeIf(entry -> entry.getValue().equalsIgnoreCase("two"));
    }

    public static void removeAkeyWhileIteratingAMap(Map<String, String> mapOfStrings) {
        System.out.println("Iterating and removing from a map");
        Set<Map.Entry<String, String>> entries = mapOfStrings.entrySet();
        Iterator<Map.Entry<String, String>> iter = entries.iterator();

        while (iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
            iter.remove();
        }

        System.out.println(mapOfStrings);
    }


}
