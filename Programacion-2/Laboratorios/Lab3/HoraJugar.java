/** 
 * HoraJugar
 *
 * Pruebas informales de la clase Hora.
 * 
 * @author PII
 */
public class HoraJugar {
  public static void main (String[] args) {   
    Hora h1 = new Hora(11, 28, 0); 
    Hora h2 = new Hora("11:28:00");
    Hora h3 = new Hora(11*3600+28*60);
    Hora ahora = Hora.ahora();

    System.out.println("h1 = " + h1);
    System.out.println("h2 = " + h2);
    System.out.println("h3 = " + h3);
    System.out.println("ahora = " + ahora);

    System.out.println("h1.equals(h2) = " + h1.equals(h2));
    
    //Añade pruebas informales de todos los métodos
    //...   

    Hora doceAm = new Hora("12:00:00");
    System.out.println("Diferencia = " + ahora.diferencia(doceAm));

    Hora hora1 = new Hora(9, 15, 30);
    Hora hora2 = new Hora(9, 15, 30);
    Hora hora3 = new Hora(10, 0, 0);

    System.out.println("Comparación entre horas:");
    System.out.println("Hora 1 es igual a Hora 2: " + hora1.equals(hora2));
    System.out.println("Hora 1 es menor que Hora 3: " + hora1.esMenor(hora3));

    // Prueba de los métodos de cálculo de tiempo
    Hora horaInicial = new Hora(9, 0, 0);
    Hora horaFinal = new Hora(12, 30, 0);


    int segundosTranscurridos = horaFinal.diferencia(horaInicial);
    System.out.println("Tiempo transcurrido entre horas: " + segundosTranscurridos + " segundos.");
  }
}
