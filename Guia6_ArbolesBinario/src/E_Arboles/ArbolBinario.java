package E_Arboles;

public class ArbolBinario<AnyType extends Comparable<AnyType>> {
    private NodoBinario<AnyType> raiz;


    public void insertar(AnyType d) throws Exception {
        if (raiz != null)
            insertar(d, raiz);
        else
            raiz = new NodoBinario<>(d);
    }

    public AnyType buscar(AnyType d) throws Exception {
        return buscar(d, raiz);
    }

    public void borrar(AnyType d) throws Exception {
        borrar(d, raiz);
    }

    public void inOrder() {
        inOrder(raiz);
    }

    public void preOrder() {
        preOrder(raiz);
    }

    public void postOrder() {
        postOrder(raiz);
    }

    public void print() {
        print(false, "", raiz);
    }

    private void insertar(AnyType d, NodoBinario<AnyType> r) throws Exception {
        if (d.compareTo(r.getDato()) > 0) {
            if (r.getDer() != null) {
                insertar(d, r.getDer());
            } else {
                r.setDer(new NodoBinario<>(d));
            }
        } else if (d.compareTo(r.getDato()) < 0) {
            if (r.getIzq() != null) {
                insertar(d, r.getIzq());
            } else {
                r.setIzq(new NodoBinario<>(d));
            }
        } else {
            throw new Exception("El nodo ya existe");
        }
    }


    private AnyType buscar(AnyType d, NodoBinario<AnyType> r) throws Exception {

        if (r == null)
            throw new Exception("404");

        int comp = d.compareTo(r.getDato());
        if (comp == 0)
            return r.getDato();

        if (comp > 0)
            return buscar(d, r.getDer());
        else
            return buscar(d, r.getIzq());
    }

    private NodoBinario<AnyType> borrar(AnyType d, NodoBinario<AnyType> r) throws Exception {
        if (r == null)
            throw new Exception("404");

        int comp = d.compareTo(r.getDato());
        if (comp == 0) {
            insertar(r.getDer(), r.getIzq());
            return r.getDer();
        }

        if (comp > 0) {
            r.setDer(borrar(d, r.getDer()));
            return r;
        } else {
            r.setIzq(borrar(d, r.getIzq()));
            return r;
        }
    }


    private void insertar(NodoBinario<AnyType> r, NodoBinario<AnyType> h) throws Exception {

        int comp = r.getDato().compareTo(h.getDato());

        if (comp > 0) {
            if (r.getDer() != null) {
                insertar(r.getDer(), h);
            } else {
                r.setDer(h);
            }
            return;
        }


        if (comp < 0) {
            if (h.getIzq() != null) {
                insertar(r.getIzq(), h);
            } else {
                r.setIzq(h);
            }
            return;
        }
        throw new Exception("El nodo ya existe");
    }
//
//    public int altura() {
//        return altura(raiz);
//    }
//
//    public int profundidad(AnyType d) {
//        return profundidad(d, raiz);
//    }


    private void inOrder(NodoBinario<AnyType> r) {

        if (r == null)
            return;

        inOrder(r.getIzq());
        System.out.println(r.getDato());
        inOrder(r.getDer());

        /*

        if (r.getIzq() != null)
            inOrder(r.getIzq());

        System.out.println(r.getDato());

        if (r.getDer() != null)
            inOrder(r.getDer());

        */
    }


    private void preOrder(NodoBinario r) {
        if (r == null)
            return;

        System.out.println(r.getDato());
        preOrder(r.getIzq());
        preOrder(r.getDer());
    }


    private void postOrder(NodoBinario r) {
        if (r == null)
            return;

        preOrder(r.getIzq());
        preOrder(r.getDer());
        System.out.println(r.getDato());
    }
   private int  altura(NodoBinario r) {
	   if(raiz== null)
		   return 0;
	   return 1+Math.max(altura(r.getIzq()), altura(r.getDer()));
   }


    private void print(boolean esDerecho, String identacion, NodoBinario<AnyType> r) {
        if (r.getDer() != null) {
            print(true, identacion + (esDerecho ? "     " : "|    "), r.getDer());
        }
        System.out.print(identacion);
        if (esDerecho) {
            System.out.print(" /");
        } else {
            System.out.print(" \\");
        }
        System.out.print("-- ");
        System.out.println(r.getDato());
        if (r.getIzq() != null) {
            print(false, identacion + (esDerecho ? "|    " : "     "), r.getIzq());
        }
    }


}

