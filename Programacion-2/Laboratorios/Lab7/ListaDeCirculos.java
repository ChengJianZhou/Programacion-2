public class ListaDeCirculos {
    
    private NodoCirculo inicio;
    private int longitud;

    public ListaDeCirculos(){
        this.inicio = null;
        this.longitud = 0;
    }

    public void insertarPrincipio(Circulo c){
        NodoCirculo nodoPrincipo = new NodoCirculo(c, inicio);
        inicio = nodoPrincipo;
        longitud++;
    }

    public void insertarFinal(Circulo c){
        NodoCirculo nodoFinal = new NodoCirculo(c, null);
        if (inicio == null) {
            inicio = nodoFinal;
            longitud++;
        } else {
            NodoCirculo actual = inicio;
            while (actual.siguiente != null) {
                actual = actual.siguiente; // Avanzar hasta el último nodo
            }
            actual.siguiente = nodoFinal;
            longitud++;
        }
    }

    public int longitud() {
        return longitud;
    }

    public Circulo obtener(int pos) {
        NodoCirculo actual = inicio;
        for (int i = 0; i < pos; i++) {
            actual = actual.siguiente; // Avanzar hasta la posición deseada
        }
        return actual.circulo; // Devolver el círculo del nodo en esa posición
    }
}
