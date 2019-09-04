package EjercicioExamen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class implements Runnable to be able to use with Executor
 * Also it convert to from TXT to CSV 
 * 
 * @author Sebastian Cuatepotzo
 *
 */
public class EscribeCSV implements Runnable{
	
	private String fileName;
	private String fileLog;
		
	public EscribeCSV() {
		
	}
	
	public EscribeCSV(String fileName, String fileLog) {
		this.fileName = fileName;
		this.fileLog = fileLog;
	}
	
	@Override
	public void run() {
		System.out.println("soy el hilo "+ Thread.currentThread());
		escribeArchivo(fileName);
		writeInLog(fileName, fileLog);
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
	
	private static void writeInLog(String fileName, String fileLog) {
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileLog, true));
			writer.append("El hilo " + Thread.currentThread().toString() + " escribio en el log y proceso el archivo " + fileName +"\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
