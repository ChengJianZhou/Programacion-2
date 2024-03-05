/** 
 * FechaDigital. 
 * 
 * @author PII
 */
import java.awt.Font;
import java.util.Calendar;

public class FechaDigital {
    // Constantes modo gráfico
    private static final int XMAX = 1250;
    private static final int YMAX = 700;
    private static final int ESCALA = 100;
    private static final double RADIOPINCEL = 0.02;
    private static final int XTEXTO = ESCALA / 2;
    private static final int YTEXTO = ESCALA / 2;
    private static final int TAM_TEXTO = YMAX / 3;

    // Método para iniciar los gráficos
    public static void iniciarGraficos() {
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(XMAX, YMAX);
        StdDraw.setScale(0, ESCALA);
        StdDraw.setPenRadius(RADIOPINCEL);
    }

    // Método para imprimir una fecha en modo gráfico
    public static void print(Fecha f) {
        Font font = new Font("Arial", Font.BOLD, TAM_TEXTO);
        StdDraw.setFont(font);
        StdDraw.text(XTEXTO, YTEXTO, f.toString());
    }

    // Método para probar la escritura de una fecha en modo gráfico
    public static void testGraficos() {
        iniciarGraficos();
        StdDraw.clear(StdDraw.BLACK);
        StdDraw.setPenColor(StdDraw.GREEN);
        print(Fecha.ahora());
        StdDraw.show();
        StdDraw.pause(1000);
        print(Fecha.ahora());
        StdDraw.show();
        StdDraw.pause(1000);
    }

    // Método para simular un reloj digital en modo gráfico
    public static void reloj() {
        iniciarGraficos();
        while (true) {
            StdDraw.clear();
            print(Fecha.ahora());
            StdDraw.show();
            StdDraw.pause(1000);
        }
    }

    // Método main para ejecutar la aplicación
    public static void main(String[] args) {
        // testGraficos(); // Descomenta para probar la escritura de una fecha en modo gráfico
        reloj(); // Comenta testGraficos() y descomenta esta línea para simular un reloj digital en modo gráfico
    }
}
