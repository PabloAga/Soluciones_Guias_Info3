package Parcial2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;



public class App_Ultima_Joel {

	public static void main(String[] args) throws Exception  {
		String a;
		Scanner in= new Scanner(System.in);
		
		long TInicio, TFin, tiempo,tiempototalini,tiempototalfin;
		TInicio = System.currentTimeMillis();
		
		  
		System.out.println("Ingrese -c si quiere codificar o -d si desea decodificar");
		String modo=in.nextLine();
		System.out.println("Ingrese el nombre del archivo diccionario");
		a=in.nextLine();
		try {
		TInicio = System.currentTimeMillis();
		String [] dic=leer(a,"\n");
		System.out.println("diccionario:");
		ordenar(dic, 0, dic.length-1);
		String matriz[][]=separar(dic);
		TFin = System.currentTimeMillis();
		tiempo = TFin - TInicio; 
		  System.out.println("Tiempo que tarda en leer el archivo, ordenarlo, separar las frases y formar la matriz" + tiempo);
		
		
		System.out.println("Ingrese el nombre del archivo de entrada");
		a=in.nextLine();
		TInicio = System.currentTimeMillis();
		String [] entrada=leer(a," ");
		System.out.println("Estoy mostrando el archivo entrada");
		String vec_salida[]=new String [entrada.length];
		
		if(modo.compareTo("-c")==0) {
			System.out.println("La codificacion es: ");
			for(int b=0;b<entrada.length;b++) 
				try {
				vec_salida[b]=buscar(matriz, entrada[b], 0, dic.length);
				}catch(java.lang.StackOverflowError e) {
					System.out.println("no se a podido codificar la palabra: "+entrada[b]);
					vec_salida[b]=entrada[b];
				}
		
		}else {
			String matrizinversa[][]=new String [dic.length][2];
			for(int i=0;i<dic.length;i++) {
					matrizinversa[i][0]=matriz[i][1];
					matrizinversa[i][1]=matriz[i][0];
			}
			ordenardeco(matrizinversa, 0, dic.length-1);
			
			System.out.println("La decodificacion es: ");
			for(int b=0;b<entrada.length;b++) {
				
				try {
					vec_salida[b]=buscar(matrizinversa, entrada[b], 0, dic.length);
					}catch(java.lang.StackOverflowError e) {
						System.out.println("no se a podido codificar la palabra: "+entrada[b]);
						vec_salida[b]=entrada[b];
					}
			}
		}
		TFin = System.currentTimeMillis();
		tiempo = TFin - TInicio; 
		  System.out.println("Tiempo que tarda en leer el archivo de entrada,codificar o en caso de decodificar el invertir la matriz"
		  		+ " ordenarla, y decodificar" + tiempo);
			
		System.out.println("Ingrese el nombre del achivo de salida");
		String nombre_sa=in.nextLine();
		grabarArchivo(nombre_sa, vec_salida);
		}catch(FileNotFoundException e) {
			System.out.println("No se ha encontrado el archivo");
		}
	}
	private static void ordenardeco(String array[][], int left , int right) {
		 int l = left, r = right;
		    String aux,aux2;
		
		    do {
		        while (array[r][0].compareTo(array[l][0]) >0  && r > l)
		        	r--;
		        if (l < r) {
		        	aux = array[l][0];
		        	aux2=array[l][1];
		            array[l][0] = array[r][0];
		            array[l][1] = array[r][1];
		            array[r][0] = aux;
		            array[r][1] = aux2;
		            l++;
		        }
		        while (array[l][0].compareTo(array[r][0]) <0  && l < r) {
		            l++;
		        }
		
		        if (l < r) {
		        	aux = array[l][0];
		        	aux2=array[l][1];
		            array[l][0] = array[r][0];
		            array[l][1] = array[r][1];
		            array[r][0] = aux;
		            array[r][1] = aux2;
		            r--;
		        }
		    }
		    while (l < r);
		    if (left < r) {
		    	ordenardeco(array, left, r - 1);
		    }
		    if (l < right) {
		    	ordenardeco(array, l + 1, right);
		    }
	}
	
	public static void grabarArchivo(String nombre,String vec[]) {
		String ruta="src/Parcial2/"+nombre+".txt";
		BufferedWriter bw;
		      try {
			     	bw = new BufferedWriter(new FileWriter(ruta,true));
			     	for(int a=0;a<vec.length;a++) {
			     		bw.write(vec[a]+" ");
			            //bw.newLine();
			     	}
		            bw.close();
			     }catch (IOException e) {
			 		System.out.println("No se puede escribir el archivo");
					}
	}	      
	private static String[][]separar(String []palabra){
		
		String vec2[][]=new String[palabra.length][2];
		for(int a=0;a<palabra.length;a++) {	
		String vec[]= palabra[a].split("\t");
		vec2[a][0]=vec[0];
		vec2[a][1]=vec[1];
		}
		return vec2;
	}
	private static String[] leer(String dir,String modo) throws FileNotFoundException {
		Scanner f = new Scanner(new File("src/Parcial2/"+dir));//utf8
		String aux  =f.useDelimiter("\\A").next();
		String []vec= aux.split(modo);
		System.out.println("El tamanio es :"+vec.length );
		return vec;
		
	}
	private static String buscar(String nuevo[][],String valor,int left,int right) {
		int dere=right;
		int izq=left;
		int mitad=(dere-izq)/2+left;
		if(mitad==0 &&(nuevo[mitad][0].compareTo(valor)!=0)) {
			return valor;
			
		}
			if(nuevo[mitad][0].compareTo(valor)<0)//b es mayor que a
				return buscar(nuevo,valor,mitad,dere);
			else {
				if(nuevo[mitad][0].compareTo(valor)>0)//a es mayor que b
					return buscar(nuevo,valor,izq,mitad);
				else {
					if(nuevo[mitad][0].compareTo(valor)==0)//son iguales
						return  nuevo[mitad][1];
				}
				
			}
		return valor;
	}
	
	private static void mostrar(String []entrada) {
		for(int x=0;x<entrada.length;x++)
			System.out.println(entrada[x]);
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
