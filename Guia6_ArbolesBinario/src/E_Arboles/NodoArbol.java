package E_Arboles;


public class NodoArbol<AnyType extends Comparable<AnyType>> {
    private NodoArbol<AnyType> izq;
    private NodoArbol<AnyType> der;
    private AnyType dato;

    public NodoArbol(AnyType dato) {
        this.dato = dato;
        this.izq = null;
        this.der = null;
    }

    public NodoArbol<AnyType> getIzq() {
        return izq;
    }

    public void setIzq(NodoArbol izq) {
        this.izq = izq;
    }

    public NodoArbol<AnyType> getDer() {
        return der;
    }

    public void setDer(NodoArbol der) {
        this.der = der;
    }

    public AnyType getDato() {
        return dato;
    }

    public void setDato(AnyType dato) {
        this.dato = dato;
    }

}