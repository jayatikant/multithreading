package v.gaurded.blocks;

/**
 * Created by jayati on 5/1/18.
 */
public class Message {

    private String message;
    private boolean empty = true;


    public synchronized void send(String message){
        while (!empty){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        empty = false;
        this.message = message;
        notifyAll();
    }

    public synchronized String getMessage(){
        while (empty){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty = true;
        return this.message;
    }
}
