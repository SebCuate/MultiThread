package Volatile;

import java.util.Scanner;

class Processor extends Thread{
	
	private static boolean running = true;
	private String text = "";
	
	public Processor(String text) {
		this.text = text;
	}
	
	public void run() {
		
		
		
		while(running) {
			System.out.println(this.text);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void shutdownn() {
		running = false;
	}
	
}

public class App1 {

	public static void main(String[] args) {
		Processor p1 = new Processor("Hello");
		Processor p2 = new Processor("Good bye");
		p1.start();
		p2.start();
		
		Scanner sca = new java.util.Scanner(System.in);
		sca.nextLine();
		
		p1.shutdownn();

	}

}
