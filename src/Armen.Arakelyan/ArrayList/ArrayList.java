package ArrayList;

import java.util.Arrays;

public class ArrayList<T> {
    private Object[] values;

    private int size = 0;

    public ArrayList() {
        this.values = new Object[10];
    }

    public ArrayList(int defaultSize) {
        this.values = new Object[defaultSize];
        this.size = defaultSize;
    }

    public void add(T element) {
        ensureCapacity();
        values[size++] = element;
    }

    public T get(int index) {
        if (index < size) {
            return (T) values[index];
        }
        throw new ArrayIndexOutOfBoundsException("Index is out of range: " + index);
    }

    public T remove(int index) {
        T oldValue = (T) values[index];
        int numMoved = size - index - 1;

        if (numMoved > 0) {
            System.arraycopy(values, index + 1, values, index, numMoved);
        }
        values[--size] = null;
        return oldValue;
    }

    private void ensureCapacity() {
        if (size == values.length) {
            values = Arrays.copyOf(values, values.length * 2 + 1);
        }
    }
}
