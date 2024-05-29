package hlm;

import hl.Casilla;
import hl.Hormiga;
import hl.ICuadricula;

public class HormigaModificada extends Hormiga {

    // Constructor sin parámetros que inicializa la hormiga en (0, 0) y orientada a
    // la izquierda
    public HormigaModificada() {
        super();
    }

    // Constructor con parámetros que inicializa la hormiga en una posición
    // específica y orientada a la izquierda
    public HormigaModificada(int x, int y) {
        super();
    }

    @Override
    public Giro girar(ICuadricula cuadricula) {
        // Verifica si la hormiga está fuera de los límites de la cuadrícula
        if (this.x < 0 || this.x >= CuadriculaTresColores.DIM || this.y < 0 || this.y >= CuadriculaTresColores.DIM) {
            // Gira 180 grados si está fuera de los límites
            orientacion = orientacion.girarMediaVuelta();
            return Giro.MEDIA_VUELTA;
        } else {
            // Obtiene la casilla actual de la cuadrícula
            Casilla casillaActual = cuadricula.casilla(x, y);
            int color = casillaActual.color(); // Obtiene el color de la casilla

            if (color != 0 && color != 1 && color != 2) {
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
                    case 2: // Si la casilla es roja, da media vuelta
                        orientacion = orientacion.girarMediaVuelta();
                        return Giro.MEDIA_VUELTA;
                    default:
                        // Esto nunca debería ocurrir debido al chequeo previo
                        throw new IllegalStateException("El color no se reconoce");
                }
            }
        }
    }
}
