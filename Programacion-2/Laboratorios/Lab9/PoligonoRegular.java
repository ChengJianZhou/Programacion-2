public class PoligonoRegular extends Poligono{
    private double longLado;

    public PoligonoRegular(Punto2D c, int n, double l){
        super(c, n);
        this.longLado = l;
    }

    @Override
    public double area() {
        double n = nLados();
        double s = longLado;
        return (n * s * s) / (4 * Math.tan(Math.PI / n));
    }

    @Override
    public int nLados() {
        return numLados();
    }

    @Override
    public Punto2D centro() {
        return centro;
    }

    @Override
    public double longitud() {
        return longLado * nLados();
    }
}
