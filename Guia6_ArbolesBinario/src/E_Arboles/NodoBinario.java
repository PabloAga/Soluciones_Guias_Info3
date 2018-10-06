package E_Arboles;


public class NodoBinario<AnyType extends Comparable<AnyType>> {
    private NodoBinario<AnyType> izq;
    private NodoBinario<AnyType> der;
    private AnyType dato;

    public NodoBinario(AnyType dato) {
        this.dato = dato;
        this.izq = null;
        this.der = null;
    }

    public NodoBinario<AnyType> getIzq() {
        return izq;
    }

    public void setIzq(NodoBinario izq) {
        this.izq = izq;
    }

    public NodoBinario<AnyType> getDer() {
        return der;
    }

    public void setDer(NodoBinario der) {
        this.der = der;
    }

    public AnyType getDato() {
        return dato;
    }

    public void setDato(AnyType dato) {
        this.dato = dato;
    }

}