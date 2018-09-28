package E_pyCListas;

import java.util.Scanner;

public class e4_Guia5 {

	public static void main(String[] args)  {
		Scanner entrada= new Scanner(System.in);
		String txt,txtM;
		int j=0;
		char pila=0 ,cola=0;
		boolean salida=false;
		pilaEnlazada_Char p= new pilaEnlazada_Char();
		colaEnlazadaChar c= new colaEnlazadaChar();
		System.out.println("Ingrese la frace a comprobar");
		txt=entrada.nextLine();
		txtM= txt.replaceAll("\\s", "");
		for(int i=0; i<=txtM.length()-1;i++) {
			p.push(txtM.charAt(i));
			c.encolar(txtM.charAt(i));	
				
		}
		while(!p.esVacia()) {
			try {
				pila=p.pop();
				cola=c.desencolar();	
				if(pila!=cola) {
					salida=true;
			}
			}
				catch (Exception e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
		
	}
		if(salida!=true)
		System.out.println("El texto es palindromo");
		else {
		System.out.println("El texto no es palindromo");
		}
		
		
		
		
		
		
		
		
		
	}
}
