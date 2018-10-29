package E_Arboles;

public class e2_b_G6 {

	public static void main(String[] args) {
	ArbolBinario A= new ArbolBinario<>();
	
	int a[]= {9,3,7,5,1,2,6,8,4};
		
	for(int i=0; i<a.length; i++) {
		try {
			A.insertar(a[i]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	A.inOrder();
		
	}
}
