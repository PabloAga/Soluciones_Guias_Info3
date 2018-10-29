package Parcial2;

public class cola_Enlazada_AnyType<AnyType extends Comparable<AnyType>> {

	private nodo_Cola_AnyType entrada;
	private nodo_Cola_AnyType salida;
	private int size=0;

	public cola_Enlazada_AnyType() {
		entrada = null;
		salida = null;
	}

	void encolar(AnyType d) {
		 nodo_Cola_AnyType aux = new  nodo_Cola_AnyType(d);
		 size++;
		if (entrada != null)
			entrada.setNext(aux);
		entrada = aux;
		if (salida == null)
			salida = entrada;
	}

	AnyType desencolar() throws Exception {
		if (salida == null)
			throw new Exception("Cola vacia");
		AnyType res = (AnyType) salida.getDato();
		size--;
		salida = salida.getNext();
		if (salida == null)
			entrada = null;
		return res;
	}
	AnyType salida() throws Exception {
        if (estaVacia())
            throw new Exception("Cola vacia");

        AnyType res = (AnyType) salida.getDato();
        return res;
    }

	boolean estaVacia() {
		return salida == null;
	}



	void vaciar() {
		entrada = null;
		salida = null;
	}
	int size() {
		return size;
	}
}
