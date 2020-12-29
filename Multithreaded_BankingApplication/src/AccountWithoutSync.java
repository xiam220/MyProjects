import java.util.concurrent.*;
public class AccountWithoutSync {
	private static Account userAccount = new Account();
	public static void main(String[] args) {
		// If you have extra threads in the cache, you can use them for
		// future tasks; don't need to manually specify the number of
		// threads you want
		ExecutorService executor = Executors.newCachedThreadPool();
		for(int i = 0; i < 100; i++) {
			executor.execute(new AddAPenny());
		}
		
		// If operations are already running, keep running
		// If you have new operations, don't run them yet
		executor.shutdown();
		while(!executor.isShutdown()) {
			
		}
		System.out.println("What is balance? " + userAccount.getBalance());
	}
	private static class AddAPenny implements Runnable{
		public void run() {
				userAccount.deposit(1);
		}
	}
	
	private static class Account{
		private int balance = 0;
		
		public void deposit(int amount) {
			int newBalance = balance + amount;
			try {
				Thread.sleep(1); // Time in milliseconds
			}
			catch(InterruptedException ex) {
				// Don't need to do anything other than catch the Exception
			}
			balance = newBalance;
		}
		
		public int getBalance() {
			return balance;
		}
		
		
	}
}
