import java.util.concurrent.*;

public class MultithreadingIntro {
	
	public static void main(String[] args) {
		Runnable printFirst = new PrintChar('a', 600);
		Runnable printSecond = new PrintNum(6, 500);
		
		Thread thread1 = new Thread(printFirst);
		Thread thread2 = new Thread(printSecond);
		
		// Share time between these two threads and use 1 output stream
		thread1.start();
		thread2.start();
	}

}

// Java doesn't support multiple inheritance
class PrintNum extends Thread{
	private int num;
	private int times;
	
	// Tells the program what to actually do
	@Override
	public void run() {
		for(int i = 0; i < times; i++) {
			System.out.print(num);
		}
	}
	
	public PrintNum(int num1, int times1) {
		num = num1;
		times = times1;
	}
}

// Tells Java that this task can take a whole thread
class PrintChar implements Runnable{
	private char letter;
	private int times;
	
	@Override
	public void run() {
		for(int i = 0; i < times; i++) {
			System.out.print(letter);
		}
	}
	
	public PrintChar(char letter1, int times1) {
		letter = letter1;
		times = times1;
	}
	
}
