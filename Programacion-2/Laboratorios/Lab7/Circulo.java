/**
 * Las instancias de Circulo representan circulos en el plano.
 */
public class Circulo {

    public Punto centro;
    public double radio;

    public Circulo(Punto c, double r) {
        this.centro = c;
        this.radio = r;
    }

    public void trasladar(double dx, double dy) {
        this.centro.trasladar(dx, dy);
    }

    public double distancia(Circulo c) {
        return this.centro.distancia(c.centro);
    }

    public double radio() {
        return this.radio;
    }

    public Punto centro() {
        return this.centro;
    }

    public boolean equals(Object o) {
        return this == o;
    }
}
