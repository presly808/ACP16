package week1.homeWeek1.data_structure.tests;

import week1.homeWeek1.data_structure.implementation.CustomHashSet;
import week1.homeWeek1.data_structure.implementation.Node;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class TestCustomHashSet {

    private Set emptyCustomHashSet;
    private Node node1;
    private Node node2;
    private Node node3;
    private Node node4;

    @Before
    public void prepareData(){
        emptyCustomHashSet = new CustomHashSet();
        node1 = new Node(1, null);
        node2 = new Node(2, null);
        node3 = new Node(3, null);
        node4 = new Node(4, null);
    }

    @After
    public void clearData(){
        emptyCustomHashSet.clear();
    }

    @Test
    public void testPositiveAddMethod(){
        emptyCustomHashSet.add(node1);
        Assert.assertNotNull(emptyCustomHashSet);

        emptyCustomHashSet.add(node2);
        emptyCustomHashSet.add(node3);
        emptyCustomHashSet.add(node4);

        Assert.assertEquals(4, emptyCustomHashSet.size());
        Assert.assertTrue(emptyCustomHashSet.add(new Node(2, new Node(2, null))));
    }


    //TODO need to think about scenario
    @Test
    public void testNegativeAddMethod(){
        Assert.assertTrue(emptyCustomHashSet.add(new Node(2, new Node("sd", null))));
    }

    //TODO remove method has a bug
    @Test
    public void testPositiveRemoveMethod(){
        emptyCustomHashSet.add(node1);
        emptyCustomHashSet.add(node2);
        emptyCustomHashSet.add(node3);
        emptyCustomHashSet.add(node4);
        emptyCustomHashSet.remove(node3);
        Assert.assertEquals(3, emptyCustomHashSet.size());
    }
}
