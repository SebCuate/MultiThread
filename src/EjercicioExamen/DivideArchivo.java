package EjercicioExamen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * This class just divide a big TXT file
 * 
 * @author Sebastian Cuatepotzo
 *
 */
public class DivideArchivo {

//	static String path =  "/home/elcuato/Documents/Workspaces/HackerRank/archivos/";
//	static {
//		new File(path).mkdirs();
//	}
	
	public List<String> divideArchivo(String fileName, String path, int limit) {
		
		new File(path).mkdirs();
		
		BufferedReader reader;
		BufferedWriter writer;
		int fileNumber = 0;
		String line;
		List<String> files = new ArrayList<>();
		
		try {
			reader = new BufferedReader(new FileReader(fileName));
			line = reader.readLine();
			while(line != null) {
				
				writer = new BufferedWriter(new FileWriter(path + "Archivo_" + fileNumber+ ".txt", true));
				files.add(path + "Archivo_" + fileNumber+ ".txt");
				
				int j = 0;
				
				while(j < limit && line != null) {
					writer.append(line);
				    writer.append("\n");
				    line = reader.readLine();
				    j++;
				}
				writer.close();
				fileNumber++;
			}
			
		}catch (Exception e) {
		}
		
		return files;
		
	}
	
//	public static void main(String[] args) {
//		
//		DivideArchivo d1 = new DivideArchivo();
//		String fileName = "/home/elcuato/Documents/Workspaces/HackerRank/ejemploTXT.txt";
//		int limit = 77;
//		d1.divideArchivo(fileName, limit);
//		
//	}

}
