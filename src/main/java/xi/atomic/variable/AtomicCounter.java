package xi.atomic.variable;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by jayati on 8/1/18.
 */
class AtomicCounter {
    private AtomicInteger c = new AtomicInteger(0);

    public void increment() {
        c.incrementAndGet();
    }

    public void decrement() {
        c.decrementAndGet();
    }

    public int value() {
        return c.get();
    }

    public static void main(String[] args) throws InterruptedException {

        final AtomicCounter atomicCounter = new AtomicCounter();

        Thread thread = new Thread(new Runnable() {
            public void run() {
                atomicCounter.decrement();
                System.out.println("Decrementing " + atomicCounter.value());
            }
        });


        thread.start();

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                atomicCounter.increment();
                System.out.println("Incrementing " + atomicCounter.value());
            }
        });

        thread2.start();
        thread.join();
        thread2.join();

        System.out.println("Value should be 0 now " + atomicCounter.value());
    }

}
