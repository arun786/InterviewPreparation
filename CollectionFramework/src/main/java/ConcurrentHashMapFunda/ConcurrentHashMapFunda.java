package ConcurrentHashMapFunda;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Adwiti on 8/13/2017.
 */
public class ConcurrentHashMapFunda {
    public static void main(String[] args) {
        /*points to remember
                1. CHM is thread safe, it allows concurrent read and thread safe update
                2. To perform read operation, lock is not required
                3. A bucket level lock is required for updating CHM
                4. CHM has a default concurrency level as 16
                5. null is not allowed in both key and value
                6. CHM is fail safe which means it wont throw concurrent modification exception if  update operation is performed while iterating
                7. It has 5 different constructors
                */

        Map<String, Integer> cricketersWithRun = new ConcurrentHashMap<>();
        cricketersWithRun.put("Sachin", 10000);
        cricketersWithRun.put("Rahul", 5000);
        cricketersWithRun.put("Sourav", 6000);
        cricketersWithRun.put("Kohli", 10000);

        System.out.println(cricketersWithRun);

        /*how to iterate over a ConcurrentHashMap in java 8*/
        cricketersWithRun.forEach((k, v) -> System.out.println(k + "-" + v));

        //to remove a key, we use iterator since iterator of concurrent hash map are fail safe, which means it wont throw concurrentModification exception
        cricketersWithRun.entrySet().removeIf(entrySet -> entrySet.getKey().contains("Rahul"));
        System.out.println("after removal..");
        cricketersWithRun.forEach((k, v) -> System.out.println(k + "-" + v));

        System.out.println("To remove based on value, to remove where the value is 10000");
        cricketersWithRun.entrySet().removeIf(entry -> entry.getValue().equals(10000));
        cricketersWithRun.forEach((k, v) -> System.out.println(k + "-" + v));

        //to update a value in concurrent hash map
        Integer oldValue;
        Integer newValue;
        do {
            oldValue = cricketersWithRun.get("Sourav");
            newValue = oldValue == null ? 10000 : oldValue + 500;
        } while (!cricketersWithRun.replace("Sourav", oldValue, newValue));

        System.out.println(cricketersWithRun);

    }

}
