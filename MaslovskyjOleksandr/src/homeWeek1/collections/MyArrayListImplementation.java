package homeWeek1.collections;


import homeWeek1.exceptions.ElementNotFound;
import homeWeek1.exceptions.InvalidIndex;
import homeWeek1.exceptions.WrongElementFormat;

public class MyArrayListImplementation<E> implements MyArrayListInterface<E>{

    @Override
    public void addElement(E e) throws WrongElementFormat {

    }

    @Override
    public void removeElement(int index) throws ElementNotFound {

    }

    @Override
    public E findElement(int index) throws InvalidIndex {
        return null;
    }
}
