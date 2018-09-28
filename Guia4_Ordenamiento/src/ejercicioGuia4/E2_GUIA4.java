package ejercicioGuia4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;



public class E2_GUIA4 {

	public static void main(String[] args) throws IOException {

        int tamaño = 2014322; 
        long t1, t2;
        String a_Insersion[] = new String[tamaño];
        String a_Shell[] = new String[tamaño];
        String a_QuickSort[] = new String[tamaño];

        FileReader lectura = null;
        BufferedReader bufferedReader = null;

       
        lectura= new FileReader("src\\ejercicioGuia4\\es.txt");
            bufferedReader = new BufferedReader(lectura);

            String line;
            for (int i = 0; (line = bufferedReader.readLine()) != null; ++i) {
            	a_Insersion[i] = line;
            	a_Shell[i] = line;
            	a_QuickSort[i] = line;
            }
            
            /* metodos_OrdenamientosString.ordenar_Insercion(a_Insersion);
    		System.out.println("Arreglo ordenado por INSERCION array");

        	for(int i=0; i<=a_Insersion.length; i++) {
    			System.out.println(a_Insersion[i]);
    		
        }*/
        	t1 = System.nanoTime();
        	 metodos_OrdenamientosString.ordenamiento_Shell(a_Shell, a_Shell.length);
    		t2 = System.nanoTime();
    		System.out.println("Ordenamiento por shell");
    		System.out.println("Tiempo: " + (t2 - t1) / 1e9 +"s");
    		
           /*  metodos_OrdenamientosString.ordenamiento_Shell(a_Shell, a_Shell.length);
        	System.out.println("Arreglo ordenado por INSERCION array");

        	for(int i=0; i<=a_Shell.length; i++) {
    			System.out.println(a_Shell[i]);
    		
        }*/
    		/* metodos_OrdenamientosString.ordenamiento_QuickSort(a_QuickSort, 0, a_QuickSort.length-1);
        	System.out.println("Arreglo ordenado por INSERCION array");

        	for(int i=0; i<=a_QuickSort.length; i++) {
    			System.out.println(a_QuickSort[i]);
    		
        }*/
    		t1 = System.nanoTime();
    		 metodos_OrdenamientosString.ordenamiento_QuickSort(a_QuickSort, 0, a_QuickSort.length-1);
    		t2 = System.nanoTime();
    		System.out.println("Ordenamiento por QuickSort");
    		System.out.println("Tiempo: " + (t2 - t1) / 1e9 +"s");
            
        	
        	  
    }
	
	
	
	
}
