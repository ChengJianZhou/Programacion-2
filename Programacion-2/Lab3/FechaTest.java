/** 
 * Algunas pruebas de la clase Fecha.
 * 
 * @author PII
 */
public class FechaTest 
{
  static Fecha f1, f2, f3, f4, f5, f6, f7, f8, f9;
  
  static void resetear () {
    // f1 = new Fecha(0, 6, 1978);   //Destapar y ver qué pasa
    f2 = new Fecha(1, 6, 1978); 
    // f3 = new Fecha(1, 14, 1978);  //Destapar y ver qué pasa
    // f4 = new Fecha(31, 6, 1978);  //Destapar y ver qué pasa
    f5 = new Fecha(31, 1, 2016); 
    f6 = new Fecha(1, 2, 2016); 
    f7 = new Fecha(31, 12, 2016); 
    f8 = new Fecha(1, 1, 2017); 
    f9 = new Fecha("2/2/2016"); 
  }
  
  static boolean testEquals () { 
    boolean test1 = f5.equals(f5) == true;
    boolean test2 = f5.equals(f2) == false;
    boolean test3 = f7.equals(f8) == false;
    boolean test4 = f7.equals("esto no es una fecha") == false;
    return test1 && test2 && test3 && test4;
  }
  
  static boolean testEsMenor () {
    boolean test1 = f5.esMenor(f5) == false;
    boolean test2 = f5.esMenor(f2) == false;
    boolean test3 = f7.esMenor(f8) == true;
    return test1 && test2 && test3;
  }
  
  static boolean testSiguiente () {
    boolean test1 = f6.siguiente().equals(f9);
    boolean test2 = f5.siguiente().equals(f6);
    boolean test3 = f7.siguiente().equals(f8);
    return  test1 && test2 && test3;
  }
  
  static boolean testSuma () {
    boolean test1 = f6.suma(0).equals(f6);
    boolean test2 = f6.suma(1).equals(f9);
    boolean test3 = f7.suma(1).equals(f8);
    return test1 && test2 && test3;
  }
  
  static boolean testDiferencia () {
    boolean test1 = f6.diferencia(f6) == 0;
    boolean test2 = f9.diferencia(f6) == 1;
    boolean test3 = f8.diferencia(f7) == 1;
    return test1 && test2 && test3;
  }
  
  public static void main (String[] args) {   
    resetear(); //Comprobar qué pasa si no se ejecuta esta sentencia.
    System.out.println("testEquals() = " + testEquals());
    System.out.println("testEsMenor() = " + testEsMenor());
    System.out.println("testSiguiente() = " + testSiguiente());  
    System.out.println("testSuma() = " + testSuma());
    System.out.println("testDiferencia() = " + testDiferencia());
  }
}
