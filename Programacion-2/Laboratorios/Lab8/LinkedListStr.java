public class LinkedListStr {
    private NodoStr head;
    private int size;

    public LinkedListStr() {
        head = null;
        size = 0;
    }

    public NodoStr getNode(int index) {
        NodoStr recorrido = head;
        for (int i = 0; i < index; i++) {
            recorrido = recorrido.siguiente;
        }
        return recorrido;
    }

    public void add(int index, String elem) {
        if (index < 0 || size > index) {
            throw new IndexOutOfBoundsException("Index no válido");
        } else {
            if (size == 0) {
                NodoStr newNodoStr = new NodoStr(elem, head);
                head = newNodoStr;
            } else {
                NodoStr prev = getNode(index - 1);
                NodoStr newNodoStr = new NodoStr(elem, head);
                prev.siguiente = newNodoStr;
            }
            size++;
        }
    }

    public void add(String elem) {
        add(size, elem);
    }

    public String get(int index) {
        return getNode(index).dato;
    }

    public int size() {
        return size;
    }

    public void set(int index, String elem) {
        if (index < 0 || size > index) {
            throw new IndexOutOfBoundsException("Index no válido");
        }

        NodoStr sustituto = getNode(index);
        sustituto.dato = elem;
    }

    public int indexOf(String elem) {
        NodoStr recorrido = head;
        for (int i = 0; recorrido != null; i++) {
            if (recorrido.dato.equals(elem)) {
                return i;
            }
            recorrido = recorrido.siguiente;
        }
        return -1;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        } else {
            if (index == 0) {
                head = head.siguiente;
            } else {
                NodoStr prev = getNode(index - 1);
                prev.siguiente = prev.siguiente.siguiente;
            }
            size--;
        }
    }

    public void remove(String elem) {
        int index = indexOf(elem);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        NodoStr current = head;
        while (current != null) {
            sb.append(current.dato);
            if (current.siguiente != null) {
                sb.append(", ");
            }
            current = current.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        LinkedListStr otherList = (LinkedListStr) o;

        if (size != otherList.size)
            return false;

        NodoStr current = head;
        NodoStr otherCurrent = otherList.head;
        while (current != null) {
            if (!current.dato.equals(otherCurrent.dato))
                return false;
            current = current.siguiente;
            otherCurrent = otherCurrent.siguiente;
        }

        return true;
    }
}