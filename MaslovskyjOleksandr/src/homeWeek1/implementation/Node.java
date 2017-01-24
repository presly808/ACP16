package homeWeek1.implementation;

import java.util.Objects;

/**
 * Created by ubuntu on 23.01.17.
 */
public class Node<E> {

    public E value;
    public Node next;

    public Node(E value, Node next) {
        this.value = value;
        this.next = next;
    }
}
