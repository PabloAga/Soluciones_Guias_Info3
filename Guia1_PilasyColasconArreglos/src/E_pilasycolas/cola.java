package E_pilasycolas;

public class cola {
	private int entrada;
    private int salida;

    private String[] datos;
    private int cantidad;

    public cola() {
        entrada = 0;
        salida = 0;
        datos = new String[10];
        cantidad = 0;
    }

    public cola(int t) {
        entrada = 0;
        salida = 0;
        datos = new String[t];
        cantidad = 0;
    }

    public void encolar(String d) throws Exception {
        if (estaLlena()) {
            throw new Exception("Cola llena: " + d);
        }
        cantidad++;
        datos[entrada] = d;
        entrada = incrementar(entrada);
    }

    public String desencolar() throws Exception {
        if (estaVacia())
            throw new Exception("Cola vacia");

        cantidad--;
        String d = datos[salida];
        salida = incrementar(salida);
        return d;
    }

    public boolean estaVacia() {
        return entrada == salida && cantidad == 0;
    }

    public boolean estaLlena() {

        return entrada == salida && cantidad > 0;
    }
    public int cantElemento() {
    	return cantidad;
    }

    public String mostrarSalida() {
        return datos[incrementar(salida)];
    }


    private int incrementar(int x) {
        return (x + 1) % datos.length;
    }
}
