package E_pyCListas;

public class nodo_String {

	private String dato;
	private  nodo_String next;

	nodo_String () {
		next = null;
	}

	nodo_String( String d) {
		next = null;
		dato = d;
	}

	nodo_String (String d,  nodo_String n) {
		next = n;
		dato = d;
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public  nodo_String getNext() {
		return next;
	}

	public void setNext(nodo_String next) {
		this.next = next;
	}
}