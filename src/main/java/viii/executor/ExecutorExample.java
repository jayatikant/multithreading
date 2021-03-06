package viii.executor;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by jayati on 8/1/18.
 */
public class ExecutorExample {

    public static void main(String[] args){
        Executor executor
                 = new Executor() {
            public void execute(Runnable command) {

            }
        };
        System.out.println("This is the main thread :"+Thread.currentThread().getId());
        singleThreadExecutor();
        threadPool();
        cachedThreadPool();
        scheduledThreadPool();
    }

    private static void scheduledThreadPool() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(new SimpleMesasgeThread("This is a scheduled thread with fixed rate"), 100,1000, TimeUnit.MILLISECONDS);
        scheduledThreadPoolExecutor.scheduleWithFixedDelay(new SimpleMesasgeThread("This is a scheduled thread with fixed delay"), 100, 1000, TimeUnit.MILLISECONDS);
    }

    private static void cachedThreadPool() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new SimpleMesasgeThread("This is a cached thread pool (i)"));
        executorService.submit(new SimpleMesasgeThread("This is a cached thread pool (ii)"));
        executorService.submit(new SimpleMesasgeThread("This is a cached thread pool (iii)"));
        executorService.submit(new SimpleMesasgeThread("This is a cached thread pool (iv)"));
    }

    private static void threadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new SimpleMesasgeThread("This is a fixed thread pool (i)"));
        executorService.submit(new SimpleMesasgeThread("This is a fixed thread pool (ii)"));
        executorService.submit(new SimpleMesasgeThread("This is a fixed thread pool (iii)"));
        executorService.submit(new SimpleMesasgeThread("This is a fixed thread pool (iv)"));
    }

    private static void singleThreadExecutor() {
        Executor executor1 = Executors.newSingleThreadExecutor();
        executor1.execute(new SimpleMesasgeThread("This is a single thread executor"));
    }


}

class SimpleMesasgeThread implements Runnable{

    private String message;

    SimpleMesasgeThread(String message) {
        this.message = message;
    }

    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(message);
        System.out.println("This is a new thread :"+Thread.currentThread().getId());
    }
}