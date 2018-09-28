package E_pyCListas;

public class Nodo {
	private int dato;
	private Nodo next;

	Nodo() {//inicializa el nodo next que apunta null
		next = null;
	}

	Nodo(int d) {//primer nodo que ingresa que el puntero apunta null
		next = null;
		dato = d;
	}

	Nodo(int d, Nodo n) {//nodos siguientes al  que apunta a null
		next = n;
		dato = d;
	}

	public int getDato() {//devuelve el dato
		return dato;
	}

	public void setDato(int dato) {//inserta el dato
		this.dato = dato;
	}

	public Nodo getNext() {//devuelve puntero que apunta al nodo  anterior
		return next;//direccion de memoria del nodo anterior
	}

	public void setNext(Nodo next) {//crea el nodo puntero
		this.next = next;
	}
}
