package ConcurrentHashMapFunda;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Adwiti on 8/13/2017.
 */
public class ThreadingInConcurrentHashMap extends Thread {
    private static Map<Integer,String> map = new ConcurrentHashMap<>();

    @Override
    public void run() {
        System.out.println("Child Thread iterating...");
        try {
            Thread.sleep(2000);
            System.out.println("Adding values to Concurrent Hash Map...");
            map.put(3,"three");
            System.out.println(map);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Adding values to hash Map with main thread...");
        map.put(1,"one");
        map.put(2,"two");
        ThreadingInConcurrentHashMap t = new ThreadingInConcurrentHashMap();
        System.out.println("Starting main Thread...");
        t.start();
        map.forEach((k,v) -> {
            System.out.print( k + " = " + v + " ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
