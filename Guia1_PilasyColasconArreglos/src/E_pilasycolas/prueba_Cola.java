package E_pilasycolas;

public class prueba_Cola {

	public static void main(String[] args) {
		cola_pablo c= new cola_pablo(3);
		
		try {
			c.encolar("a");
			c.encolar("b");
			c.encolar("c");
			c.encolar("d");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int m= c.tama�o();
		System.out.println("tama�o: "+ m);
		String s;
		try {
			s = c.desencolar();
			System.out.println("desencolo"+s);
		s=c.desencolar();
		System.out.println("desencolo"+s);
		s=c.desencolar();
		System.out.println("desencolo"+s);
		s=c.desencolar();
		System.out.println("desencolo"+s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 m= c.tama�o();
			System.out.println("tama�o: "+ m);

				
		
	}

}
