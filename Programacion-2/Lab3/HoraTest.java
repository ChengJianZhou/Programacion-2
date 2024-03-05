/** 
 * HoraTest. 
 *
 * Pruebas de la clase Hora.
 * 
 * @author PII
 */
public class HoraTest
{
  static Hora h1, h2, h3, h4, h5, h6, h7, h8;
  
  public static void resetear () {  
    h1 = new Hora(0, 6, 8); 
    h2 = new Hora(1, 6, 19); 
    h3 = new Hora(1, 14, 0); 
    h4 = new Hora(0, 0, 0); 
    h5 = new Hora(3600); 
    h6 = new Hora(3660); 
    h7 = new Hora(3661); 
    h8 = new Hora("7:8:9");
  }
  
  public static void mostrar() {  
    System.out.println("h1 = " + h1);
    System.out.println("h2 = " + h2);
    System.out.println("h3 = " + h3);
    System.out.println("h4 = " + h4);
    System.out.println("h5 = " + h5);
    System.out.println("h6 = " + h6);
    System.out.println("h7 = " + h7);
    System.out.println("h8 = " + h8);
  }
  
  private static void espera1segundo () {
    double ahora = System.currentTimeMillis();
    double dentroDe1Seg = ahora + 1000; 
    while (System.currentTimeMillis() < dentroDe1Seg);
  }
  
  static void testAhora () {
    System.out.println("ahora = " + Hora.ahora());
    espera1segundo();
    System.out.println("ahora (1 seg mas tarde) = " + Hora.ahora());
    for (int i = 1; i <= 3; i+=1) {
      System.out.println("ahora = " + Hora.ahora());
      espera1segundo();
    }
  }
  
  static boolean testEqualsHora () {
    return 
      h6.equals(h7) && h1.equals(h2) && h5.equals(h5);
  }
  
  static boolean testEqualsString () {
    return !h1.equals("esto no es una hora");
  }
  
  static boolean testSuma () {
    return 
      h6.suma(1).equals(h7)    &&
      h1.suma(3611).equals(h2) &&
      h5.suma(0).equals(h5);
  }
  
  static boolean testDiferencia () {
    return 
      h7.diferencia(h6) == 1    &&
      h2.diferencia(h1) == 3611 &&
      h5.diferencia(h5) == 0;
  }
  
  static boolean testEsMenor () {
    return 
      h7.esMenor(h6) && h2.esMenor(h1) && h5.esMenor(h5);
  }
  
  public static void main (String[] args) {   
    resetear();
    //mostrar();
    //testAhora();
    System.out.println("testSuma() = " + testSuma());
    System.out.println("testDiferencia() = " + testDiferencia());
    System.out.println("testEsMenor() = " + testEsMenor());    
    System.out.println("testEqualsHora() = " + testEqualsHora());
    System.out.println("testEqualsString() = " + testEqualsString());
  }
}
