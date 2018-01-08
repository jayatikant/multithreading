package iii.synch.statement;

/**
 * Created by jayati on 4/1/18.
 */
public class SynchedStatements {
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

    public void incrementCounter(){
        synchronized (this){
            counter++;
        }
    }

    public synchronized void decrementcounter(){
        synchronized (this){
            counter--;
        }
    }

    public int getCounter(){
        return counter;
    }

}
