package ejercicioGuia4;

public class metodos_OrdenamientosString {
	public static void ordenar_Insercion(String []a) {
		int z;
		String aux,Y;
		for(int x=1 ; x<a.length;x++) {
			Y=a[x];
			z=x;
		    	for(;z>0 && a[z].compareTo(a[z + 1])>0;z--) {
		    		aux=a[z];
		    		a[z]=a[z-1];
		    		a[z-1]=aux;
		    		
		    	}
		    	a[z]=Y;
		}

	}
	
		public static void ordenamiento_Shell(String[] v, int n) {
			int gap, i, j;
			String temp;
			for (gap = n / 2; gap > 0; gap /= 2)
				for (i = gap; i < n; i++)
					for (j = i - gap; j >= 0 && v[j].compareTo(v[j + gap]) >0 ; j -= gap) {
						temp = v[j];
						v[j] = v[j + gap];
						v[j + gap] = temp;
					}
		}
	public static void ordenamiento_QuickSort(String array[], int left , int right) {
        int l = left, r = right;
        String aux;

        do {
            while (array[r].compareTo(array[l]) >0  && r > l)
            	r--;
            if (l < r) {
            	aux = array[l];
                array[l] = array[r];
                array[r] = aux;
                l++;
            }
            while (array[l].compareTo(array[r]) <0  && l < r) {
                l++;
            }

            if (l < r) {
            	aux = array[l];
                array[l] = array[r];
                array[r] = aux;
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
