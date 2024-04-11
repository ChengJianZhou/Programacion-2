public class TableroPruebas {
    public static void main(String[] args) {
        // Crear un tablero de dimensiones 8x8
        Tablero tablero = new Tablero(8);
        
        // Mostrar el tablero inicial
        System.out.println("Tablero inicial:");
        System.out.println(tablero.toString());
        
        // Probar algunas funcionalidades
        pruebaEsCuadroBlanco(tablero, 1, 1); // Debería ser verdadero
        pruebaEsCuadroBlanco(tablero, 1, 2); // Debería ser falso
        pruebaEsPosicionTablero(tablero, 1, 1); // Debería ser verdadero
        pruebaEsPosicionTablero(tablero, 0, 0); // Debería ser falso
        
        // Marcar amenazas de una reina en (4, 4)
        System.out.println("\nMarcando amenazas de una reina en (4, 4):");
        tablero.marcarAmenazadas(4, 4);
        System.out.println(tablero.toString());
    }
    
    // Método para probar el método esCuadroBlanco
    private static void pruebaEsCuadroBlanco(Tablero tablero, int x, int y) {
        System.out.printf("¿El cuadro (%d, %d) es blanco? %s\n", x, y, tablero.esCuadroBlanco(x, y));
    }
    
    // Método para probar el método esPosicionTablero
    private static void pruebaEsPosicionTablero(Tablero tablero, int x, int y) {
        System.out.printf("¿La posición (%d, %d) está en el tablero? %s\n", x, y, tablero.esPosicionTablero(x, y));
    }
}