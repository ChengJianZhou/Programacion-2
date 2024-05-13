public abstract class Poligono extends Figura {
    private int nLados;

    public Poligono(Punto2D c, int n){
        super();
        this.centro = c;
        this.nLados = n;
    }

    public int numLados(){
        return nLados;
    }

    public abstract int nLados();
}
