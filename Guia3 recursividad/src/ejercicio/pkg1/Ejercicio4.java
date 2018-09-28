package ejercicio.pkg1;

import java.util.Scanner;

public class Ejercicio4 {
    
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
		System.out.println("Introduzca el dividendo de la division");
		int a=entrada.nextInt();
		System.out.println("Introduzca el divisor de la division");
		int b=entrada.nextInt();
		double resultado=resta_Sucesiva(a, b) ;
		imprimir(a, b, resultado);

	}
	
	
	public static double resta_Sucesiva(int a, int b) {
		if(a-b<=0)
			return 1;
		return resta_Sucesiva(a-b, b)+1;
	}
	


	public static void imprimir(int a , int b , double r) {
		System.out.print(a+"/"+b+"="+a+"-"+b+"=");
		while(a!=(b+b)) {
		a=a-b;
		System.out.print(a+"-"+b+"=");
		}
		System.out.print(r);
	}

}

