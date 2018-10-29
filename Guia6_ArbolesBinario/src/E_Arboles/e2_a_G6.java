package E_Arboles;

public class e2_a_G6 {

	public static void main(String[] args) {
	ArbolBinario A= new ArbolBinario<>();
	
	int a[]= {2,5,3,9,7,1,6,4,8};
		
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
