package ejercicio.pkg1;

import java.util.Scanner;

public class Ejercicio6 {
	public static void main(String[] args) {
	Scanner entrada=new Scanner (System.in);
	System.out.print("Introduzca el numero para contar  número de unos en la representación " + 
			"binaria: ");
	int a=entrada.nextInt();
	System.out.println("La cantidad de numeros de unos que tiene la tranformacion d->b = "+binario(a));

}
public static int binario(int n) {
		if(n<2) 
			return n;//devuelve 1

		return binario(n/2)+ (n % 2);		
}
}