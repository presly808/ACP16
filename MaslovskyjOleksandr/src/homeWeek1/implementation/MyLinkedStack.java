package homeWeek1.implementation;

import homeWeek1.exceptions.NoElementFoundException;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedStack implements Iterable {

    private Node top;

    @Override
    public Iterator iterator() {
        return new MyStackIterator();
    }


    public class MyStackIterator implements Iterator{

        private Node iterator = MyLinkedStack.this.top;

        @Override
        public boolean hasNext() {
            return iterator != null;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                Node node = iterator;
                iterator = iterator.next;
                return node;
            }
            return new NoElementFoundException();
        }
    }
}
