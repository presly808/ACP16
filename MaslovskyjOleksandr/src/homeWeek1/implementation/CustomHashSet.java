package homeWeek1.implementation;

import homeWeek1.exceptions.NoElementFoundException;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class CustomHashSet<E> implements Set<E> {

    private static int DEFAULT_SIZE = 20;

    private Node[] table;
    private int size;
    private Node top;

    public CustomHashSet() {
        this.table = new Node[DEFAULT_SIZE];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        int position = getElementPosition(o);

        if (table[position] == null) {
            return false;
        } else {
            Node iterator = table[position];

            while (iterator.next != null){
                if (iterator.equals(o)) {
                    return true;
                }
                iterator = iterator.next;
            }
        }
        return false;
    }

    public int getElementPosition(Object e){
        int hash = Math.abs(e.hashCode());
        return hash % table.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyHashSetIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        int hashCode = e.hashCode();
        int position = hashCode % table.length;

        if (table[position] == null) {
            table[position] = new Node(e, null);
        } else {

            Node iterator = table[position];
            Node lastPosition = iterator;

            while (iterator != null) {
                if (iterator.equals(e)) {
                    return false;
                }
                lastPosition = iterator;
                iterator = iterator.next;
            }
            lastPosition.next = new Node(e, null);
            top = lastPosition.next;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (contains(o)) {
            int position = getElementPosition(o);
            Node current = table[position];
            current = null;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    public class MyHashSetIterator implements Iterator{

        private Node iterator = top;

        @Override
        public boolean hasNext() {
            return iterator.next != null;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                Node node = iterator;
                iterator = iterator.next;
                return node;
            }
            return new NoElementFoundException();
        }
    }

}
