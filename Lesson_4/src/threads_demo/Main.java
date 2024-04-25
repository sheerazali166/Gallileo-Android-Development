package threads_demo;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		Thread thread1 = new ThreadObject();
		Thread thread2 = new Thread(new ThreadAltObject());
		
//		thread1.start();
		thread2.start();
		
//		Thread.sleep(500);
//		thread1.interrupt();
//		thread2.interrupt();
	
		thread2.join();
		System.out.println("Main Thread will continue");
		
	
	}

}
