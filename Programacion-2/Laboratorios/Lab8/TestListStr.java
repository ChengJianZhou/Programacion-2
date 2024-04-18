public class TestListStr {
  private static final int N = 5;

  private static LinkedListStr crearVacia() {
    return new LinkedListStr();
  }

  public static void main(String[] args) {
    test0(crearVacia());
    test1(crearVacia());
    test2(crearVacia());
    test3(crearVacia());
    test4(crearVacia());
    System.out.println("Todos los tests han pasado, ¡enhorabuena!");
    System.out.println("IMPORTANTE: asegúrate que has utilizado -ea como opción de java");
  }

  private static void test0(LinkedListStr l) {
    System.err.println(l);

    try {
      l.get(1);
      assert false : "Get con índice fuera de rango debería elevar una excepción";
    }
    catch (IndexOutOfBoundsException e) {
    }
    catch (Exception e) {
      assert false : "Get con índice fuera de rango debería elevar una excepción";
    }

    try {
      l.set(1, "Hola");
      assert false : "Set con índice fuera de rango debería elevar una excepción";
    }
    catch (IndexOutOfBoundsException e) {
    }
    catch (Exception e) {
      assert false : "Set con índice fuera de rango debería elevar una excepción";
    }

    try {
      l.remove(1);
      assert false : "Remove con índice fuera de rango debería elevar una excepción";
    }
    catch (IndexOutOfBoundsException e) {
    }
    catch (Exception e) {
      assert false : "Remove con índice fuera de rango debería elevar una excepción";
    }
  }

  private static void test1(LinkedListStr l) {
    System.err.println(l);

    assert l.size() == 0;

    assert l.indexOf("Hola") == -1;

    for (int i = 0; i < N; i++) {
      l.add(l.size(), "D" + i);
    }

    System.err.println(l);

    assert "[D0, D1, D2, D3, D4]"
      .equals(l.toString());

    assert "D3".equals(l.get(3));

    assert l.indexOf("D2") == 2;

    System.err.println(l.indexOf("XXX"));

    assert l.indexOf("XXX") == -1;

    assert l.size() == N;

    assert l.indexOf("NO ESTA EN LA LISTA") == -1;

    l.remove(2);

    l.remove("D3");

    l.add(l.size(), "D4");

    System.err.println(l);

    assert l.indexOf("D4") == 2;

    l.remove("D4");

    assert l.size() == 3 : "Lista: " + l;

    System.err.println(l);
  }

  private static void test2(LinkedListStr l) {
    assert l.size() == 0;

    for (int i = 0; i < N; i++) {
      l.add(0, "X"+i);
    }

    System.err.println(l);

    l.set(3, "TRES");

    assert l.size() == N;

    System.err.println(l);

    assert l.get(3).equals("TRES");

    for (int i = 0; i < N; i++) {
      if (i != 3)
        assert l.get(i).equals("X"+(N-i-1));
    }

    System.err.println(l);
  }

  private static void test3(LinkedListStr l) {
    assert l.size() == 0;

    for (int i = 0; i < N; i++) {
      l.add(l.size(), "M" + i);
    }

    System.err.println(l);

    l.add(N / 2, "MEDIO");

    System.err.println(l);

    assert l.size() == N + 1;

    for (int i = 0; i < N / 2; i++) {
      assert l.get(i).equals("M" + i);
    }

    assert l.get(N / 2).equals("MEDIO");

    for (int i = 1 + N / 2; i < N + 1; i++) {
      assert l.get(i).equals("M" + (i - 1));
    }

    System.err.println(l);
  }

  private static void test4(LinkedListStr l) {
    assert l.size() == 0;

    for (int i = 0; i < N; i++) {
      l.add("M"+i);
    }

    System.err.println(l);

    l.add(N/2, "MEDIO");

    System.err.println(l);

    assert l.size() == N + 1;

    for (int i = 0; i < N/2; i++) {
      assert l.get(i).equals("M"+i);
    }

    assert l.get(N/2).equals("MEDIO");

    for (int i = 1 + N/2 ; i < N + 1; i++) {
      assert l.get(i).equals("M"+(i-1));
    }

    System.err.println(l);
  }
}
