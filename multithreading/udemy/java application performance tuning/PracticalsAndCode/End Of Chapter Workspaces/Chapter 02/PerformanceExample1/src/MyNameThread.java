import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MyNameThread {	
	
	/**
	 * @param args
	 */
	public static void main(String args[]) {
//		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		for(int i=0;i<50;i++) {
			try {
				CountDownLatch countDownLatch = new CountDownLatch(3);
			Thread mythread = new Thread(new MyThread(countDownLatch));
			Thread nameThread = new Thread(new NameThread(mythread,countDownLatch));
			Thread samThread = new Thread(new SamThread(nameThread,countDownLatch));
//			executorService.submit(mythread);
//			executorService.submit(nameThread);
//
//			executorService.submit(samThread);
			mythread.start();
			nameThread.start();
			samThread.start();
			
				countDownLatch.await();
				System.out.println();
				System.out.print("----------------"+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class MyThread implements Runnable{
	CountDownLatch CountDownLatch;
	
	

	public MyThread(java.util.concurrent.CountDownLatch countDownLatch) {
		super();
		CountDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println();
			System.out.print("My ");
			CountDownLatch.countDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

class NameThread implements Runnable{
	
	Thread mythread;
	CountDownLatch CountDownLatch;

	public NameThread(Thread mythread) {
		super();
		this.mythread = mythread;
	}



	public NameThread(Thread mythread, java.util.concurrent.CountDownLatch countDownLatch) {
		super();
		this.mythread = mythread;
		CountDownLatch = countDownLatch;
	}



	@Override
	public void run() {
		try {
			mythread.join();
			System.out.print("Name is ");
			CountDownLatch.countDown();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

class SamThread implements Runnable{

	Thread nameThread;
	CountDownLatch CountDownLatch;
	
	
	public SamThread(Thread nameThread, java.util.concurrent.CountDownLatch countDownLatch) {
		super();
		this.nameThread = nameThread;
		CountDownLatch = countDownLatch;
	}


	public SamThread(Thread nameThread) {
		super();
		this.nameThread = nameThread;
	}


	@Override
	public void run() {
		try {
			nameThread.join();
			System.out.print("Sam");
			CountDownLatch.countDown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
