public class Rectangulo extends Poligono{
    private double base;
    private double altura;

    public Rectangulo(Punto2D c, double b, double a){
        super(c, 4);
        this.base = b;
        this.altura = a;
    }

    public double area() {
        return base * altura;
    }

    public Punto2D centro() {
        return centro;
    }

    public double longitud() {
        return base * 2 + altura * 2;
    }

    public int nLados() {
        return numLados();
    }
}
