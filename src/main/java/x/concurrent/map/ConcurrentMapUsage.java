package x.concurrent.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jayati on 8/1/18.
 */
public class ConcurrentMapUsage {

    public static void main(String[] args) throws InterruptedException {
        final ConcurrentHashMap<String, String> dictionary = new ConcurrentHashMap<String, String>();

        Thread thread = new Thread(new Runnable() {
            public void run() {
                String result = dictionary.putIfAbsent("New", "Sample");
                System.out.println("1 " +result);
            }
        });


        thread.start();

       Thread thread2 =  new Thread(new Runnable() {
            public void run() {
                String result = dictionary.putIfAbsent("New", "Sample");
                System.out.println("2 "+result);
                result = dictionary.putIfAbsent("New2", "Sample2");
                System.out.println("3 "+result);
            }
        });

       thread2.start();
       thread.join();
       thread2.join();
        System.out.println(dictionary);
    }
}
