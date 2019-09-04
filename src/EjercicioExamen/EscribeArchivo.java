package EjercicioExamen;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * This class write a big TXT file
 * 
 * @author Sebastian Cuatepotzo
 *
 */
public class EscribeArchivo {

	public static void main(String[] args) {
		
		String filename = "/home/elcuato/Documents/Workspaces/HackerRank/ejemploTXT.txt";
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
			
			for (int i = 0; i < 35835; i++) {
				String str = i + "|" +i + "|" +i + "|" +i + "|" +i + "|"+i ;    
			    writer.append(str);
			    writer.append("\n");
			}
		    writer.close();
		}catch (Exception e) {
		}

	}

}
