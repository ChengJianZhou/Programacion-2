package hl;

public class Hormiga implements IHormiga {
    // Variables de instancia
    private int x; // Coordenada x de la hormiga
    private int y; // Coordenada y de la hormiga
    private int tickCounter; // Contador de ticks
    private Orientacion orientacion; // Orientación actual de la hormiga

    // Constructor sin parámetros que inicializa la hormiga en (0, 0) y orientada a la izquierda
    public Hormiga() {
        this.x = 0;
        this.y = 0;
        this.orientacion = Orientacion.IZQUIERDA;
    }

    // Constructor con parámetros que inicializa la hormiga en una posición específica y orientada a la izquierda
    public Hormiga(int x, int y) {
        this.x = x;
        this.y = y;
        this.orientacion = Orientacion.IZQUIERDA;
    }

    @Override
    public void mover(int incX, int incY) {
        // Mueve la hormiga incrementando las coordenadas x e y
        this.x += incX;
        this.y += incY;
    }

    @Override
    public Giro girar(ICuadricula cuadricula) {
        // Verifica si la hormiga está fuera de los límites de la cuadrícula
        if (this.x < 0 || this.x >= Cuadricula.DIM || this.y < 0 || this.y >= Cuadricula.DIM) {
            // Gira 180 grados si está fuera de los límites
            orientacion = orientacion.girarMediaVuelta();
            return Giro.MEDIA_VUELTA;
        } else {
            // Obtiene la casilla actual de la cuadrícula
            Casilla casillaActual = cuadricula.casilla(x, y);
            int color = casillaActual.color(); // Obtiene el color de la casilla
            if (color != 0 && color != 1) {
                // Lanza una excepción si el color no es reconocido
                throw new IllegalStateException("El color no se reconoce");
            } else {
                switch (color) {
                    case 0: // Si la casilla es blanca, gira a la izquierda
                        orientacion = orientacion.girarIzquierda();
                        return Giro.IZQUIERDA;
                    case 1: // Si la casilla es negra, gira a la derecha
                        orientacion = orientacion.girarDerecha();
                        return Giro.DERECHA;
                    default:
                        // Esto nunca debería ocurrir debido al chequeo previo
                        throw new IllegalStateException("El color no se reconoce");
                }
            }
        }
    }

    @Override
    public void cambiarColor(ICuadricula cuadricula) {
        // Cambia el color de la casilla actual
        Casilla casillaActual = cuadricula.casilla(x, y);
        casillaActual.cambiarColor();
    }

    @Override
    public void avanzar() {
        // Mueve la hormiga una casilla en la dirección de su orientación actual
        orientacion.mover(this);
    }

    @Override
    public void tick(ICuadricula cuadricula) {
        // Realiza una acción basada en el valor del tickCounter
        switch (tickCounter % 3) {
            case 0:
                // En el tick 0, gira
                girar(cuadricula);
                break;
            case 1:
                // En el tick 1, cambia el color de la casilla si está dentro de los límites
                if (this.x < 0 || this.x >= Cuadricula.DIM || this.y < 0 || this.y >= Cuadricula.DIM) {
                    tickCounter = 1; // Restaura el contador si está fuera de los límites
                } else {
                    cambiarColor(cuadricula);
                }
                break;
            case 2:
                // En el tick 2, avanza
                avanzar();
                break;
        }
        tickCounter++; // Incrementa el contador de ticks
    }

    @Override
    public int[] coordenadas() {
        // Devuelve las coordenadas actuales de la hormiga
        return new int[] { x, y };
    }

    @Override
    public String rutaDeLaImagen() {
        // Devuelve la ruta de la imagen que representa a la hormiga
        return "res/ant_1.png";
    }

    @Override
    public int getAnguloEnGrados() {
        // Devuelve el ángulo en grados correspondiente a la orientación actual de la hormiga
        return orientacion.getAnguloEnGrados();
    }
}
