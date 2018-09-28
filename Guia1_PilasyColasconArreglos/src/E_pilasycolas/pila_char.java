package E_pilasycolas;

public class pila_char {
	private int tope;
    private char[] datos;

    public pila_char() {
        tope = -1;
        datos = new char[10];
    }

    public  pila_char(int c) {
        tope = -1;
        datos = new char[c];
    }

    public void push(char d) throws Exception {
        if (tope + 1 >= datos.length)
            throw new Exception("Pila Llena");

        tope++;
        datos[tope] = d;
    }

    public char pop() throws Exception {
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

}
