package simple_bubble_sort;

import common.Sort;

public class OddEvenBubbleSort extends Sort {
    public int[] sort(int[] arr) {
        int n = arr.length;
        int[] sortedArr = new int[n]; // Create a new array with the same length
        System.arraycopy(arr, 0, sortedArr, 0, n); // Copy the elements from arr to sortedArr
        boolean isSorted = false; // Initially array is unsorted

        while (!isSorted) {
            isSorted = true;
            int temp = 0;

            // Perform Bubble sort on odd indexed element
            for (int i = 1; i <= n - 2; i += 2) {
                if (sortedArr[i] > sortedArr[i + 1]) {
                    temp = sortedArr[i];
                    sortedArr[i] = sortedArr[i + 1];
                    sortedArr[i + 1] = temp;
                    isSorted = false;
                }
            }

            // Perform Bubble sort on even indexed element
            for (int i = 0; i <= n - 2; i += 2) {
                if (sortedArr[i] > sortedArr[i + 1]) {
                    temp = sortedArr[i];
                    sortedArr[i] = sortedArr[i + 1];
                    sortedArr[i + 1] = temp;
                    isSorted = false;
                }
            }
        }
        return sortedArr;
    }
}