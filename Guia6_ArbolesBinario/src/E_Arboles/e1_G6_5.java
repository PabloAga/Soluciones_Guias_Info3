package E_Arboles;

public class e1_G6_5 {
	public static void main(String[] args) {
		ArbolBinario A= new ArbolBinario<>();
		
		int a[]= new int[10]; 
		
		for(int i=0; i<a.length; i++) {
			try {
				A.insertar((int) (Math.random()*25)+1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		A.print();
	}

}
