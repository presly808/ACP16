package homeWeek1.algoritms;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by ubuntu on 26.01.17.
 */
public class TestBinarySearch {

    private BinarySearch binarySearch;

    @Before
    public void prepareData(){
        binarySearch = new BinarySearch(generateArray());
    }

    @Test
    public void testBinarySearch(){
        binarySearch.sort();
    }

    private int[] generateArray(){
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.random();
        }
        return array;
    }

}
