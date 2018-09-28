package ejercicio.pkg1;

import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
         Scanner entrada= new Scanner(System.in);
 		System.out.println("Introduzca el primer factor de la multiplicacion");
 		int a=entrada.nextInt();
 		System.out.println("Introduzca el segundo factor de la multiplicacion");
 		int b=entrada.nextInt();
 		double resultado=suma_Sucesiva(a, b) ;
 		imprimir(a, b, resultado);

 	}
 	
 	
 	public static double suma_Sucesiva(int a, int b) {
 		if(b==1)
 			return a;
 		return a+suma_Sucesiva(a, b-1);
 	}
 	
 	public static void imprimir(int a , int b , double r) {
 		System.out.print(a+"*"+b+"=");
 		for(int i=2;i<=b; i++) {
 			System.out.print(a+"+");
 		}
 		System.out.print(a+"="+r);
 	}


 }