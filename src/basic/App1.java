package basic;

class Runner1 extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Hello "+ i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}



public class App1 {
	
	

	public static void main(String[] args) {
		Runner1 runner1 = new Runner1();
		runner1.start();
	}

}
