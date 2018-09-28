/*Implemente un programa que ingresada una función matemática, verifique si la
cantidad de (,[,{ que abren están balanceados con los que cierran*/

package E_pilasycolas;

import java.util.Scanner;

public class e4_Guia1 {

	public static void main(String[] args)  {
		pila_char p= new pila_char();
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
						System.out.println("La funcion NO esta balanceada");
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
					System.out.println("La funcion NO esta balanceada");
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
					System.out.println("La funcion NO esta balanceada");
					  i=ingreso.length();
					  b=false;
					
					break;

				default:
					break;
				}
				

				}
			}
			
		if(p.top()=='}'||p.top()=='}'||p.top()==']'||p.top()==-1) {
			if(b)
			System.out.println("La funcion ESTA balanceada");
			}
			else
			System.out.println("La funcion NO esta balanceada");
		
	}

}
