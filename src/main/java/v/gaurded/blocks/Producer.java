package v.gaurded.blocks;

/**
 * Created by jayati on 5/1/18.
 */
public class Producer {


    private Message message;
    private String[] messages = new String[]{"One", "two", "three", "four", "DONE"};

    public Producer(Message message) {
        this.message = message;
    }

    public void produce(){
        for(String messageString:messages){
            message.send(messageString);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("I was interrupted");
            }
        }
    }
}
