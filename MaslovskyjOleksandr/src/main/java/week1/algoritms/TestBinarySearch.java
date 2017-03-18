package week1.algoritms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestBinarySearch {

    private BinarySearch binarySearch;

    @Before
    public void prepareData(){
        binarySearch = new BinarySearch(generateRandomArray());
    }

    @Test
    public void testBinarySearch(){
        binarySearch.sort(binarySearch.getMas());
        Assert.assertTrue(0 == binarySearch.binarySearchOfIndex(1));
        Assert.assertTrue(101 == binarySearch.binarySearchOfIndex(213123123));
    }

    private int[] generateRandomArray(){
        int[] array = new int[102];
        for (int i = 1; i < array.length - 1; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        array[0] = 0;
        array[101] = 100;
        return array;
    }
}
