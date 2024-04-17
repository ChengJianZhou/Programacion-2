public class GeometriaCirculo {
    public static boolean intersectan(Circulo c1, Circulo c2){
        return c1.distancia(c2)/2 == c1.radio || c1.distancia(c2)/2 == c2.radio;
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
}
