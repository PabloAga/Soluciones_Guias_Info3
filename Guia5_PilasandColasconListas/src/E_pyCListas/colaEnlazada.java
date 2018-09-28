package E_pyCListas;

public class colaEnlazada {
	private Nodo entrada;
	private Nodo salida;

	public colaEnlazada() {
		entrada = null;//back
		salida = null;//front
	}

	void encolar(int d) {
		Nodo aux = new Nodo(d);
		if (entrada != null)
			entrada.setNext(aux);//caso que el nodo entrada NO apunte a null
		entrada = aux;//primer nodo que apunta a null
		if (salida == null)//si se ingreso el primer dato y se creo el nodo salida apunta al mismo
			salida = entrada;//si no queda como esta , no se modifica salida
	}

	int desencolar() throws Exception {
		if (esVacia())
			throw new Exception("Cola vacia");

		int res = salida.getDato();
		salida = salida.getNext();//asigna a salida la direccion de memoria del siguiente nodo
		if (esVacia())//si se desapila todos los nodos asigna a entrada null
			entrada = null;
		return res;
	}
	
	int primero_entrada() throws Exception {
		if(esVacia())
	throw new Exception("La cola esta vacia");
	return  salida.getDato();	
	}

	boolean esVacia() {
		return salida == null;
	}

	void vaciar() {
		entrada = null;
		salida = null;
	}
}