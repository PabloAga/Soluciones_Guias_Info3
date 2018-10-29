package E_Arboles;

public class e2_d_G6 {

	public static void main(String[] args) {
	ArbolBinario A= new ArbolBinario<>();
	
	int a[]= {6,5,10,9,1,13,12,2,8,3,11,7,4};
		
	for(int i=0; i<a.length; i++) {
		try {
			A.insertar(a[i]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	A.preOrder();
		
	}
}

