/*Implemente una calculadora de 4 funciones en notación polaca usando el
concepto de pilas implementada mediante el uso de una lista enlazada*/
package E_pyCListas;

import java.util.Scanner;


public class e2_Guia5 {

	public static void main(String[] args)  {
		pilaEnlazada p= new pilaEnlazada();
		colaEnlazadaChar c=new colaEnlazadaChar();
		Scanner entrada= new  Scanner (System.in);  
		int i,a=0,b=0; 
		boolean g=true, salida=false;
		String ingreso;
		System.out.println("Calculadora Polaca ");
	do {
		System.out.println("Ingrese los elementos a operar ."
				+ " \nPara cerrar la calculasora ingrese 'e' ");

		ingreso=entrada.next();
		for(int y=0 ;y<=ingreso.length()-1;y++) {

		try {
			i=Integer.parseInt(""+ingreso.charAt(y));
			p.push(i);
		} catch (Exception e) {
			try {
				c.encolar(ingreso.charAt(y));
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
		}	
			
			while(!c.estaVacia()) {
			try {
				switch (c.desencolar()) {
				case '+':	
					try {
						a=p.topeYpop();
						b=p.topeYpop();
					} catch (Exception e1) {
						System.out.println("Resultado: "+a);
						break;
					}
							try {
								p.push(a+b);							
							} catch (Exception e1) {
								System.out.println("La pila esta llena");
							}
					break;
				case '-':
					try {
						a=p.topeYpop();
						b=p.topeYpop();
					} catch (Exception e1) {
						System.out.println("Resultado: "+a);
						break;
					}
					try {
						p.push(Math.abs(a-b));
					} catch (Exception e1) {
						System.out.println("La pila esta llena");
					}
					
					break;
				case '/':					
					try {
						a=p.topeYpop();
						b=p.topeYpop();
					} catch (Exception e1) {
						System.out.println("Resultado: "+a);
						break;
					}
				try {
						p.push(a/b);
					} catch (Exception e1) {
						System.out.println("La pila esta llena");
					}
					
					break;
				case '*':
					try {
						a=p.topeYpop();
						b=p.topeYpop();
					} catch (Exception e1) {
						System.out.println("Resultado: "+a);
						break;
					}
				try {
						p.push(a*b);
					} catch (Exception e1) {
						System.out.println("La pila esta llena");
					}
					
					break;
				case 'e':
					salida=true;
					break;
				default:System.out.println("EL valor ingresado es incorrecto");
					break;
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			try {
				System.out.println("------------------------------");
				System.out.println("Resultado: "+p.topeYpop());
				System.out.println("------------------------------\n");
			} catch (Exception e) {
				
			}
			
		}while(!salida);
		System.out.println("Se cerro la calculadora polaca");
		
	}

}


