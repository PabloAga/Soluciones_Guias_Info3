package Decodificacion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class decodificacion_S_Or {
	public static void main(String[] args) throws IOException {
		long t1, t2;
		
		int tamaño = 2014322, i,j;
		Scanner entrada= new Scanner(System.in);
        String arreglo_Palabras[] = new String[tamaño];
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
        	arreglo_Palabras[i] = line;

   		
   		for( j=0; j<a_codificado.length; j++) {
   			String palabra= arreglo_Palabras[a_codificado[j]];
   			System.out.print(palabra+" ");
   			}
   			
   		
   		t2 = System.nanoTime();
		System.out.println("\nTiempo: " + (t2 - t1) / 1e9 +"s");  	  
   }
	
}