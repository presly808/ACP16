package homeWeek1.implementation;

import homeWeek1.exceptions.NoElementFoundException;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class CustomHashSet<E> implements Set<E> {

    private static final int DEFAULT_SIZE = 20;

    private Node[] table;
    private int size;

    public CustomHashSet() {
        this.table = (Node[]) new Object[DEFAULT_SIZE];
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

            while (iterator != null){
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
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (contains(o)) {
            int position = getElementPosition(o);
            Node current = table[position];

            if (position == 0 && current.equals(o)) {
                current = null;
                return true;
            }

            Node before = null;
            Node after = null;
            while (!current.equals(o)){
                before = current;
                current = current.next;

                if (current.next != null) {
                    after = current.next;
                } else {
                    after = null;
                }
            }
            before.next = after;
            return true;
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

        private int iterator = CustomHashSet.this.table.length;

        @Override
        public boolean hasNext() {
            return table[iterator + 1 ] == null;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                Node node = table[iterator];
                table[iterator] = table[iterator + 1];
                return node;
            }
            return new NoElementFoundException();
        }
    }

}
