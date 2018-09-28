package E_pyCListas;

public class pilaEnlazada_Char {

	private nodo_Char tope;

	pilaEnlazada_Char() {
		tope = null;
	}

	void push(char d) {
		nodo_Char aux = new nodo_Char(d, tope);
		tope = aux;
		// tope = new Nodo(d, tope);
	}

	char pop() throws Exception {
		if (tope == null)
			throw new Exception("stack vacio");
		char res = tope.getDato();
		tope = tope.getNext();
		return res;
	}

	boolean esVacia() {
		return tope == null;
	}

	char top() {
		if(tope==null)
			return 0;
		return tope.getDato();
		
		
	}
	void vaciar() {
		tope = null;
	}
}
