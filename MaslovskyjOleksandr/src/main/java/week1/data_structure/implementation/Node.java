package week1.data_structure.implementation;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node<?> node = (Node<?>) o;

        if (!value.equals(node.value)) return false;
        return next != null ? next.equals(node.next) : node.next == null;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }
}
