package simple_bubble_sort;

import java.util.Arrays;


public class SimpleBubbleSort {

    public static int[] bubbleSort(int[] arr) {
        int temp;
        boolean swappedFlag;
        final int length = arr.length;
        int[] sortedArr = Arrays.copyOf(arr, length); // Create a copy of the array
        for (int i = 0; i < length - 1; i++) {
            swappedFlag = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (sortedArr[j] > sortedArr[j + 1]) {

                    // Swap sortedArr[j] and sortedArr[j+1]
                    temp = sortedArr[j];
                    sortedArr[j] = sortedArr[j + 1];
                    sortedArr[j + 1] = temp;
                    swappedFlag = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (!swappedFlag)
                break;
        }
        return sortedArr;
    }
}