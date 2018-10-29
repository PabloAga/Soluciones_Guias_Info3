package Parcial2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		String a;
		Scanner in= new Scanner(System.in);
		//System.out.println("Ingrese el nombre del archivo diccionario");
		a="dic.dic";//in.nextLine();
		String[] dic=leer(a,"\n");
		System.out.println("Estoy mostrando el archivo diccion");
		ordenar(dic, 0, dic.length-1);
		mostrar(dic);
		String matriz[][]=separar(dic);
		System.out.println("Ingrese el nombre del archivo de entrada");
		a=in.nextLine();
		String [] entrada=leer(a," ");
		System.out.println("Estoy mostrando el archivo entrada");
		mostrar(entrada);
		
		System.out.println("La codificacion es: ");
		for(int b=0;b<entrada.length;b++) 
			System.out.println(buscar(matriz, entrada[b], 0, dic.length-1));
		
		
		
		
			
			
	}
	public static void n_Salida(String nombre) {
		FileWriter flwriter = null;
		try {
			//crea el flujo para escribir en el archivo
			flwriter = new FileWriter("src\\Codificacion\\"+nombre+".txt");
			//crea un buffer o flujo intermedio antes de escribir directamente en el archivo
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			//Guarda datos dentro del txt
				//bfwriter.write()
			
			//cierra el buffer intermedio
			bfwriter.close();
			System.out.println("Archivo creado satisfactoriamente..");
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flwriter != null) {
				try {//cierra el flujo principal
					flwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	private static String[][]separar(String []palabra){
		
		String vec2[][]=new String[palabra.length][2];
		int b=0;
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
			return "El valor:"+valor+"no existe";
			
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
		return "El valor:"+valor+"no existe";
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
