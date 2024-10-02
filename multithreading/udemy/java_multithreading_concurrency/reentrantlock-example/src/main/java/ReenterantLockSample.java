import java.util.concurrent.locks.ReentrantLock;

public class ReenterantLockSample implements Runnable {

private ReentrantLock reentrantLock = new ReentrantLock();
    @Override
    public void run() {
        reentrantLock.tryLock();
        try{
            System.out.println(reentrantLock.isHeldByCurrentThread()+"::"+reentrantLock.getHoldCount()+"....."
                    +reentrantLock.getQueueLength()+"....."+Thread.currentThread().getName()
            +"..."+reentrantLock.isHeldByCurrentThread());
        }finally {
//           if(reentrantLock.isHeldByCurrentThread())
               reentrantLock.unlock();
        }
    }

    public static void main(String args[]){
        ReenterantLockSample reenterantLockSample = new ReenterantLockSample();
        Thread thread1 = new Thread(reenterantLockSample);
        Thread thread2 = new Thread(reenterantLockSample);
        Thread thread3 = new Thread(reenterantLockSample);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
