package list_implementations;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SimpleArrayList implements List{

    static final int DEFAULT_SIZE = 20;
    static int increaseCoeff = 2;

    private Object[] array;
    private int size;

    public SimpleArrayList() {
        this.size = 0;
        array = new Object[DEFAULT_SIZE];
    }

    public void increaseSize (int newSize) {
        if (newSize <= this.size) {
            return;
        } else {
            Object[] temp = this.array;
            this.array = new Object[newSize];

            for (int i = 0; i < this.size; ++i) {
                this.array[i] = temp[i];
            }
        }
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int i) {
        return null;
    }

    @Override
    public Object set(int i, Object o) {
        return null;
    }

    @Override
    public void add(int i, Object o) {
        if (this.array.length == this.size) {
            increaseSize(this.size * increaseCoeff);
            increaseCoeff *= 2;
        }

        System.arraycopy(this.array, i, this.array, i + 1, size - i);
        this.array[i] = o;
        ++this.size;
    }

    @Override
    public Object remove(int i) {
        if (i >= this.size) {
            throw new IllegalArgumentException();
        }
        else {
            Object itemToRemove = this.array[i];
            System.arraycopy(this.array, i + 1, this.array, i, this.size - 1 - i);
            --this.size;
            return itemToRemove;
        }
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int i) {
        return null;
    }

    @Override
    public List subList(int i, int i1) {
        return null;
    }

    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection collection) {
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] objects) {
        return new Object[0];
    }
}
