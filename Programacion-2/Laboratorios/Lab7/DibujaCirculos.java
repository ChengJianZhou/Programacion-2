import java.awt.Color;
import java.util.Random;

public class DibujaCirculos {

    private static int circulosValido = 0;
    private static int circulosNoValidos = 0;
    private static int totalCirculosGenerados = 0;

    // Inicializa el sistema gráfico con un lienzo
    public static void iniciarLienzo() {
        StdDraw.setCanvasSize(600, 600);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        StdDraw.enableDoubleBuffering();
    }

    // Dibuja un círculo con relleno en color
    public static void dibujarCirculo(Circulo c, Color color) {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(c.centro().x(), c.centro().y(), c.radio());
    }

    // Genera un círculo de radio r en una posición aleatoria
    public static Circulo generarCirculo(double r) {
        totalCirculosGenerados++;
        Random rand = new Random();
        double x = rand.nextDouble(); // Posición aleatoria en el rango [0, 1)
        double y = rand.nextDouble(); // Posición aleatoria en el rango [0, 1)
        return new Circulo(new Punto(x, y), r);
    }

    // Genera un color aleatorio
    public static Color generarColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        return new Color(r, g, b);
    }

    // Genera una lista de círculos con posiciones aleatorias
    public static ListaDeCirculos generarCirculos(int n) {
        ListaDeCirculos listaCirculos = new ListaDeCirculos();
        for (int i = 0; i < n; i++) {
            double radio = 0.05;
            Circulo c = generarCirculo(radio);
            listaCirculos.insertarPrincipio(c);
        }
        return listaCirculos;
    }

    // Dibuja los círculos de la lista con el color especificado
    public static void dibujarCirculos(ListaDeCirculos circulos, Color color) {
        for (int i = 0; i < circulos.longitud(); i++) {
            Circulo c = circulos.obtener(i);
            dibujarCirculo(c, color);
        }
        StdDraw.show();
    }

    // Dibuja los círculos con colores aleatorios
    public static void dibujarCirculos(ListaDeCirculos circulos) {
        for (int i = 0; i < circulos.longitud(); i++) {
            Circulo c = circulos.obtener(i);
            Color color = generarColor();
            dibujarCirculo(c, color);
        }
        StdDraw.show();
    }

    // Verifica si un círculo está externo a todos los de la lista
    public static boolean esExterno(Circulo c, ListaDeCirculos circulos) {
        boolean resultado = true;
        Punto p1 = new Punto(0, 0);
        Punto p2 = new Punto(1, 1);
        for (int i = 0; i < circulos.longitud(); i++) {
            Circulo circulo = circulos.obtener(i);
            resultado = intersectan(c, circulo) && estaDentro(c, p1, p2);
            if (resultado == false) {
                return resultado;
            }
        }
        return resultado; // El círculo c está externo a todos los de la lista
    }
    
    // Genera una lista de círculos válidos
    public static ListaDeCirculos generarValidos(int n) {

        ListaDeCirculos circulosValidos = new ListaDeCirculos();
        Circulo a = generarCirculo(0.02);
        circulosValidos.insertarPrincipio(a);
        while (circulosValidos.longitud() < n) {
            Circulo c = generarCirculo(0.02); 
            if (esExterno(c, circulosValidos)) {
                circulosValidos.insertarPrincipio(c);
                circulosValido++;
            } else {
                circulosNoValidos++;
            }
        }return circulosValidos;
    }

    public static boolean intersectan(Circulo c1, Circulo c2){

        return c1.distancia(c2) >= 2 * c1.radio();
    }

    public static boolean estaDentro(Circulo c, Punto p1, Punto p2){
        // Verificar si el centro del círculo está dentro del rectángulo
        boolean dentroEnX = c.centro().x() >= p1.x() && c.centro().x() <= p2.x();
        boolean dentroEnY = c.centro().y() >= p1.y() && c.centro().y() <= p2.y();

        // Verificar si el radio del círculo no excede los límites del rectángulo
        boolean dentroEnRadio = c.centro().x() - c.radio() >= p1.x() &&
                                c.centro().x() + c.radio() <= p2.x() &&
                                c.centro().y() - c.radio() >= p1.y() &&
                                c.centro().y() + c.radio() <= p2.y();

        // El círculo está completamente dentro o tangente interior al rectángulo
        return dentroEnX && dentroEnY && dentroEnRadio;
    }


    // Método main para dibujar todos los círculos generados
    public static void main(String[] args) {
        iniciarLienzo();
        ListaDeCirculos circulosValidos = generarValidos(200); // Cambia 100 por el número deseado de círculos
        dibujarCirculos(circulosValidos);
        
        double porcentajeExito = ((double) circulosValidos.longitud() / totalCirculosGenerados) * 100;
        
       // Mostrar información en el lienzo
       StdDraw.setPenColor(Color.BLACK);
       StdDraw.text(0.1, 0.9, "Total de círculos generados: " + totalCirculosGenerados);
       StdDraw.text(0.1, 0.85, "Círculos válidos: " + circulosValido);
       StdDraw.text(0.1, 0.8, "Círculos inválidos: " + circulosNoValidos);
       StdDraw.text(0.1, 0.75, "Porcentaje de éxito: " + porcentajeExito + "%");
       
       StdDraw.show();
    }
}
