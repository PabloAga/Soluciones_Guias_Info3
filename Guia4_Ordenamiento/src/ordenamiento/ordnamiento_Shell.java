package ordenamiento;


public class ordnamiento_Shell {

	public static void main(String[] args) {
		int r[]= {9,11,3,7};
		///       0,1,2,3
		System.out.print("Arreglo sin Modificar array[");
		for(int e=0;e<r.length;e++)
		System.out.print(r[e]+",");
		System.out.println("]");
		
		
		ordenamiento_Shell(r, r.length);;
		System.out.print("Arreglo ordenado por SHELL array[");
		for(int e=0;e<r.length;e++)
		System.out.print(r[e]+",");
		System.out.print("]");
		
		
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

}
