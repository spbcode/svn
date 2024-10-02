import java.util.concurrent.Semaphore;

public class SemaphoreProducerConsumer {
    Semaphore producersemaphore = new Semaphore(0);
    Semaphore consumersemaphore = new Semaphore(2);

    public void produce(){
        try {
            consumersemaphore.acquire();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("item produced..."+Thread.currentThread().getName());
        producersemaphore.release();
    }

    public void consume(){
        try {
            producersemaphore.acquire();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("item consumed..."+Thread.currentThread().getName());
        consumersemaphore.release();
    }
    static int count = 10;
    public static void main(String args[]) throws InterruptedException {
        SemaphoreProducerConsumer spc = new SemaphoreProducerConsumer();
        Thread p = new Thread(() ->{
            for(int i=0;i<count;i++){
                spc.produce();
            }
        });
        Thread p2 = new Thread(() ->{
            for(int i=0;i<count;i++){
                spc.produce();
            }
        });
        Thread c = new Thread(()-> {
            for(int i=0;i<count;i++){
                spc.consume();
            }
        });
        Thread c2 = new Thread(()-> {
            for(int i=0;i<count;i++){
                spc.consume();
            }
        });
        p.setName("producer");
        p2.setName("producer2");
        c.setName("consumer");
        c2.setName("consumer2");

        p.start();
        p2.start();

        c2.start();
        c.start();

        p.join();
        c.join();
    }
}
