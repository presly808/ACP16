package homeWeek1.collections;

import homeWeek1.exceptions.ElementNotFound;
import homeWeek1.exceptions.InvalidIndex;
import homeWeek1.exceptions.WrongElementFormat;

import java.util.Collection;

public interface MyArrayListInterface<E> {

    void addElement(E e) throws WrongElementFormat;

    void removeElement(int index) throws ElementNotFound;

    E findElement(int index) throws InvalidIndex;
}
