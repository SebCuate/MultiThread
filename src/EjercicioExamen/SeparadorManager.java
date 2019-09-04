package EjercicioExamen;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * This class manage the process to read the big TXT to:
 * 1.- Divide it, cutting every n lines to get a new TXT file
 * 2.- Transform the generated files into CSV
 *  
 * @author Sebastian Cuatepotzo
 *
 */
public class SeparadorManager {

	public static void main(String[] args) {
		
		int numHilos = 5;
		int limit = 777;
		String path =  "/home/elcuato/Documents/Workspaces/HackerRank/archivos/";
		String fileName = "/home/elcuato/Documents/Workspaces/HackerRank/ejemploTXT.txt";
		String fileLog= "/home/elcuato/Documents/Workspaces/HackerRank/Server.log";
		
		long init = System.currentTimeMillis(); // Instante inicial del procesamiento
		
		List<String> files = new ArrayList<>();// check the method to get the file list	
		files = divideTXT(fileName, path, limit);
		
		executeThreads(files, numHilos, fileLog);

		//PRINT RESULTS
		long fin = System.currentTimeMillis(); // Instante final del procesamiento
		
		System.out.println("Execution time: " + (fin-init) +" miliseconds");// convert to Server.log
	}
	
	
	
	private static List<String> divideTXT(String fileName, String path, int limit) {
		return new DivideArchivo().divideArchivo(fileName, path, limit);
	}
	
	private static void executeThreads(List<String> files, int numHilos, String fileLog) {

		ExecutorService executor = Executors.newFixedThreadPool(numHilos);
		for (String file: files) {
			EscribeCSV util = new EscribeCSV(file, fileLog);
			executor.execute(util);
		}
		executor.shutdown(); // Cierro el Executor
		while (!executor.isTerminated()) {
			// Espero a que terminen de ejecutarse todos los procesos
			// para pasar a las siguientes instrucciones
		}
		
		return;
	}
	
	
}
