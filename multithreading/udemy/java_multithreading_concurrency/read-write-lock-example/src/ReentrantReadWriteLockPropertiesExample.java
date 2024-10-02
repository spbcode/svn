import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockPropertiesExample{

    public static void main(String args[]){
        ReentrantReadWriteLockPropertiesExample reentrantReadWriteLockPropertiesExample = new ReentrantReadWriteLockPropertiesExample();

        Thread writeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantReadWriteLockPropertiesExample.write();
            }
        });
        Thread readThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantReadWriteLockPropertiesExample.read();
            }
        });
        Thread readThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantReadWriteLockPropertiesExample.read();
            }
        });

        readThread1.start();
        try {
            readThread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        writeThread.start();
        readThread2.start();

    }

    ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    Lock writelock = reentrantReadWriteLock.writeLock();
    Lock readlock = reentrantReadWriteLock.readLock();

    private void write(){
        writelock.lock();
        try{
            System.out.println("writting ....");
            Thread.sleep(5000);
            System.out.println("completed writting ....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writelock.unlock();
        }
    }

    private void read(){
        readlock.lock();
        try {
            System.out.println("reading ...."+Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("completed reading ...."+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readlock.unlock();
        }
    }
}
