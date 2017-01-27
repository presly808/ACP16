package homeWeek1.data_structure.implementation;

import homeWeek1.data_structure.exceptions.NoElementFoundException;

import java.util.Iterator;

public class MyLinkedStack implements Iterable {

    private static final int DEFAULT_SIZE = 10;
    private Node top;
    private int size;
    private Node[] array;

    public MyLinkedStack() {
        array = new Node[DEFAULT_SIZE];

    }

    public boolean push(Node node){
        array[size] = node;
        top = node;
        size++;
        return true;
    }

    public int getSize(){
        return size;
    }

    public boolean contains(Node node){
        for (int i = 0; i < size; i++) {
            if (node.value.equals(array[i].value)) {
                return true;
            }
        }
        return false;
    }


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
