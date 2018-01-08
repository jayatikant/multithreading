package v.gaurded.blocks;

/**
 * Created by jayati on 5/1/18.
 */
public class Main {

    public static void main(String[] args) {

        Message message
                = new Message();
        final Producer producer
                = new Producer(message);
        final Consumer consumer
                = new Consumer(message);
        new Thread(new Runnable() {
            public void run() {
            producer.produce();
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                consumer.consume();
            }
        }).start();
    }
}
