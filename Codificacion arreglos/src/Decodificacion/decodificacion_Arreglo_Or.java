package Decodificacion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



public class decodificacion_Arreglo_Or {

	public static void main(String[] args) throws IOException {
		long t1, t2;
		
		int tamaño = 2014322, i,j;
		Scanner entrada= new Scanner(System.in);
        String arreglo_Ordenado[] = new String[tamaño];
        FileReader lectura = null;
        BufferedReader bufferedReader = null;
        String line;
        boolean encontro=false;
        
        System.out.println("Ingrese los numeros para decodificar");
        String codificacion= entrada.nextLine(); 
        t1 = System.nanoTime();
        
         String split[]= codificacion.split("-");
        int a_codificado[]=new int[split.length]; 
        
        for(i=0;i<split.length;i++)
         a_codificado[i]=Integer.parseInt(split[i]);
        
        
        lectura= new FileReader("src\\arreglo\\es.txt");
        bufferedReader = new BufferedReader(lectura);

        for ( i = 0; (line = bufferedReader.readLine()) != null; ++i) 
        	arreglo_Ordenado[i] = line;

   		ordenamiento_QuickSort(arreglo_Ordenado, 0, arreglo_Ordenado.length-1);
   		
   		for( j=0; j<a_codificado.length; j++) {
   			String palabra= arreglo_Ordenado[a_codificado[j]];
   			System.out.print(palabra+" ");
   			}
   			
   		
   		t2 = System.nanoTime();
		System.out.println("\nTiempo: " + (t2 - t1) / 1e9 +"s");  	  
   }
	
	public static void ordenamiento_QuickSort(String array[], int left , int right) {
        int l = left, r = right;
        String aux;

        do {
            while (array[r].compareTo(array[l]) >0  && r > l)
            	r--;
            if (l < r) {
            	aux = array[l];
                array[l] = array[r];
                array[r] = aux;
                l++;
            }
            while (array[l].compareTo(array[r]) <0  && l < r) {
                l++;
            }

            if (l < r) {
            	aux = array[l];
                array[l] = array[r];
                array[r] = aux;
                r--;
            }
        }
        while (l < r);
        if (left < r) {
        	ordenamiento_QuickSort(array, left, r - 1);
        }
        if (l < right) {
        	ordenamiento_QuickSort(array, l + 1, right);
        }
	
	}
}


