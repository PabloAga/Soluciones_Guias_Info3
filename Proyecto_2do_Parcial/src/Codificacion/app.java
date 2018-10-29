package Codificacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class app {

public static	 String dictionary[] = new String[20000000];//////corregir
public static	 String frase[] = new String[20000000]; ///////

	public static void main(String[] args) throws IOException {
		long t1, t2;
		Scanner entrada= new Scanner(System.in);
        String  ingreso ;
		int s=1;
		
		System.out.println("Parametros soportados:"
				+ "\n-c: Codificar \n-d: Decodificar \n-l: Nombre del libro de codigo(txt)"
				+ "\n-i: Nombre del texto a codificar o decodificar(txt) \n Nombre del archivo "
				+ "\n-o: donde guarda la codificacion o decodificacion(txt)"
				+ "\n-e: Salir");
		while(s!=0) {
			System.out.println("\nIngrese el comando que desee realizar");
			ingreso= entrada.next();
		
			switch (ingreso) {
				case "-c":
			
				break;
				case "-d":
			
				break;
				case "-l":
					System.out.print("Ingrese el nombre del"
							+ " archivo del Diccionario: ");
					String nombre=entrada.next();
					n_Diccionario(nombre);
				break;
				case "-i":
					System.out.print("Ingrese el nombre del"
							+ " adel texto a codificar o decodificar: ");
					nombre=entrada.next();
					n_Frase(nombre);
			
				break;
				case "-o":
					System.out.print("Ingrese el nombre del"
							+ " archivo destino donde se guarda"
							+ " la codificacion o decodificacion: ");
					nombre=entrada.next();
					n_Salida(nombre);
			
				break;
				case "-e":
					s=0;
				break;

				default:
					System.out.println("El comando ingresado es invalido");
			break;
		}
		}
	}
	
	public static void n_Diccionario(String nombre) {
		FileReader lectura = null;
        BufferedReader bufferedReader = null;
        String line;
		 try {
			lectura= new FileReader("src\\Codificacion\\"+nombre+".txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        bufferedReader = new BufferedReader(lectura);
	        
	     //   for (int i = 0; (line = bufferedReader.readLine()) != null; ++i) //ordeno el arreglo de palabras
	      // 	dictionary[i] = line;  solucionar el tamaño del arreglo donde guardo las palabra
	}
	
	public static void n_Frase(String nombre) {
		FileReader lectura = null;
        BufferedReader bufferedReader = null;
        String line;
		 try {
			lectura= new FileReader("src\\Codificacion\\"+nombre+".txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        bufferedReader = new BufferedReader(lectura);
	        
	     //   for (int i = 0; (line = bufferedReader.readLine()) != null; ++i) //ordeno el arreglo de palabras
	      // 	frase[i] = line;  solucionar el tamaño del arreglo donde guardo las palabra
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
	

}
