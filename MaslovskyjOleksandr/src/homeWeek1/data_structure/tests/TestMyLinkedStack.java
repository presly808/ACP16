package homeWeek1.data_structure.tests;

import homeWeek1.data_structure.implementation.MyLinkedStack;
import homeWeek1.data_structure.implementation.Node;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestMyLinkedStack {

    private MyLinkedStack myLinkedStack;

    private Node node1;
    private Node node2;
    private Node node3;
    private Node node4;
    private Node node5;
    private Node node6;


    @Before
    public void prepareData(){
        myLinkedStack = new MyLinkedStack();

        node1 = new Node(1, null);
        node2 = new Node(213, null);
        node3 = new Node(34, null);
        node4 = new Node(345, null);
        node5 = new Node("sfsdf", null);
        node6 = new Node("asdfsdf", null);
    }

    @After
    public void clearData(){
        myLinkedStack = null;
    }

    @Test
    public void testPositivePushMethod(){
        myLinkedStack.push(node1);
        myLinkedStack.push(node2);
        myLinkedStack.push(node3);
        myLinkedStack.push(node4);
        myLinkedStack.push(node5);
        myLinkedStack.push(node6);
        Assert.assertEquals(6, myLinkedStack.getSize());
    }

    @Test
    public void testPositiveSizeMethod(){
        myLinkedStack.push(node1);
        myLinkedStack.push(node2);
        myLinkedStack.push(node3);
        myLinkedStack.push(node4);
        Assert.assertEquals(4, myLinkedStack.getSize());
    }

    @Test
    public void testPositiveContainsMethod(){
        myLinkedStack.push(node1);
        myLinkedStack.push(node2);
        myLinkedStack.push(node4);
        myLinkedStack.push(node5);
        Assert.assertTrue(myLinkedStack.contains(node1));
        Assert.assertFalse(myLinkedStack.contains(node3));
    }
}
