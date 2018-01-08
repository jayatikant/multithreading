package v.gaurded.blocks;

/**
 * Created by jayati on 5/1/18.
 */
public class Consumer {
    private Message message;

    public Consumer(Message message) {
        this.message = message;
    }

    public void consume(){
        String consumed = "";
        while (!consumed.equals("DONE")){
            consumed = this.message.getMessage();
            System.out.println("got message "+consumed);
        }
    }
}
