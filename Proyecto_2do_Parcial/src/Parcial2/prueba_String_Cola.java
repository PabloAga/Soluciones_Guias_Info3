package Parcial2;

public class prueba_String_Cola {

	public static void main(String[] args) throws Exception {
		String sCadena = "{ES-p!asado}";
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
						cola_Palabra.encolar(str_palabra1);
						h = true;
						s = true;
						b++;// pasa una vez mas por el while para guardar la palabra en el arreglo
					}
				}

			}
		}
		char palabra_1[] = new char[cola_Letra.size()];
		while (cola_Letra.estaVacia() == false) {
			palabra_1[f] = (char) cola_Letra.desencolar();
			f++;
		}
		f = 0;
		str_palabra1 = String.valueOf(palabra_1);
		cola_Palabra.encolar(str_palabra1);

		char signos[] = new char[cola_Signos.size()];
		while (cola_Signos.estaVacia() == false) {
			signos[f] = (char) cola_Signos.desencolar();
			f++;
		}

		str_signos = String.valueOf(signos);
		cola_Palabra.encolar(str_signos);

		int tam = cola_Palabra.size();
		for (int i = 0; i < tam - 1; i++) {
			System.out.println(cola_Palabra.desencolar());
		}
		System.out.println(str_signos);
		/*
		 * str_signos=String.valueOf(signos); String sign_Split[]
		 * =str_signos.split("1");
		 * 
		 * for(int y=0; y<sign_Split.length;y++) { System.out.println(sign_Split[y]); }
		 * 
		 * while(cola_Palabra.estaVacia()==false) {
		 * System.out.println(cola_Palabra.desencolar()); }
		 */

		// Una vez encontradas la palabras codificadas se deberian imprimir en el txt de
		// la siguiente forma
		// tomamos que la cola cola_Palabra es la cola con palabras codificadas.
		// str_signos es el String con los parametras para imprimir los signos.y tambien
		// la cola_Signos
		/*
		 * while(cola_Signos.estaVacia()==false) { char signo =(char)
		 * cola_Signos.desencolar(); if(signo=='1') {
		 * System.out.print(cola_Palabra.desencolar()); } else System.out.print(signo);
		 * }
		 */

	}
}