package E_pilasycolas;

public class pila {
	private int tope;
    private int[] datos;

    public pila() {
        tope = -1;
        datos = new int[10];
    }

    public pila(int c) {
        tope = -1;
        datos = new int[c];
    }

    public void push(int d) throws Exception {
        if (tope + 1 >= datos.length) {
            System.out.println("Se duplico el arreglo");
            datos=duplicarVector(datos, datos.length*2);
        }
        tope++;
        datos[tope] = d;
    }
    public int[] duplicarVector(int []datos, int tamNuevo) {
    	int []original= datos;
    	int cantelementos= Math.min(original.length, tamNuevo);
    	
    	datos= new int[ tamNuevo ];
    	for(int i=0; i < cantelementos; i++) 
    		datos[i]= original[i];
    	return datos;
    	
    	
    }

    public int pop() throws Exception {//topAndTop
        if(tope < 0)
            throw new Exception("Pila vacia");

        return datos[tope--];
    }

    public boolean estaVacia() {
        return tope == -1;
    }
    public int top() {
    	return tope;
    }
    public void vaciarPila()
    {
    	tope=-1;
    }
}
