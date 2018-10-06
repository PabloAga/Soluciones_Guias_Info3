package arreglo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class codificacion_S_Or {
	public static void main(String[] args) throws IOException {
		long t1, t2;
		Scanner entrada= new Scanner(System.in);int tamaño = 2014322, t=0;
        String arreglo_Palabras[] = new String[tamaño];
        FileReader lectura = null;
        BufferedReader bufferedReader = null;
        String line;
        boolean encontro=false;
        
        System.out.println("Ingrese la frase a codificar");
        String frase= entrada.nextLine();
        
        t1 = System.nanoTime();
		String split[]= frase.split(" ");
		int codificado[] = new  int[split.length];
        
        lectura= new FileReader("src\\arreglo\\es.txt");
        bufferedReader = new BufferedReader(lectura);
        
        for (int i = 0; (line = bufferedReader.readLine()) != null; ++i) //ordeno el arreglo de palabras
        	arreglo_Palabras[i] = line;

   		
   		for(int j=0; j<split.length; j++) {
   			for(int i=0; i<arreglo_Palabras.length;i++ ) {
   				int r= split[j].compareTo(arreglo_Palabras[i]);
   				if(r==0) {
   					codificado[t]= i;
   					//System.out.println("la palabra "+split[j]+" esta en la posicion"+ i);
   					encontro=true;
   					t++;
   					i=arreglo_Palabras.length;
   				}
   				
   			}
   			if(!encontro){
   				System.out.println("La palabra '"+split[j]+"' NO se encontro");	
   			}
   			encontro=false;
   		}
   		
   		
   		for(int i = 0; i<codificado.length-1;i++) {
   			if(codificado[i]!=0)//para no imprimir la codificacion de una palabra no encontrada
   			System.out.print(codificado[i]+"-");
   		}
   		if(codificado[codificado.length-1]!=0)
   		System.out.println(codificado[codificado.length-1]);
          
   		t2 = System.nanoTime();
		System.out.println("Tiempo: " + (t2 - t1) / 1e9 +"s"); 
   }
}	