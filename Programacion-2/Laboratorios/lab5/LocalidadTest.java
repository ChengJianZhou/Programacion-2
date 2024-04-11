/**
 * Pruebas de Localidad
 * 
 * @author PII
 */

public class LocalidadTest {
  public static Localidad loc1, loc2, loc3, loc4, loc5, loc6;

  public static void resetear() {
    loc1 = new Localidad("Daganzo de Arriba", 5310, 5340);
    loc2 = new Localidad("Alcorcon", 81673, 88623);
    loc3 = new Localidad("Mostoles", 101318, 107443);
    loc4 = new Localidad("Leganes", 90038, 96622);
    loc5 = new Localidad("Fuenlabrada", 93170, 96721);
    loc6 = new Localidad("Getafe", 89393, 93826);
  }

  public static void mostrar() {
    System.out.println("loc1 = " + loc1);
    System.out.println("loc2 = " + loc2);
    System.out.println("loc3 = " + loc3);
    System.out.println("loc4 = " + loc4);
    System.out.println("loc5 = " + loc5);
    System.out.println("loc6 = " + loc6);
  }

  public static void testPoblacion() {
    resetear();
    System.out.println("loc2.poblacion() = " + loc2.poblacion());
    System.out.println("loc3.poblacion() = " + loc3.poblacion());
    System.out.println("loc4.poblacion() = " + loc4.poblacion());
  }

  public static void testConstructorLinea() {
    Localidad l1 = new Localidad("Hombres;Madrid;Majadahonda;1 de enero de 2022;34148");
    Localidad l2 = new Localidad("Mujeres;Madrid;Majadahonda;1 de enero de 2022;38031");
    System.out.println("l1 = " + l1);
    System.out.println("l2 = " + l2);
  }

  public static void testFusion1() {
    Localidad l1 = new Localidad("Hombres;Madrid;Majadahonda;1 de enero de 2022;34148");
    Localidad l2 = new Localidad("Mujeres;Madrid;Majadahonda;1 de enero de 2022;38031");
    System.out.println("l1 = " + l1);
    System.out.println("l2 = " + l2);
    System.out.println("fusion(l1, l2) = " + Localidad.fusion(l1, l2));
  }

  public static void testFusion2() {
    Localidad l1 = new Localidad("Brunete", 5510, 0);
    Localidad l2 = new Localidad("Brunete", 0, 5335);
    System.out.println("l1 = " + l1);
    System.out.println("l2 = " + l2);
    boolean testFusion2 = Localidad.fusion(l1, l2).equals(new Localidad("Brunete", 5510, 5335));
    System.out.println("fusion(l1, l2) = " + Localidad.fusion(l1, l2));
    System.out.println("testFusion2 = " + testFusion2);
  }

  public static void testFusion() {
    testFusion1();
    testFusion2();
  }

  public static void main(String[] args) {
    resetear();
    mostrar();
    testPoblacion();
    testConstructorLinea();
    testFusion();
  }
}
