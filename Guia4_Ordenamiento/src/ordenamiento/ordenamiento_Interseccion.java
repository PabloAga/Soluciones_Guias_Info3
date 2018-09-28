package ordenamiento;

public class ordenamiento_Interseccion {

	public static void main(String[] args) {
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
		
		
	}
	public static void ordenar_Insercion(int []a) {
		int d,z,aux;
		for(int x=1 ; x<a.length;x++) {
			z=x;
			aux=a[x];
		    	while(z>0 && a[z - 1] > a[z]) {
		    	a[z]=a[z-1];
		    	z--;
		    	}
		    	a[z]=aux;
		}
		

	}

}
