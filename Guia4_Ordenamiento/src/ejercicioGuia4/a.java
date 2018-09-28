package ejercicioGuia4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class a{
    public static void main(String[] args) throws IOException {

        int tamaño = 2014322; 
        String array[] = new String[tamaño];
    

        FileReader reader = null;
        BufferedReader bufferedReader = null;

       
            reader = new FileReader("src\\ejercicioGuia4\\es.txt");
            bufferedReader = new BufferedReader(reader);

            String line;
   
            for (int i = 0; (line = bufferedReader.readLine()) != null; ++i) {
                array[i] = line;

            }
        	for(int i=0; i<=array.length; i++) {
    			System.out.println(array[i]);
    		
        }
        	  
    }
}
