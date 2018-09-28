package ejercicio.pkg1;

import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        System.out.println("Ingrese la base de la potencia a calcular");
        int a=entrada.nextInt();
        System.out.println("ingrese el exponente");
        int b=entrada.nextInt();
        double total=power(a,b);
        imprimir(a, b, total);

    }
     private static double power(int a,int b) {
         if(b==1){
             return a; 
         }
         return power(a,b-1)*a;
        
     }
 	public static void imprimir (int b, int e, double resultado) {
		System.out.print("power("+b+","+e+")="+b+"^"+e+"=");
		int r=0;
		int t=e;
		while(e!=(0)){
			System.out.print(b+"*(");
			if(t!=e){
		for(int i=0;i<=r ;i++) {
		System.out.print(b+"*");
		}
		r+=1;
			}
		e-=1;
		System.out.print(b+"^"+e+")=");
	   }   
		r-=1;
		System.out.print(b+"*(");
		for(int i=0;i<=r ;i++) {
			System.out.print(b+"*");
			}
			r+=1;
			System.out.print(1+")=");
			for(int i=1;i<=r ;i++) {
				System.out.print(b+"*");
			}
		System.out.print(b+"="+resultado);
	}
}
