package hl;

public class Orientacion {
    private int rumbo;

    private static final int[][] unitarios = { { 0, +1 }, { +1, 0 }, { 0, -1 }, { -1, 0 } };

    private Orientacion (int rumbo){
        this.rumbo = rumbo;
    }

    public Orientacion girarMediaVuelta (){
        return new Orientacion((rumbo + 2)%4);
    }

    public Orientacion girarIzquierda(){
        return new Orientacion((rumbo + 3)%4);
    }

    public Orientacion girarDerecha(){
        return new Orientacion((rumbo + 1)%4);
    }

    public void mover(IHormiga h){
        int[] incremento = unitarios[rumbo];
        h.mover(incremento[0], incremento[1]);
    }

    public int getAnguloEnGrados() {
        switch (rumbo) {
            case 0: return 0;       // Arriba
            case 1: return -90;     // Derecha
            case 2: return 180;     // Abajo
            case 3: return 90;      // Izquierda
            default: throw new IllegalStateException("Orientación desconocida " );
        }
    }

    public static final Orientacion IZQUIERDA = new Orientacion(3);
}
