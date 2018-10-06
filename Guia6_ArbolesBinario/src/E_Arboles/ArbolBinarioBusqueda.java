package E_Arboles;

public class ArbolBinarioBusqueda {
	    public NodoBinario raiz;

	    public ArbolBinarioBusqueda() {
	        raiz = null;
	    }

	    public void insertar(int x) {
	        raiz = insertar(x, raiz);
	    }

	    public void borrar(int x) {
	        raiz = borrar(x, raiz);
	    }

	    public void borrarMin() {
	        raiz = borrarMin(raiz);
	    }

	    public int encontrarMin() {
	        return datoEn(encontrarMin(raiz));
	    }

	    public int encontrarMax() {
	        return datoEn(encontrarMax(raiz));
	    }

	    public int encontrar(int x) {
	        return datoEn(encontrar(x, raiz));
	    }

	    public boolean esVacio() {
	        return raiz == null;
	    }

	    public void vaciar() {
	        raiz = null;
	    }

	    private int datoEn(NodoBinario t) {
	        return t == null ? null : t.dato;
	    }

	    private NodoBinario encontrar(int x, NodoBinario t) {
	        while (t != null) {
	            if (x < t.dato) {
	                t = t.izquierdo;
	            } else {
	                if (x > t.dato) {
	                    t = t.derecho;
	                } else {
	                    return t;
	                }
	            }
	        }

	        return null;
	    }

	    private NodoBinario encontrarMin(NodoBinario t) {
	        if (t != null) {
	            while (t.izquierdo != null) {
	                t = t.izquierdo;
	            }
	        }

	        return t;
	    }

	    private NodoBinario encontrarMax(NodoBinario t) {
	        if (t != null) {
	            while (t.derecho != null) {
	                t = t.derecho;
	            }
	        }

	        return t;
	    }

	    private NodoBinario insertar(int x, NodoBinario t) {
	        if (t == null) {
	            t = new NodoBinario(x, null, null);
	        } else {
	            if (x <= t.dato) {
	                t.izquierdo = insertar(x, t.izquierdo);
	            } else {
	                t.derecho = insertar(x, t.derecho);
	            }
	        }

	        return t;
	    }

	    private NodoBinario borrar(int x, NodoBinario t) {
	        if (t == null) {
	            System.out.print("No se ha encontrado el n�mero\n");
	            return null;
	        }

	        if (x < t.dato) {
	            t.izquierdo = borrar(x, t.izquierdo);
	        } else {
	            if (x > t.dato) {
	                t.derecho = borrar(x, t.derecho);
	            } else {
	                if (t.izquierdo != null && t.derecho != null) {
	                    t.dato = encontrarMin(t.derecho).dato;
	                    t.derecho = borrarMin(t.derecho);
	                } else {
	                    t = (t.izquierdo != null) ? t.izquierdo : t.derecho;
	                }
	            }
	        }

	        return t;
	    }

	    private NodoBinario borrarMin(NodoBinario t) {
	        if (t == null) {
	            System.out.print("No se ha encontrado el n�mero\n");
	            return null;
	        } else {
	            if (t.izquierdo != null) {
	                t.izquierdo = borrarMin(t.izquierdo);
	                return t;
	            } else {
	                return t.derecho;
	            }
	        }
	    }

	    public void imprimirEnOrden() {
	        if (raiz != null) {
	            raiz.imprimirEnOrden();
	        }
	    }
	}
