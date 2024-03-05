/** 
 * Hora 
 *
 * Representa una hora como hh:mm:ss.
 *
 * @author PII
 */
import java.util.Date;

// Definición de la clase Hora
class Hora {
  private int hh; // horas
  private int mm; // minutos
  private int ss; // segundos
  
  // Constructor que recibe horas, minutos y segundos como parámetros
  public Hora (int hh, int mm, int ss) {
    this.hh = hh;
    this.mm = mm;
    this.ss = ss;
  }
  
  // Constructor que recibe una cadena en formato de hora (HH:MM:SS) como parámetro
  public Hora (String hora) {
    String[] items = hora.split(":");
    hh = Integer.parseInt(items[0]);
    mm = Integer.parseInt(items[1]);
    ss = Integer.parseInt(items[2]);
  }
  
  // Constructor que recibe un número de segundos como parámetro
  public Hora (int segs) { 
    hh = horas(segs);
    mm = minutos(segs);
    ss = segundos(segs);
  }
  
  // Método toString para representar la hora en formato de cadena (HH:MM:SS)
  public String toString () {
    return String.format("%02d:%02d:%02d", hh, mm, ss);
  }
  
  // Método estático que devuelve la hora actual del sistema
  public static Hora ahora () { 
    String[] items = new Date().toString().split(" ");
    String bloqueHora = items[3];
    String[] itemsHora = bloqueHora.split(":");
    int h = Integer.parseInt(itemsHora[0]);
    int m = Integer.parseInt(itemsHora[1]);
    int s = Integer.parseInt(itemsHora[2]);
    return new Hora(h, m, s); 
  }
  
  // Método para verificar si dos objetos Hora son iguales
  public boolean equals (Object o) {
    Hora h = (Hora)o;
    return 
      hh == h.hh && 
      mm == h.mm && 
      ss == h.ss;
  }
  
  // Método para verificar si esta hora es menor que otra hora dada
  public boolean esMenor (Hora h) {
    return 
      (hh < h.hh) ||
      (hh == h.hh && mm < h.mm) ||
      (hh == h.hh && mm == h.mm && ss < h.ss);
  }
  
  // Método para convertir la hora a segundos
  public int aSegundos () {
    return hh * 3600 + mm * 60 + ss; 
  }
  
  // Método para sumar una cantidad de segundos a la hora actual
  public Hora suma (int s) { 
    return new Hora (this.aSegundos() + s);
  }
  
  // Método para obtener la diferencia en segundos entre dos horas
  public int diferencia (Hora h) {  
    return this.aSegundos() - h.aSegundos();
  }
  
  // Métodos getter para obtener las horas, minutos y segundos
  public int horas () {
    return hh;
  }
  
  public int minutos () {
    return mm;
  }
  
  public int segundos () { 
    return ss;
  }
  
  // Métodos privados para calcular horas, minutos y segundos a partir de segundos totales
  private static int horas (int segs) {
    return segs / 3600;
  }
  
  private static int minutos (int segs) {
    return (segs % 3600) / 60;
  }
  
  private static int segundos (int segs) { 
    return (segs % 3600) % 60;
  }    
}