package E_pyCListas;

public class colaEnlazadaChar {
	private nodo_Char entrada;
	private nodo_Char salida;

	public colaEnlazadaChar() {
		entrada = null;
		salida = null;
	}

	void encolar(char d) {
		nodo_Char aux = new nodo_Char(d);
		if (entrada != null)
			entrada.setNext(aux);
		entrada = aux;
		if (salida == null)
			salida = entrada;
	}

	char desencolar() throws Exception {
		if (salida == null)
			throw new Exception("Cola vacia");
		char res = salida.getDato();
		salida = salida.getNext();
		if (salida == null)
			entrada = null;
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