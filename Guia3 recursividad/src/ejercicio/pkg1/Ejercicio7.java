package ejercicio.pkg1;

public class Ejercicio7 {

	/*	public static void main(String[] args) {
	Scanner entrada=new Scanner (System.in);
	System.out.print("Introduzca un numero decimal: ");
	int a=entrada.nextInt();
	a=Math.abs(a);
	separo(a);
	

}*/
public static  void separo(int n) {
	if (n<10) {
		System.out.print(n+" ");
		return ;
	}
    separo(n/10);
	System.out.print(n%10+" ");
	
}

}
