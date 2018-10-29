package Parcial2;

public class prueba_Funcion_signo {
	public static void main(String[] args) throws Exception {
	cola_Enlazada_AnyType cola_codif = new cola_Enlazada_AnyType();
	cola_Enlazada_AnyType c_Palabras=new cola_Enlazada_AnyType();
	String palabra;
	String p_c_Sig;
	int signo, letra = 0, t, p = 0, r = 0;
	boolean q = true, h = true;
	String formato = "((m-M)";

	c_Palabras.encolar("el");
	c_Palabras.encolar("futuro");
	//c_Palabras.encolar("casagrande");
	System.out.println("Formato: " + formato);
	palabra = (String) c_Palabras.desencolar();
	System.out.println("tam_Palabra arriba for: "+palabra.length());
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
				h = false;
				if(c_Palabras.size()!=0)
				palabra=(String) c_Palabras.desencolar();
				System.out.println("tam_Palabra desp del w: "+palabra.length()+"r  "+r);
				cola_codif.encolar((char) signo);
				System.out.println("simbolo--" + (char) signo);
				r = 0;
			}
		//	q=true;		
			//}
			
		} else {
		
			
			if (palabra.length() != r) {
				letra = (int) palabra.charAt(r);
				if (signo == 77) { // M
					
					t = letra - 32;
					System.out.println("letra May: "+(char) t );
					cola_codif.encolar((char) t);
					r++;
					q = false;
				} else {// n
					System.out.println("letra Mmin: "+(char) letra );
					cola_codif.encolar((char) letra);
					r++;
					q=false;
				}
				h = true;
			}
		}
	}
	System.out.println("FUERAtam_Palabra desp del w: "+palabra.length()+"r  "+r);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	p_c_Sig = String.valueOf(a_final);
	System.out.println("Salida de fauncion signo: "+p_c_Sig);
}
}
