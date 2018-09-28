package ejercicioGuia4;

public class E1_GUIA4 {

	public static void main(String[] args) {
		int r[]= {9,11,3,7},q[]= {9,11,3,7},t[]= {9,11,3,7};
		///       0,1,2,3
		System.out.print("Arreglo sin Modificar array[");
		for(int e=0;e<r.length;e++)
		System.out.print(r[e]+",");
		System.out.println("]");
		
		
		ordenar_Insercion(r);
		System.out.print("Arreglo ordenado por INSERCION array[");
		for(int e=0;e<r.length;e++)
		System.out.print(r[e]+",");
		System.out.print("]\n");
		
		
		System.out.print("\nArreglo sin Modificar array[");
		for(int e=0;e<q.length;e++)
		System.out.print(q[e]+",");
		System.out.println("]");
		
		
		ordenamiento_Shell(q, q.length);
		System.out.print("Arreglo ordenado por SHELL array[");
		for(int e=0;e<q.length;e++)
		System.out.print(q[e]+",");
		System.out.print("]\n");
		
		
		System.out.print("\nArreglo sin Modificar array[");
		for(int e=0;e<t.length;e++)
		System.out.print(t[e]+",");
		System.out.println("]");
		
		
		ordenamiento_QuickSort(t, 0,t.length-1);
		System.out.print("Arreglo ordenado por QUICKSORT array[");
		for(int e=0;e<t.length;e++)
		System.out.print(t[e]+",");
		System.out.print("]");
		
		
	}
	public static void ordenar_Insercion(int []a) {
		int aux,z,Y;
		for(int x=1 ; x<a.length;x++) {
			Y=a[x];
			z=x;
		    	for(;z>0 && a[z - 1] > Y;z--) {
		    		//aux=a[z];
		    		a[z]=a[z-1];
		    		//a[z-1]=aux;
		    		
		    	}
		    	a[z]=Y;
		}

	}
	
	public static void ordenamiento_Shell(int array[], int tamano) {
		int temp,gap ,i ,j;
		for ( gap = tamano/ 2; gap > 0; gap /= 2) {//DIVIDE EL ARREGLO EN 2 PARTES IGUALES
            for ( i = gap; i <tamano; i++) {//RECORRE EL ARREGLO DE LEFT A RIGHT
                for ( j = i - gap; j >= 0 && array[j] > array[j + gap]; j -= gap) {//COMPAA LOS VALORES DEL EXTREMOS DEL GAP 
                    temp = array[j];
                    array[j] = array[j + gap];
                    array[j + gap] = temp;
                }
            }
        }

	}

	
	public static void ordenamiento_QuickSort(int array[], int left , int right) {
        int l = left, r = right;
        int temp;

        do {
            while (array[r] > array[l] && r > l)
            	r--;
            if (l < r) {
                temp = array[l];
                array[l] = array[r];
                array[r] = temp;
                l++;
            }
            while (array[l] < array[r] && l < r) {
                l++;
            }

            if (l < r) {
                temp = array[l];
                array[l] = array[r];
                array[r] = temp;
                r--;
            }
        }
        while (l < r);
        if (left < r) {
        	ordenamiento_QuickSort(array, left, r - 1);
        }
        if (l < right) {
        	ordenamiento_QuickSort(array, l + 1, right);
        }
	}

}



