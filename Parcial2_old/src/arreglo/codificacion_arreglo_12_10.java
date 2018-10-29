package arreglo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class codificacion_arreglo_12_10 {

	public static void main(String[] args) throws IOException {
		long t1, t2;
		Scanner in=new Scanner(System.in);
		int tam= 2014322; 
        String array[] = new String[tam];
   //     String nuevo[][] = new String[tam][2];
        
        String line;
        String numCadena;		

        FileReader reader = null;
        BufferedReader bufferedReader = null;

       
            reader = new FileReader("src\\arreglo\\es.txt");
            bufferedReader = new BufferedReader(reader);

            System.out.println("ingrese las palabra que quiere decodificar separadas por un espacio");
        	String words=in.nextLine();
        	t1 = System.nanoTime();
        	
            for (int i = 0; (line = bufferedReader.readLine()) != null; ++i) 
                array[i] = line;
            ordenar(array,0,array.length-1);
            
            
            /*for(int i=0;i<array.length;i++) {
            	nuevo[i][0]=array[i];
            	numCadena= Integer.toString(i);
            	nuevo[i][1] = numCadena;
            } */
        	
        	String split[]= words.split(" ");
        	
        	for(int a=0;a<split.length;a++) {
        		
        	for(int i=0;i<=split[a].length(); i++ ) {
			String valor=split[a].substring(0,split[a].length()-i);	
			String pCodif=buscar(array,valor,0,tam-1);
			if(pCodif.compareTo("no existe")!=0) {
				i=split[a].length();
        	}	
        	System.out.println(pCodif+" es la codificacion de la palabra "+split[a]);
        	}
        	}
        	
        	t2 = System.nanoTime();
    		System.out.println("Tiempo: " + (t2 - t1) / 1e9 +"s"); 
	}
	private static String buscar(String nuevo[],String valor,int left,int right) {
		int dere=right;
		int izq=left;
		int mitad=(dere-izq)/2+left;
		System.out.println(valor);
		if(mitad==0 &&(nuevo[mitad].compareTo(valor)!=0)) {
			return "no existe";
			
		}
			if(nuevo[mitad].compareTo(valor)<0) //b es mayor que a
				return buscar(nuevo,valor,mitad,dere);
			
			else {
				if(nuevo[mitad].compareTo(valor)>0) //a es mayor que b
					return buscar(nuevo,valor,izq,mitad);
				
				else {
					if(nuevo[mitad].compareTo(valor)==0) //son iguales
						return  Integer.toString(mitad);
					
				}
				
			}
		return "no existe";
	}
	private static void ordenar(String array[], int left , int right) {
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
        	ordenar(array, left, r - 1);
        }
        if (l < right) {
        	ordenar(array, l + 1, right);
        }
	
	}
}
