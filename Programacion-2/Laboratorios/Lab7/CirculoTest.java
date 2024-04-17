public class CirculoTest {
  public static void main(String[] args) {
    Punto p00 = new Punto();
    Punto p11 = new Punto(1.0, 1.0);
    Circulo c1 = new Circulo(new Punto(), 2.0);
    Circulo c2 = new Circulo(new Punto(), 2.0);
    Circulo c3 = new Circulo(p11, 1.0);
    Circulo c4 = new Circulo(p11, 2.0);
    assert c1.radio() == 2.0;
    assert c1.radio() == c2.radio();
    assert c1.equals(c2);
    assert !c1.equals(null);
    assert !c1.equals("Hola");

    c2.trasladar(1.0, 1.0);
    assert c2.radio() == 2.0;
    assert c2.equals(c4);
    assert !c2.equals(c3);
    System.out.println("Todos los tests pasados");
    System.out.println("(asegúrate que estás usando el flag -ea para ejecutar los tests");
  }
}
