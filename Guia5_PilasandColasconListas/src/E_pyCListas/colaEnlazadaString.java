package E_pyCListas;

public class colaEnlazadaString {

	private nodo_String entrada;
	private nodo_String salida;

	public colaEnlazadaString() {
		entrada = null;
		salida = null;
	}

	void encolar(String d) {
		 nodo_String aux = new  nodo_String(d);
		if (entrada != null)
			entrada.setNext(aux);
		entrada = aux;
		if (salida == null)
			salida = entrada;
	}

	String desencolar() throws Exception {
		if (salida == null)
			throw new Exception("Cola vacia");
		String res = salida.getDato();
		salida = salida.getNext();
		if (salida == null)
			entrada = null;
		return res;
	}
    String salida() throws Exception {
        if (estaVacia())
            throw new Exception("Cola vacia");

        String res = salida.getDato();
        return res;
    }

	boolean estaVacia() {
		return salida == null;
	}



	void vaciar() {
		entrada = null;
		salida = null;
	}
}
