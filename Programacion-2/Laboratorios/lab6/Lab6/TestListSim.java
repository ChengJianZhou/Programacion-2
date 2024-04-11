public class TestListSim {
    public static void main(String[] args) {
        ListSim lista = new ListSim();
        
        // Test 1: La lista recién creada debe tener 0 elementos
        assert lista.size() == 0 : "Una lista recién creada debe tener 0 elementos";

        // Test 2: Tras añadir un elemento, la lista debe tener 1 elemento
        lista.add(0, new Sim("Ángel"));
        assert lista.size() == 1 : "Tras añadir un elemento la lista debe tener 1 elemento";

        // Test 3: El nombre del Sim añadido debe ser "Ángel"
        assert "Ángel".equals(lista.get(0).nombre()) : "Error en el elemento almacenado";
        
        System.out.println("Todos los tests pasaron correctamente.");
    }
}