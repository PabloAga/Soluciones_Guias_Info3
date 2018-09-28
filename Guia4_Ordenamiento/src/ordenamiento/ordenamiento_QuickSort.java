package ordenamiento;

public class ordenamiento_QuickSort {

	public static void main(String[] args) {
		int r[]= {9,11,3,7};
		///       0,1,2,3
		System.out.print("Arreglo sin Modificar array[");
		for(int e=0;e<r.length;e++)
		System.out.print(r[e]+",");
		System.out.println("]");
		
		
		ordenamiento_QuickSort(r, 0, r.length-1);
		System.out.print("Arreglo ordenado por QUICKSORT array[");
		for(int e=0;e<r.length;e++)
		System.out.print(r[e]+",");
		System.out.print("]");
		

	}
	public static void ordenamiento_QuickSort(int array[], int left , int right) {
        int l = left, r = right;
        int temp;

        do {
            while (array[r] > array[l] && r > l)//PREGUNTA de derecha a izquierda si el elemento es mayor al que estoy preguntando
            	r--;
            if (l < r) {//si el elemento de la derecha es mayor al de la izquierda se intercambia
                temp = array[l];
                array[l] = array[r];
                array[r] = temp;
                l++;
            }
            while (array[l] < array[r] && l < r) {//PREGUNTA de izquierda a derecha  si el elemento es mayor al que estoy preguntando
                l++;
            }

            if (l < r) {//si el elemento de la izquierda es mayor al de la derecha se intercambia
                temp = array[l];
                array[l] = array[r];
                array[r] = temp;
                r--;
            }
        }while (l < r);
        if (left < r) {
        	ordenamiento_QuickSort(array, left, r - 1);
        }
        if (l < right) {
        	ordenamiento_QuickSort(array, l + 1, right);
        }
	}

}
