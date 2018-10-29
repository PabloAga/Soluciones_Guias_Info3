package Parcial2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class pruba_Signos {
	public static void main(String[] args) throws IOException {
		long t1, t2;
		Scanner entrada= new Scanner(System.in);
		int tamaño = 2014322, p=0;
        String arreglo_Ordenado[] = new String[tamaño];
        FileReader lectura = null;
        BufferedReader bufferedReader = null;
        String line, pCodif="0",valor="0";
        boolean borro=false, pn=false;
        
        System.out.println("Ingrese la frase a codificar");
        String frase= entrada.nextLine();
        
        t1 = System.nanoTime();
		String split[]= frase.split(" ");
		String codificado[] = new  String[split.length];
		String signos[] = new  String[split.length];
        
        lectura= new FileReader("src\\arreglo\\es.txt");
        bufferedReader = new BufferedReader(lectura);
        
        for (int i = 0; (line = bufferedReader.readLine()) != null; ++i) //ordeno el arreglo de palabras
        	arreglo_Ordenado[i] = line;

   		ordenamiento_QuickSort(arreglo_Ordenado, 0, arreglo_Ordenado.length-1);
 
   		for(int j=0; j<split.length; j++) {
   			for(int i=0;i<=split[j].length(); i++ ) {
			valor=split[j].substring(0,split[j].length()-i);
			pCodif= buscar(arreglo_Ordenado, valor);
			if(pCodif.compareTo("no existe")!=0) {
				i=split[j].length();
				break;
        	}	
		//	if(j!=2)
				
        	borro=true;
        
        	
        	int k=0, l=0;
   			if(borro) {
   				line=split[j].substring(split[j].length()-(i+1),split[j].length());	
   				if(line.charAt(0)=='!'||line.charAt(0)=='?'||line.charAt(0)==','||line.charAt(0)=='.') {
   					String sig=line;
   					
   					signos[p]=line;
   					p++;
   				}
   				else {
   	   				pCodif="no existe";
   	   			System.out.println(pCodif+"  la codificacion de la palabra "+split[j]);
   	   			codificado[j]=pCodif;
   	   			i=split[j].length();
   	   			pn=true;
   				}
   				
   			}
   			}
   			if(!pn) {
   			System.out.println(pCodif+"  la codificacion de la palabra "+valor);
   			codificado[j]=pCodif;
   			}
   			pn=false;
   			borro=false;
   		}

   		int h=p;
   		System.out.println("\nLa codificasion de la frase ingresada es la siguiente: ");
   		for(int i = 0; i<codificado.length-1;i++) {
   			
   			if(codificado[i].compareTo("no existe")!=0)//para no imprimir la codificacion de una palabra no encontrada
   			System.out.print(codificado[i]+signos[i]+"-");
   			h--;
   		}
   		if(codificado[codificado.length-1].compareTo("no existe")!=0)
   		System.out.print(codificado[codificado.length-1]);
   		if(codificado[codificado.length-1].compareTo("no existe")!=0&&h==1)
   			System.out.print(signos[p-1]);
   		
          
   		t2 = System.nanoTime();
		System.out.println("\nTiempo: " + (t2 - t1) / 1e9 +"s"); 
   }
	public static String buscar(String arreglo_Ordenado[], String palabra) {
		int t=0;

		
			for(int i=0; i<arreglo_Ordenado.length;i++ ) {
   				int r= palabra.compareTo(arreglo_Ordenado[i]);
   				if(r==0) 
   					return  Integer.toString(i);
   			}
   				return "no existe";
	
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

