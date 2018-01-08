package ii.synch.method;

/**
 * Created by jayati on 4/1/18.
 */
public class SynchedMethods {

    public static void main(String[] args){
        final Model model
                 = new Model();
        model.incrementCounter();
         new Thread(new Runnable() {
            public void run() {

                System.out.println("Incrementing counter, it should be 2 now");
                model.incrementCounter();

                System.out.println("Incremented Counter "+model.getCounter());
            }
        }).start();

         new Thread(new Runnable() {
            public void run() {
                System.out.println("Decrementing counter, it should be 1 now");
                model.decrementcounter();

                System.out.println("Decremented Counter "+model.getCounter());
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                System.out.println("Decrementing counter, it should be 0 now");
                model.decrementcounter();

                System.out.println("Decremented Counter "+model.getCounter());
            }
        }).start();
    }

}


class Model{
     private int counter;
     public synchronized void incrementCounter(){
         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         counter++;
     }

     public synchronized void decrementcounter(){
         try {
             Thread.sleep(10);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         counter--;
     }

     public  int getCounter(){
         return counter;
     }
}