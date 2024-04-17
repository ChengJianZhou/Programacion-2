/**
 * Las instancias de NodoCirculo representan nodos de una cadena
 * enlazada de instancias de círculos.
 *
 * - Una variable de tipo NodoCirculo que sea null representa una cadena vacñia.
 * - Una variable de tipo NodoCirculo con una instancia de NodoCirculo
 *   representa una cadena enlazada con un primer nodo con un circulo
 *   (atributo circulo) y el resto de la cadena representada con el
 *   atributo siguiente.
 */
class NodoCirculo {
  Circulo circulo;
  NodoCirculo siguiente;

  NodoCirculo(Circulo c, NodoCirculo s) {
    circulo = c;
    siguiente = s;
  }
}
