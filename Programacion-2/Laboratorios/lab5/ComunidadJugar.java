/**
 * Pruebas informales de Comunidad<br>
 * 
 * @author PII
 */
public class ComunidadJugar {
  public static void prueba1() {
    Comunidad vacia = new Comunidad();
    System.out.println("vacia = " + vacia);   
    System.out.println();
  }
  
  public static void prueba2() {
    LocalidadTest.resetear();
    Comunidad comunidad = new Comunidad();
    comunidad.add(LocalidadTest.loc1);
    comunidad.add(LocalidadTest.loc2);
    comunidad.add(LocalidadTest.loc3);
    System.out.println("comunidad = " + "\n" + comunidad); 
  }
  
  public static void prueba3() {
    Comunidad comunidad = new Comunidad(".\\files\\cam_municipios_poblacion_2022.csv");
    System.out.println("comunidad = " + "\n" + comunidad);   
  }
  
  public static void prueba4() {
    Comunidad comunidad = new Comunidad(".\\files\\cam_municipios_poblacion_2022.csv");
    System.out.println("comunidad = " + "\n" + comunidad.nombresLocalidades());   
  }
  
  public static void main(String[] args)
  {
    // prueba1();
    // prueba2();
    // prueba3();
    // prueba4();
  }
}
