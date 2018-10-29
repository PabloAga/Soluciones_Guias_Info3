package E_Arboles;

public class e2_c_G6 {
	
	public static void main(String[] args) {
	ArbolBinario A= new ArbolBinario<>();
	
	int a[]= {5,6,12,10,1,9,13,4,8,2,7,3,11};
		
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