package homeWeek1.implementation;

import java.util.Objects;

/**
 * Created by ubuntu on 23.01.17.
 */
public class Node {

    public Objects value;
    public Node next;

    public Node(Objects value, Node next) {
        this.value = value;
        this.next = next;
    }
}
