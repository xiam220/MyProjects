import java.util.concurrent.*;
// Manipulate different locks at the same time and communicate between
// various locks
import java.util.concurrent.locks.*;

public class AccountWithSync {
	private static Account userAccount = new Account();
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for(int i = 0; i < 100; i++) {
			executor.execute(new AddAPenny());
		}
		executor.shutdown();
		while(!executor.isShutdown()) {
		}
		System.out.println("What is balance? " + userAccount.getBalance());
	}
	
	private static class AddAPenny implements Runnable{
		// Synchronize method based on userAccount
		public synchronized void run() {
				userAccount.deposit(1);
		}
	}
	
	private static class Account{
		// Shared amongst all thread we will create
		// ReentrantLock(true) : the thread with the highest priority
		// and longest wait time will run
		private static Lock lock = new ReentrantLock(true);
		private int balance = 0;
		public int getBalance() {
			return balance;
		}
		
		public void deposit(int amount) {
			lock.lock();
			try {
				int newBalance = balance + amount;
				balance = newBalance;
			}
			finally {
				// When this thread finishes, release the lock and
				// make sure other threads get access to our program
				lock.unlock();
			}
			
		}
		
	}
}
