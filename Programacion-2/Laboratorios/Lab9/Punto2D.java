public class Punto2D {
    private double x;
    private double y;

    public Punto2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double x(){
        return x;
    }

    public double y(){
        return y;
    }

    public double distancia(Punto2D p){
        double dy = (this.y - p.y);
        double dx = (this.x - p.x);
        return Math.sqrt(dy*dy + dx*dx);
    }
}
