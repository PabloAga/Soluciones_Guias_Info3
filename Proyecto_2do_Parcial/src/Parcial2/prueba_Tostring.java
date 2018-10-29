package Parcial2;

public class prueba_Tostring {
	
	//solucionar el problema de que el formato tiene menos o mas letras que las palabras a insertar el ormato

	public static void main(String[] args)  {
		cola_Enlazada_AnyType cola_codif = new cola_Enlazada_AnyType();
		String formato = "{[(MM-MM)]}";
		String palabra = "hola";
		String palabra2="pablo";
		System.out.println(cola_codif.size());
		int signo, letra = 0, i = 0, t;
		boolean l=true, m=false;
		char aux;

		for (int j = 0; j < formato.length(); j++) {
			signo = (int) formato.charAt(j);
			
			if (signo >= 33 && signo <= 47 || signo >= 58 && signo <= 64 || signo >= 91 && signo <= 96
					|| signo >= 123 && signo <= 126) {
				
				if(l) 
					cola_codif.encolar((char) signo);
				else {
					
					aux=(char) signo;
					m=true;
					
				}
				
			} else {
				letra = (int) palabra.charAt(i);
				i++;
				if (signo == 77) { // M
					t = letra - 32;
					cola_codif.encolar((char) t);
					l=false;
				} else {//n
					cola_codif.encolar((char) letra);
					l=false;
				}

			}
		}

		while (!cola_codif.estaVacia()) {
			try {
				System.out.print((char) cola_codif.desencolar());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
