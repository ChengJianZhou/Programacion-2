public class Punto {
  private double coordX;
  private double coordY;

  public Punto() {
    coordX = 0.0;
    coordY = 0.0;
  }

  public Punto(double x, double y) {
    this.coordX = x; this.coordY = y;
  }

  public double distancia(Punto p) {    
    return Math.sqrt((p.coordX - this.coordX)*(p.coordX - this.coordX)
                     + (p.coordY - this.coordY)*(p.coordY - this.coordY));
  }

  public void trasladar(double dx, double dy) {
    coordX += dx;
    coordY += dy;
  }

  public double x() {
    return this.coordX;
  }

  public double y() {
    return this.coordY;
  }

  public boolean equals(Object o) {
    if (o == null) return false;
    if (!(o instanceof Punto)) return false;
    Punto p = (Punto)o;
    return Math.abs(coordX - p.coordX) < 0.000001 && Math.abs(coordY - p.coordY) < 0.000001;
  }
}
