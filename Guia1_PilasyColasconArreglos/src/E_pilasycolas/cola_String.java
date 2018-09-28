package E_pilasycolas;

public class cola_String {

		private int entrada;
	    private int salida;

	    private String[] datos;
	    private int cantidad;

	    public cola_String() {
	        entrada = 0;
	        salida = 0;
	        datos = new String[10];
	        cantidad = 0;
	    }

	    public cola_String(int t) {
	        entrada = 0;
	        salida = 0;
	        datos = new String[t];
	        cantidad = 0;
	    }

	    public void encolar(String d) throws Exception {
	        if (estaLlena()) {
	       	 duplicarCola();
	        }
	        cantidad++;
	        datos[entrada] = d;
	        entrada = incrementar(entrada);
	    }

	    
	    public String desencolar() throws Exception {
	        if (estaVacia())
	            throw new Exception("Cola vacia");

	        cantidad--;
	        String d = datos[salida];
	        salida = incrementar(salida);
	        return d;
	    }

	    public String salida() throws Exception {
	        if (estaVacia())
	            throw new Exception("Cola vacia");

	        String d = datos[salida];
	        return d;
	    }
	    public boolean estaVacia() {
	        return entrada == salida && cantidad == 0;
	    }

	    public boolean estaLlena() {

	        return entrada == salida && cantidad > 0;
	    }
	    public int cantElemento() {
	    	return cantidad;
	    }

	    public String mostrarSalida() {
	        return datos[incrementar(salida)];
	    }

	    public void eliminar_Elementos() {
	        entrada=0;
	        salida=0;
	        cantidad=0;
	    }
	    private void duplicarCola() {
	   	 String[] new_array;
	   	 new_array= new String[datos.length*2];
	   	 
	   	 for(int i=0; i<cantidad; i++ , salida=incrementar(salida))
	   		 new_array[i]=datos[salida];
	   	 datos=new_array;
	   	salida=0;
	   	 entrada=-1;
	   	 
	    }
	    public void mostrar_Arreglo() {
	        int j = 0, k = 1;
	        System.out.println();

	        for (int i = salida; j < cantidad; i = incrementar(i)) {
	            System.out.printf("(%d) %s\n", k, datos[i]);
	            j++;
	            k++;
	        }
	        System.out.println();
	    }
	    private int incrementar(int x) {
	        return (x + 1) % datos.length;
	    }
	}
