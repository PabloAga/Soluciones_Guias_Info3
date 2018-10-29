package Parcial2;


public class pila_Enlazada_AnyType<AnyType extends Comparable<AnyType>> {

	private nodo_Cola_AnyType tope;
	private int size=0;
	pila_Enlazada_AnyType() {
		tope = null;
	}

	void push(AnyType d) {
		 nodo_Cola_AnyType aux = new nodo_Cola_AnyType(d, tope);
		 size++;
		tope = aux;
		// tope = new Nodo(d, tope);
	}

	AnyType pop() throws Exception {
		if (tope == null)
			throw new Exception("stack vacio");
		AnyType res =(AnyType) tope.getDato();
		tope = tope.getNext();
		size--;
		return res;
	}

	boolean esVacia() {
		return tope == null;
	}

	int size() {
		return size;
	}
	void vaciar() {
		tope = null;
	}
}
