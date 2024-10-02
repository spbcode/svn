import java.util.Date;

public class Main {

	public static void main(String[] args) throws InterruptedException {
//		Thread.sleep(20000);
//		System.out.println("starting the work...");
		Date startdate = new Date();
		PrimeNumbers primeNumbers = new PrimeNumbers();
		Integer max = Integer.parseInt(args[0]);
		primeNumbers.generateNumbers(max);
		Date enddate = new Date();
		System.out.println("Elapsed time was "+(enddate.getTime()-startdate.getTime()));
	}

}
