public class Isosceles extends Poligono {
    private double base;
    private double altura;

    public Isosceles(Punto2D c, double b, double a){
        super(c, 3);
        this.base = b;
        this.altura = a;
    }

    public double area() {
        return base * altura / 2;
    }

    public Punto2D centro() {
        return centro;
    }

    public double longitud() {
        double mitadBase = base / 2;
        double catetoLargo = Math.sqrt(mitadBase * mitadBase + altura *altura);
        return 2 * catetoLargo + base;
    }

    public int nLados() {
        return numLados();
    }
}
