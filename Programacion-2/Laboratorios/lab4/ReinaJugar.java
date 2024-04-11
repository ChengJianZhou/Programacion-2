import java.util.Random;
import java.util.Scanner;

public class ReinaJugar {

    public static Tablero leer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la dimensión del tablero: ");
        int dimension = scanner.nextInt();
        return new Tablero(dimension);
    }

    public static void leerYMarcar(Tablero tablero) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la fila de la reina: ");
        int filaReina = scanner.nextInt();
        System.out.print("Ingrese la columna de la reina: ");
        int columnaReina = scanner.nextInt();
        
        tablero.marcarAmenazadas(filaReina, columnaReina);
    }

    public static void pintar(Tablero tablero) {
        System.out.println(tablero);
    }

    public static int cuantasAmenazadas(Tablero tablero) {
        int amenazadas = 0;
        for (int i = 1; i <= tablero.dimencion(); i++) {
            for (int j = 1; j <= tablero.dimencion(); j++) {
                if (tablero.esCuadroAmenazado(i, j, i, j)) {
                    amenazadas++;
                }
            }
        }
        return amenazadas;
    }

    public static int calculo(int n, int d) {
        int totalAmenazadas = 0;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            Tablero tablero = new Tablero(d);
            int filaReina = random.nextInt(d) + 1;
            int columnaReina = random.nextInt(d) + 1;
            tablero.marcarAmenazadas(filaReina, columnaReina);
            totalAmenazadas += cuantasAmenazadas(tablero);
        }
        return totalAmenazadas / n;
    }

    public static void tabla() {
        System.out.println("Tabla de resultados:");
        System.out.println("n \t d \t Amenazadas Promedio");
        for (int n = 100; n <= 1000; n += 100) {
            for (int d = 8; d <= 10; d++) {
                int amenazadasPromedio = calculo(n, d);
                System.out.println(n + "\t" + d + "\t" + amenazadasPromedio);
            }
        }
    }
}
