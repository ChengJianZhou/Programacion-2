public class ArrayListStr {
    private String[] array;
    private int size;

    public ArrayListStr() {
        this.array = new String[10]; // Tamaño inicial del array
        this.size = 0;
    }

    private void ensureCapacity() {
        if (size >= array.length) {
            int newSize = array.length * 2;
            String[] newArray = new String[newSize];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    public void add(String elem) {
        ensureCapacity();
        array[size] = elem;
        size++;
    }

    public void add(int index, String elem) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        ensureCapacity();
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = elem;
        size++;
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        return array[index];
    }

    public int size() {
        return size;
    }

    public void set(int index, String elem) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        array[index] = elem;
    }

    public int indexOf(String elem) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(elem)) {
                return i;
            }
        }
        return -1;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
    }

    public void remove(String elem) {
        int index = indexOf(elem);
        if (index != -1) {
            remove(index);
        }
    }

    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += array[i];
            if (i < size - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }
}
