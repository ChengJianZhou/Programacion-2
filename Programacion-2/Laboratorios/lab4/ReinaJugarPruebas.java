/** 
 * Pruebas de ReinaJugar
 * 
 * @author PII
 */
public class ReinaJugarPruebas
{
  public static void testLeer ()
  {
    Tablero tablero = ReinaJugar.leer();
    System.out.println("\n" + tablero);
  }
  public static void testLeerYMarcar ()
  {
    Tablero tablero = ReinaJugar.leer();
    System.out.println("\n" + tablero);
    ReinaJugar.leerYMarcar(tablero);
    System.out.println("\n" + tablero);    
  }
  public static void testPintar ()
  {
    Tablero tablero = ReinaJugar.leer();
    ReinaJugar.leerYMarcar(tablero);
    ReinaJugar.pintar(tablero);     
  }
  public static void testLeerYMarcarGrafico ()
  {
    Tablero tablero = ReinaJugar.leer();
    // System.out.println("\n" + tablero);
    ReinaJugar.leerYMarcar(tablero);
    ReinaJugar.pintar(tablero);     
  }  
  public static void testCuantasAmenazadas ()
  {
    Tablero tablero = ReinaJugar.leer();
    ReinaJugar.leerYMarcar(tablero);
    System.out.println("\n" + tablero);    
    System.out.println("cuantasAmenazadas(tablero) = " + 
                        ReinaJugar.cuantasAmenazadas(tablero));
  }
  public static void testCalculo ()
  {
    System.out.println("calculo(1024, 8) = " + ReinaJugar.calculo(1024, 8));
  }
  public static void testTabla ()
  {
    ReinaJugar.tabla();
  }
  public static void main (String[] args)
  {
    testLeer();
    testLeerYMarcar();
    testPintar();
    testLeerYMarcarGrafico();
    testCuantasAmenazadas();
    testCalculo();
    testTabla();
  }
}
