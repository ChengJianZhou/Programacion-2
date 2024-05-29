package hlm;

import hl.ICuadricula;
import java.util.Queue;
import java.util.LinkedList;

public class HormigaReiterativa extends HormigaModificada {

    private static enum Estatus { MOVIENDO, REITERANDO }
    private Estatus estatus;
    private int movimientos = 0;
    public static int vecesParaAlternar = 5;
    private final Queue<Giro> giros = new LinkedList<>();

    // Constructor
    public HormigaReiterativa() {
        super();
        this.estatus = Estatus.MOVIENDO;
    }

    private void cambiarEstatus() {
        if (estatus == Estatus.MOVIENDO && movimientos >= vecesParaAlternar) {
            estatus = Estatus.REITERANDO;
            movimientos = 0;
        } else if (estatus == Estatus.REITERANDO && giros.isEmpty()) {
            estatus = Estatus.MOVIENDO;
        }
    }

    @Override
    public Giro girar(ICuadricula cuadricula) {
        cambiarEstatus();
        Giro giro = null;
        if (estatus == Estatus.MOVIENDO) {
            giro = super.girar(cuadricula);
            giros.offer(giro);
            movimientos++;
        } else if (estatus == Estatus.REITERANDO) {
            if (giros.isEmpty()) {
                estatus = Estatus.MOVIENDO;
                return super.girar(cuadricula); // Fallback in case of empty queue
            }
            giro = giros.poll();
            if (this.x >= 0 && this.x < CuadriculaTresColores.DIM && this.y >= 0 && this.y < CuadriculaTresColores.DIM) {
                // Perform the stored turn
                switch (giro) {
                    case IZQUIERDA:
                        orientacion = orientacion.girarIzquierda();
                        break;
                    case DERECHA:
                        orientacion = orientacion.girarDerecha();
                        break;
                    case MEDIA_VUELTA:
                        orientacion = orientacion.girarMediaVuelta();
                        break;
                    default:
                        break;
                }
            } else {
                // If out of bounds, turn 180 degrees
                orientacion = orientacion.girarMediaVuelta();
                giro = Giro.MEDIA_VUELTA;
            }
        }
        return giro;
    }

    @Override
    public String rutaDeLaImagen() {
        return estatus == Estatus.MOVIENDO ? "res/ant_1.png" : "res/ant_2.png";
    }

    @Override
    public String toString() {
        return String.format("st: %d, mov: %d, seq: %s, alt: %d",
                estatus.ordinal(), movimientos, giros.toString(), vecesParaAlternar);
    }
}
