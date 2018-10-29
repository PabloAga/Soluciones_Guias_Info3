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

public class agregado_28_10 {

	public static void main(String[] args) throws Exception {
		cola_Enlazada_AnyType cola_Acodif = new cola_Enlazada_AnyType<>();
		cola_Enlazada_AnyType cola_salida = new cola_Enlazada_AnyType<>();
		cola_Enlazada_AnyType cola_codif = new cola_Enlazada_AnyType<>();
		String a, p_Buscar, formato;
		Scanner in = new Scanner(System.in);

		long TInicio, TFin, tiempo, tiempototalini, tiempototalfin;
		TInicio = System.currentTimeMillis();

		for (int i = 0; i < args.length; i++)
			System.out.println(i + " " + args[i]);

		System.out.println("Ingrese -c si quiere codificar o -d si desea decodificar");
		String modo = in.nextLine();
		/*
		 * System.out.println("Ingrese el nombre del archivo diccionario"); a =
		 * in.nextLine();
		 */
		try {
			TInicio = System.currentTimeMillis();
			String[] dic = leer(args[0], "\n");
			// System.out.println("diccionario:");
			ordenar(dic, 0, dic.length - 1);
			String matriz[][] = separar(dic);
			TFin = System.currentTimeMillis();
			tiempo = TFin - TInicio;
			System.out.println(
					"Tiempo que tarda en leer el archivo, ordenarlo, separar las frases y formar la matriz" + tiempo);

			/*
			 * System.out.println("Ingrese el nombre del archivo de entrada"); a =
			 * in.nextLine();
			 */
			TInicio = System.currentTimeMillis();
			String[] entrada = leer(args[1], " ");/// entrada es el vector split con las palabras a codificar
			// System.out.println("Estoy mostrando el archivo entrada");
			// String vec_salida[]=new String [entrada.length];

			if (modo.compareTo("-c") == 0) {
				System.out.println("La codificacion es: ");
				for (int b = 0; b < entrada.length; b++) {
					cola_Acodif = separo_Sig(entrada[b]);

					int tam = cola_Acodif.size();
					for (int i = 0; i < tam - 1; i++) { // falta pensar como guardar el formato de signos y mayuscula e
														// implementarlo a la decodificacion
						try {
							p_Buscar = (String) cola_Acodif.desencolar();
							System.out.println("original: " + p_Buscar);
							cola_codif.encolar(buscar(matriz, p_Buscar, 0, dic.length));
							System.out.println("codificado: " + buscar(matriz, p_Buscar, 0, dic.length));
						} catch (java.lang.StackOverflowError e) {
							System.out.println("no se a podido codificar la palabra: " + entrada[b]);
							cola_salida.encolar(entrada[b]);
						}
					}
					formato = (String) cola_Acodif.desencolar();
					cola_salida.encolar(signos(cola_codif, formato));

				}

			} else {
				String matrizinversa[][] = new String[dic.length][2];
				for (int i = 0; i < dic.length; i++) {
					matrizinversa[i][0] = matriz[i][1];
					matrizinversa[i][1] = matriz[i][0];
				}
				ordenardeco(matrizinversa, 0, dic.length - 1);

				System.out.println("La decodificacion es: ");
				for (int b = 0; b < entrada.length; b++) {
					cola_Acodif = separo_Sig(entrada[b]);

					int tam = cola_Acodif.size();
					for (int i = 0; i < tam - 1; i++) { 
						try {
							p_Buscar = (String) cola_Acodif.desencolar();
							System.out.println("original: " + p_Buscar);
							cola_codif.encolar(buscar(matriz, p_Buscar, 0, dic.length));
							System.out.println("codificado: " + buscar(matriz, p_Buscar, 0, dic.length));
						} catch (java.lang.StackOverflowError e) {
							System.out.println("no se a podido codificar la palabra: " + entrada[b]);
							cola_salida.encolar(entrada[b]);
						}
					}
					formato = (String) cola_Acodif.desencolar();
					cola_salida.encolar(signos(cola_codif, formato));
				}
			}
			TFin = System.currentTimeMillis();
			tiempo = TFin - TInicio;
			System.out.println(
					"Tiempo que tarda en leer el archivo de entrada,codificar o en caso de decodificar el invertir la matriz"
							+ " ordenarla, y decodificar" + tiempo);

			/*
			 * System.out.println("Ingrese el nombre del achivo de salida"); String
			 * nombre_sa = in.nextLine();
			 */
			grabarArchivo(args[2], cola_salida);
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el archivo");
		}
	}

	private static void ordenardeco(String array[][], int left, int right) {
		int l = left, r = right;
		String aux, aux2;

		do {
			while (array[r][0].compareTo(array[l][0]) > 0 && r > l)
				r--;
			if (l < r) {
				aux = array[l][0];
				aux2 = array[l][1];
				array[l][0] = array[r][0];
				array[l][1] = array[r][1];
				array[r][0] = aux;
				array[r][1] = aux2;
				l++;
			}
			while (array[l][0].compareTo(array[r][0]) < 0 && l < r) {
				l++;
			}

			if (l < r) {
				aux = array[l][0];
				aux2 = array[l][1];
				array[l][0] = array[r][0];
				array[l][1] = array[r][1];
				array[r][0] = aux;
				array[r][1] = aux2;
				r--;
			}
		} while (l < r);
		if (left < r) {
			ordenardeco(array, left, r - 1);
		}
		if (l < right) {
			ordenardeco(array, l + 1, right);
		}
	}

	public static void grabarArchivo(String nombre, cola_Enlazada_AnyType c_final) throws Exception {
		String ruta = "src/Parcial2/" + nombre + ".txt";
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(ruta, true));
			System.out.println("motramos la cola en la funcion");
			while (!c_final.estaVacia()) {
				String a = (String) c_final.desencolar();
				System.out.println(a);
				bw.write(a + " ");
				// bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("No se puede escribir el archivo");
		}
	}

	private static String[][] separar(String[] palabra) {

		String vec2[][] = new String[palabra.length][2];
		for (int a = 0; a < palabra.length; a++) {
			String vec[] = palabra[a].split("\t");
			vec2[a][0] = vec[0];
			vec2[a][1] = vec[1];
		}
		return vec2;
	}

	private static String[] leer(String dir, String modo) throws FileNotFoundException {
		Scanner f = new Scanner(new File("src/Parcial2/" + dir));// utf8
		String aux = f.useDelimiter("\\A").next();
		String[] vec = aux.split(modo);
		System.out.println("El tamanio es :" + vec.length);
		return vec;

	}

	private static String buscar(String nuevo[][], String valor, int left, int right) {
		int dere = right;
		int izq = left;
		int mitad = (dere - izq) / 2 + left;
		if (mitad == 0 && (nuevo[mitad][0].compareTo(valor) != 0)) {
			return valor;

		}
		if (nuevo[mitad][0].compareTo(valor) < 0)// b es mayor que a
			return buscar(nuevo, valor, mitad, dere);
		else {
			if (nuevo[mitad][0].compareTo(valor) > 0)// a es mayor que b
				return buscar(nuevo, valor, izq, mitad);
			else {
				if (nuevo[mitad][0].compareTo(valor) == 0)// son iguales
					return nuevo[mitad][1];
			}

		}
		return valor;
	}

	private static void mostrar(String[] entrada) {
		for (int x = 0; x < entrada.length; x++)
			System.out.println(entrada[x]);
	}

	private static void ordenar(String array[], int left, int right) {
		int l = left, r = right;
		String aux;

		do {
			while (array[r].compareTo(array[l]) > 0 && r > l)
				r--;
			if (l < r) {
				aux = array[l];
				array[l] = array[r];
				array[r] = aux;
				l++;
			}
			while (array[l].compareTo(array[r]) < 0 && l < r) {
				l++;
			}

			if (l < r) {
				aux = array[l];
				array[l] = array[r];
				array[r] = aux;
				r--;
			}
		} while (l < r);
		if (left < r) {
			ordenar(array, left, r - 1);
		}
		if (l < right) {
			ordenar(array, l + 1, right);
		}

	}

	public static cola_Enlazada_AnyType separo_Sig(String sCadena) throws Exception {
		cola_Enlazada_AnyType cola_Signos = new cola_Enlazada_AnyType();
		cola_Enlazada_AnyType cola_Palabra = new cola_Enlazada_AnyType();
		cola_Enlazada_AnyType cola_Letra = new cola_Enlazada_AnyType();
		String str_signos, str_palabra1;
		int b = 0, f = 0;
		boolean p = true, s = true, h = true;

		for (int i = 0; i < sCadena.length(); i++) {
			b = 0;
			p = true;
			int letra = (int) sCadena.charAt(i);
			if (letra >= 33 && letra <= 47 || letra >= 58 && letra <= 64 || letra >= 91 && letra <= 96
					|| letra >= 123 && letra <= 126) {// detecta caracteres
				cola_Signos.encolar((char) letra);
				if (!h)// bandera h para avisar que paso por un signo
					s = false;// bandera s para avisar que paso por un signo y si la proxima es una letra que
								// encole la palabra
								// anterior y despues guade en la palabra en el arreglo
			} else {
				while (b < 2) {
					if (s) {
						if (letra >= 65 && letra <= 90) {
							letra = letra + 32;
							cola_Signos.encolar('M');
							p = false;
						}
						if (letra >= 97 && letra <= 122) {
							cola_Letra.encolar((char) letra);
							s = true;
							h = false;
							b += 2;// para salir del while
							if (p)
								cola_Signos.encolar('m');
						}
					} else {
						char palabra_1[] = new char[cola_Letra.size()];
						while (cola_Letra.estaVacia() == false) {
							palabra_1[f] = (char) cola_Letra.desencolar();
							f++;
						}
						f = 0;
						str_palabra1 = String.valueOf(palabra_1);
						System.out.println("palabra apilada en pila0: " + str_palabra1);
						cola_Palabra.encolar(str_palabra1);
						h = true;
						s = true;
						b++;// pasa una vez mas por el while para guardar la palabra en el arreglo
					}
				}
			}
		}
		char palabra_1[] = new char[cola_Letra.size()];// como encola la palabra anterior cada vez que ingresa una	palabra nueva , se perdia
		while (cola_Letra.estaVacia() == false) {// la ultima palabra porque no encolaba , de esta forma se soluciono
			palabra_1[f] = (char) cola_Letra.desencolar();
			f++;
		}
		f = 0;
		str_palabra1 = String.valueOf(palabra_1);
		System.out.println("palabra apilada en pila: " + str_palabra1);
		cola_Palabra.encolar(str_palabra1);
		char signos[] = new char[cola_Signos.size()];
		while (cola_Signos.estaVacia() == false) {
			signos[f] = (char) cola_Signos.desencolar();
			f++;
		}
		str_signos = String.valueOf(signos);
		System.out.println("palabra apilada en pila2: " + str_signos);
		cola_Palabra.encolar(str_signos);
		return cola_Palabra;
	}

	public static String signos(cola_Enlazada_AnyType c_Palabras, String formato) throws Exception {
		cola_Enlazada_AnyType cola_codif = new cola_Enlazada_AnyType();
		String palabra;
		String p_c_Sig;
		int signo, letra = 0, t, p = 0, r = 0, tam_Palabra = 0;
		boolean q = true, h = true;
		System.out.println("Formato: " + formato);
		palabra = (String) c_Palabras.desencolar();
		tam_Palabra = palabra.length();
		System.out.println("palabra:" + palabra);
		for (int j = 0; j < formato.length(); j++) {
			signo = (int) formato.charAt(j);
			if (signo >= 33 && signo <= 47 || signo >= 58 && signo <= 64 || signo >= 91 && signo <= 96
					|| signo >= 123 && signo <= 126) {
				if (q || !h) {
					System.out.println("simbolo--" + (char) signo);
					cola_codif.encolar((char) signo);
				} else {
					while (palabra.length() != r) {
						System.out.println("while--" + palabra.charAt(r));
						cola_codif.encolar(palabra.charAt(r));
						r++;
					}
					cola_codif.encolar((char) signo);
					System.out.println("simbolo--" + (char) signo);
					if (c_Palabras.size() != 0)
						palabra = (String) c_Palabras.desencolar();
					tam_Palabra = palabra.length();
					h = false;
					r = 0;
				}
			} else {
				if (tam_Palabra != r) {
					letra = (int) palabra.charAt(r);
					if (signo == 77) { // M
						t = letra - 32;
						cola_codif.encolar((char) t);
						r++;
						q = false;
					} else {// n
						cola_codif.encolar((char) letra);
						r++;
						q=false;
					}
					h = true;
				}
			}
		}
		if(formato.charAt(0)=='m'||formato.charAt(0)=='M') {
			while (palabra.length() != r) {
				System.out.println("while--" + palabra.charAt(r));
				cola_codif.encolar(palabra.charAt(r));
				r++;
			}
		}
		r = 0;
		char a_final[] = new char[cola_codif.size()];
		while (!cola_codif.estaVacia()) {
			try {
				a_final[r] = (char) cola_codif.desencolar();
				r++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		p_c_Sig = String.valueOf(a_final);
		System.out.println("Salida de fauncion signo: --" + p_c_Sig);
		return p_c_Sig;
	}
}
