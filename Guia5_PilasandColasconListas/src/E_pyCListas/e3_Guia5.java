/* Implemente un programa que ingresada una funci�n matem�tica, verifique si la
cantidad de (,[,{ que abren est�n balanceados con los que cierran.*/
package E_pyCListas;

import java.util.Scanner;


public class e3_Guia5 {
	public static void main(String[] args)  {

	pilaEnlazada_Char p= new pilaEnlazada_Char();
	Scanner entrada= new  Scanner (System.in);  
	int i;
	char caracter='0';
	boolean b=true, salida=false;
	String ingreso;
	System.out.println("Escriba la funcion a comprobar");
	ingreso=entrada.nextLine();
	for( i=0; i<=ingreso.length()-1;i++) {
		if(ingreso.charAt(i)!=')'&&ingreso.charAt(i)!='}'&&ingreso.charAt(i)!=']') {
		try {
			if(ingreso.charAt(i)=='('||ingreso.charAt(i)=='{'||ingreso.charAt(i)=='[') 
			p.push(ingreso.charAt(i));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else {
			switch (ingreso.charAt(i)) {
			case ')':
				try {
				caracter=p.pop();
			} catch (Exception e) {
				b=false;
			}
				if(caracter=='(') {
					break;
				}
					System.out.println("1La funcion NO esta balanceada");
				  i=ingreso.length();
				  b=false;
				
				break;
			case '}':
				try {
					caracter=p.pop();
				} catch (Exception e) {
					b=false;
				}
				if(caracter=='{')  {
					break;
				}
				System.out.println("2La funcion NO esta balanceada");
				i=ingreso.length();
				b=false;
				
				break;
			case ']':
				try {
					caracter=p.pop();
				} catch (Exception e) {
					b=false;
				}
				if(caracter=='[') {
					break;
				}
				System.out.println("3La funcion NO esta balanceada");
				  i=ingreso.length();
				  b=false;
				
				break;

			default:
				break;
			}
			

			}
		}
		
	if(p.top()=='}'||p.top()==')'||p.top()==']'||p.top()==0) {
		if(b)
		System.out.println("La funcion ESTA balanceada");
		}
		else
		System.out.println("4La funcion NO esta balanceada");
	
}

}
