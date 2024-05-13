
public class TestFiguras {

    private static final Punto2D ORIGEN = new Punto2D(0.0, 0.0);
    private static final double PI = Math.PI;
    
    /*   TODO DESCOMENTAR
    // Test para comprobar que no es posible crear instancias de una
    // clase abstracta A con un new A(...)
    private static void testCrearAbstracta() {
      crearPoligono();
      crearFigura();
    }
    private static void crearPoligono() throws AssertionError {
      boolean funcionando1 = false;
      try {
        Poligono f = new Poligono(new Punto2D(0.0, 0.0), 3);
      } catch (Exception e) {
        funcionando1 = true;
      }
      if (!funcionando1) {
        throw new AssertionError();
      }
      
      boolean funcionando2 = false;
      try {
        Poligono f = new Poligono(new Punto2D(0.0, 0.0), 3);
      } catch (Exception e) {
        funcionando2 = true;
      }
      if (!funcionando2) {
        throw new AssertionError();
      }
    }
    
    private static void crearFigura() throws AssertionError {
      boolean funcionando = false;
      try {
        Figura f = new Figura();
      } catch (Exception e) {
        funcionando = true;
      }
      if (!funcionando) {
        throw new AssertionError();
      }
      
    }
  */
  
  
    /**
     * Verifica que las aserciones operen correctamente
     * e informa al usuario e.o.c.
     */
    private static void testEjecutando() {
      boolean funcionando = false;
      try {
        assert false;
      } catch (AssertionError e) {
        funcionando = true;
      }
      if (!funcionando) {
        throw new RuntimeException("Utiliza el parámetro -ea");
      }
    }
  
    private static void testCirculo() {
      Circulo c = new Circulo(ORIGEN, 5.0);
      assert c.centro().equals(new Punto2D(0.0, 0.0));
      assert c.radio() == 5.0;
      assert c.area() == PI * 25.0;
      assert c.longitud() == 10.0 * PI;
    }
  
    private static void testPoligonoRegular() {
  
      PoligonoRegular p = new Equilatero(ORIGEN, 4.0);
      PoligonoRegular c1 = new Cuadrado(new Punto2D(5.0, 3.0), 6.0);
  
      assert c1.nLados() == 4;
      System.out.println("Compare Centro: 5.0, 3.0 |  longitud:6.0 con");
      System.out.println(c1.toString());
      assert p.area() < c1.area() : p.area() + " debe ser menor que " + c1.area();
      assert p.area() == 4 * Math.sqrt(3);
      assert !c1.equals(new Cuadrado(new Punto2D(1.0, 1.0), 5.0));
      assert c1.centro().distancia(p.centro()) != 6 * PI;
      assert !(c1.longitud() == 36);
      assert c1.equals(new Cuadrado(new Punto2D(5.0, 3.0), 6.0));
    }
  
    private static void testRectangulo() {
      Rectangulo a = new Rectangulo(new Punto2D(0, 1), 10, 5);
      assert a.centro().equals(new Punto2D(0, 1)): a.centro();
      assert a.area() == 50 : a.area();
      assert a.longitud() == 30 : a.longitud();
  
    }
  
    private static void testEquals() {
      testAfirmativosEquals();
      testNegativosEquals();
    }
  
    private static void testNegativosEquals() {
      Circulo c1 = new Circulo(ORIGEN, 4.99);
      Circulo c2 = new Circulo(ORIGEN, 5);
  
      assert !(c1.equals(c2));
  
      Cuadrado p1 = new Cuadrado(ORIGEN, 3);
      Cuadrado p2 = new Cuadrado(ORIGEN, 4);
  
      assert !(p1.equals(p2));
  
      Equilatero e1 = new Equilatero(ORIGEN, 5);
      Equilatero e2 = new Equilatero(ORIGEN, 6);
  
      assert !(e1.equals(e2));
  
      Hexagono h1 = new Hexagono(ORIGEN, 8);
      Hexagono h2 = new Hexagono(ORIGEN, 9);
  
      assert !(h1.equals(h2));
  
      Isosceles i1 = new Isosceles(ORIGEN, 2, 5);
      Isosceles i2 = new Isosceles(ORIGEN, 3, 6);
  
      assert !(i1.equals(i2));
  
      Rectangulo r1 = new Rectangulo(ORIGEN, 8, 6);
      Rectangulo r2 = new Rectangulo(ORIGEN, 9, 7);
  
      assert !(r1.equals(r2));
  
    }
  
    private static void testAfirmativosEquals() {
      Circulo c1 = new Circulo(ORIGEN, 5);
      Circulo c2 = new Circulo(ORIGEN, 5);
  
      assert c1.equals(c2);
  
      Cuadrado p1 = new Cuadrado(ORIGEN, 3);
      Cuadrado p2 = new Cuadrado(ORIGEN, 3);
  
      assert p1.equals(p2);
  
      Equilatero e1 = new Equilatero(ORIGEN, 5);
      Equilatero e2 = new Equilatero(ORIGEN, 5);
  
      assert e1.equals(e2);
  
      Hexagono h1 = new Hexagono(ORIGEN, 8);
      Hexagono h2 = new Hexagono(ORIGEN, 8);
  
      assert h1.equals(h2);
  
      Isosceles i1 = new Isosceles(ORIGEN, 2, 5);
      Isosceles i2 = new Isosceles(ORIGEN, 2, 5);
  
      assert i1.equals(i2);
  
      Rectangulo r1 = new Rectangulo(ORIGEN, 8, 6);
      Rectangulo r2 = new Rectangulo(ORIGEN, 8, 6);
  
      assert r1.equals(r2);
    }
  
    public static void main(String[] args) {
      testEjecutando();
      testCirculo();
      testPoligonoRegular();
      testRectangulo();
      testEquals();
  
      System.out.println("Todos los tests pasados");
      System.out.println("(asegúrate que estás usando el flag -ea para ejecutar los tests");
  
    }
  
  }
  