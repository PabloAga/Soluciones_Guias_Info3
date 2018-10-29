package Parcial2;

public class nodo_Cola_AnyType<AnyType extends Comparable<AnyType>>  {

	private AnyType dato;
	private  nodo_Cola_AnyType next;

	nodo_Cola_AnyType () {
		next = null;
	}

	nodo_Cola_AnyType( AnyType  d) {
		next = null;
		dato = d;
	}

	nodo_Cola_AnyType (AnyType d,  nodo_Cola_AnyType n) {
		next = n;
		dato = d;
	}

	public AnyType getDato() {
		return dato;
	}

	public void setDato(AnyType dato) {
		this.dato = dato;
	}

	public  nodo_Cola_AnyType getNext() {
		return next;
	}

	public void setNext(nodo_Cola_AnyType next) {
		this.next = next;
	}
}