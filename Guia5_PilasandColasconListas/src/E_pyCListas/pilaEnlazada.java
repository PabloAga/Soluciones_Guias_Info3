package E_pyCListas;

public class pilaEnlazada {

	private Nodo tope;//el primero apunta a null , los siguientes apunta a la direccion de memoria de los siguientes nodos

	pilaEnlazada() {
		tope = null;
	}

	void push(int d) {
		Nodo aux = new Nodo(d, tope);//primer elemento ingresado le pasa el dato y la direccion del nodo null
		tope = aux;//tope pasa a ser un nodo que en su interior tiene la direccion del nodo que apunta a null
		// tope = new Nodo(d, tope);
	}

	void pop() throws Exception {
		if (esVacia())//pregunta si la pila esta vacia
			throw new Exception("stack vacio");
		tope = tope.getNext();
	}
	
	int topeYpop() throws Exception {
		if (esVacia())//pregunta si la pila esta vacia
			throw new Exception("stack vacio");
			int res = tope.getDato();//guarda el valor de dato del nodo tope
			tope = tope.getNext();
			return res;
		}
	
	int top() {
		if(esVacia())
			return 0;
		return tope.getDato();
		
		
	}	
	boolean esVacia() {
		return tope == null;
	}


	void vaciar() {
		tope = null;
	}
}
