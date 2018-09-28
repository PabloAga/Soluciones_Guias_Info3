package E_pyCListas;

public class nodo_Char {
	private char dato;
	private nodo_Char next;

	nodo_Char () {
		next = null;
	}

	nodo_Char( char d) {
		next = null;
		dato = d;
	}

	nodo_Char (char d, nodo_Char n) {
		next = n;
		dato = d;
	}

	public char getDato() {
		return dato;
	}

	public void setDato(char dato) {
		this.dato = dato;
	}

	public nodo_Char getNext() {
		return next;
	}

	public void setNext(nodo_Char next) {
		this.next = next;
	}
}