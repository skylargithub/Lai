package multi;

public class HelloRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10000; i++) {
			System.out.println("A" + i);
			if(Thread.interrupted()) {
				System.out.println(i);
				return;
			}
		} 
		
		//System.out.println("A");
	}

	public static void main(String[] args) {
		Thread thread = new Thread(new HelloRunnable());
		thread.start();
		for(int i = 0; i < 1000; i++) {
			System.out.println(i);
		}
		thread.interrupt();
		
	}
}
