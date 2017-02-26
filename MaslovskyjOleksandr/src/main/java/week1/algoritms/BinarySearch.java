package week1.algoritms;

import java.util.Arrays;

public class BinarySearch {

    private int[] mas;

    public BinarySearch(int[] mas) {
        this.mas = mas;
    }

    public int binarySearchOfIndex(int element){
        int start = 0;
        int end = mas.length - 1;
        int middle = start + (end - start);

        while (start <= end) {

            if (element < middle) {
                end = (middle - 1) / 2;
            } else if (element > middle) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public void sort(int[] mas){
        Arrays.sort(mas);
    }

    public int[] getMas() {
        return mas;
    }
}
