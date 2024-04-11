import java.util.ArrayList;

public class ListSim {
    private ArrayList<Sim> lista;

    /**
     * Constructor que crea una lista vacía de Sims.
     */
    public ListSim() {
        lista = new ArrayList<>();
    }

    /**
     * Añade un Sim a la lista en la posición especificada.
     *
     * @param index Índice en el que se añadirá el Sim.
     * @param sim   Sim que se añadirá a la lista.
     */
    public void add(int index, Sim sim) {
        lista.add(index, sim);
    }

    /**
     * Obtiene el Sim de la lista en la posición especificada.
     *
     * @param index Índice del Sim a obtener.
     * @return Sim en la posición especificada.
     */
    public Sim get(int index) {
        return lista.get(index);
    }

    /**
     * Devuelve el número de Sims en la lista.
     *
     * @return Tamaño de la lista.
     */
    public int size() {
        return lista.size();
    }

    /**
     * Establece un Sim en la posición especificada de la lista.
     *
     * @param index Índice en el que se establecerá el Sim.
     * @param sim   Nuevo Sim a establecer.
     */
    public void set(int index, Sim sim) {
        lista.set(index, sim);
    }

    /**
     * Elimina el Sim en la posición especificada de la lista.
     *
     * @param index Índice del Sim a eliminar.
     */
    public void remove(int index) {
        lista.remove(index);
    }

    /**
     * Elimina el primer Sim igual al especificado de la lista.
     *
     * @param sim Sim a eliminar.
     */
    public void remove(Sim sim) {
        lista.remove(sim);
    }

    /**
     * Devuelve una sublista de Sims entre las posiciones especificadas.
     *
     * @param inicio Índice de inicio de la sublista.
     * @param fin    Índice de fin (no inclusivo) de la sublista.
     * @return Sublista de Sims.
     */

    public void add(Sim sim) {
        lista.add(sim);
    }

    public ListSim subList(int inicio, int fin) {
        ListSim sublista = new ListSim();
        for (int i = inicio; i < fin; i++) {
            sublista.add(lista.get(i));
        }
        return sublista;
    }
}

