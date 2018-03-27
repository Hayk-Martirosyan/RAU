package list_implementations;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SimpleLinkedList implements List {

    private Node head;
    private Node next;
    private int size;

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
        Node temp = this.head;
        Node nodeToAdd = new Node(o);

        int j = 0;
        for (; j < i && temp.next != null; ++j) {
            temp = temp.next;
        }

        if (j != i) {
            throw new IndexOutOfBoundsException();
        } else {
            nodeToAdd.next = temp.next;
            temp.next = nodeToAdd;
            ++this.size;
        }
    }

    @Override
    public Object remove(int i) {
        Node temp = this.head;

        int j = 0;
        for (; j < i - 1 && temp.next != null; ++j) {
            temp = temp.next;
        }

        if (j != i - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            temp.next = temp.next.next;
            --this.size;
            return temp.next;
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

    class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.next = null;
            this.data = data;
        }
    }
}
