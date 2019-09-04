package EjercicioExamen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class EscribeCSV implements Runnable{
	
	private String fileName;
		
	public EscribeCSV() {
		
	}
	
	public EscribeCSV(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public void run() {
		System.out.println("soy el hilo "+ Thread.currentThread());
		escribeArchivo(fileName);
	}
	
	private void escribeArchivo(String fileName) {
		BufferedReader reader;
		BufferedWriter writer;
		String line;
		
		try {
			reader = new BufferedReader(new FileReader(fileName));
			line = reader.readLine();
			writer = new BufferedWriter(new FileWriter(fileName.replace(".txt", ".csv"), true));
			while(line != null) {
				line = line.replace("1", "A").replace("2", "B").replace("3", "C").replace("4", "D");
				line = line.replace("5", "Z").replace("6", "Y").replace("7", "X").replace("8", "W");
				line = line.replace("9", "S").replace("0", "R");
				writer.append(line);
			    writer.append("\n");
			    line = reader.readLine();
			}
			writer.close();
			
		}catch (Exception e) {
		}
	}
	
}
