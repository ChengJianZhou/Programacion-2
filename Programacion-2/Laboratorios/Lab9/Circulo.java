public class Circulo extends Figura {
    protected double radio;

    public Circulo (Punto2D c, double r){
        this.centro = c;
        this.radio = r;
    }

    public double radio(){
        return radio;
    }

    public double area(){
        return radio * radio * Math.PI;
    }

    public Punto2D centro(){
        return centro;
    }

    public double longitud(){
        return 2 * Math.PI * radio;
    }
}
