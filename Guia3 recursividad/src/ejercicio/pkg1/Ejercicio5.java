package ejercicio.pkg1;

public class Ejercicio5 {

	public static void main(String[] args) {
		int a[]= {3,5,7,9};
		System.out.println("Matriz a[3,5,7,9], tamaño = "+ a.length);
		System.out.print("Matriz b ordenada[");
		mostrar_Matriz(a, a.length);
		System.out.print("]");
		
	}
	
	public static void mostrar_Matriz(int datos[], int tam) {//va disminuyendo el tamaño del vector y imprime en cada pasada

		if(tam!=0) {
			
			System.out.print(datos[tam-1]);
		mostrar_Matriz(datos, tam-1);
	}
	}
}