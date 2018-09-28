/*1. Implemente los métodos de ordenación de inserción, Shellsort y quicksort
usando las implementaciones del teórico. Ejecútelos con los siguientes objetos:
a) enteros.
b) números reales de tipo double.
c) cadena de caracteres.*/
package ejercicioGuia4;

public class ejercicio1_Guia4 {

	public static void main(String[] args) {
		//a)
		int r[]= {9,11,3,7};
		///       0,1,2,3
		System.out.print("Arreglo sin Modificar array[");
		for(int e=0;e<r.length;e++)
		System.out.print(r[e]+",");
		System.out.println("]");
		
		
		ordenar_Insercion(r);
		System.out.print("Arreglo ordenado por INSERCION array[");
		for(int e=0;e<r.length;e++)
		System.out.print(r[e]+",");
		System.out.print("]");
		

	}//recorre el arreglo de la pocicion 1 hasta el tvalor del tamaño del arreglo
	public static void ordenar_Insercion(int a[]) {
		int z,y ,u;
		for (int t=1 ;t<a.length ; t++) {//recorre el arreglo de la pocicion 1 hasta el tvalor del tamaño del arreglo
			y= a[t];
			u=t;
				while(u>0 && a[u-1]> a[u]) {//si el valor anterior es mayor a la posicion actual se cumple el while
				z=a[u];
				a[u]=a[u-1];
		    	a[u-1]=z;
		    	System.out.print("\n");
		    	System.out.print("Arreglo en proceso ordenacion por INSERCION array[");
				for(int e=0;e<a.length;e++)
				System.out.print(a[e]+",");
				System.out.print("]");
				
		    	u--;
				}
					a[u]=y;
					
				}
		
		
		}

}

