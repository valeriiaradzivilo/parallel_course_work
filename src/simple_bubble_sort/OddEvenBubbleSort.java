package simple_bubble_sort;

import common.BookCharacter;

public class OddEvenBubbleSort {

    public BookCharacter[] sort(BookCharacter[] arr) {
        BookCharacter[] sortedArray = sort(arr, 0, arr.length);
        System.arraycopy(sortedArray, 0, arr, 0, arr.length);
        return sort(sortedArray, 0, sortedArray.length);
    }

    public BookCharacter[] sort(BookCharacter[] arr, int start, int end) {

        boolean isSorted = false; // Initially array is unsorted

        while (!isSorted) {
            isSorted = true;
            BookCharacter temp;

            // Perform Bubble sort on odd indexed element
            for (int i = start + 1; i <= end - 2; i += 2) {
                if (arr[i].getHeight() > arr[i + 1].getHeight()) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isSorted = false;
                }
            }

            // Perform Bubble sort on even indexed element
            for (int i = start; i <= end - 2; i += 2) {
                if (arr[i].getHeight() > arr[i + 1].getHeight()) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isSorted = false;
                }
            }
        }
        return arr;
    }

    public boolean arrayIsSorted(BookCharacter[] arr, int start, int end) {
        boolean changedArray = false;
        boolean isSorted = false; // Initially array is unsorted

        while (!isSorted) {
            isSorted = true;
            BookCharacter temp;

            // Perform Bubble sort on odd indexed element
            for (int i = start + 1; i <= end - 2; i += 2) {
                if (arr[i].getHeight() > arr[i + 1].getHeight()) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isSorted = false;
                    changedArray = true;
                }
            }

            // Perform Bubble sort on even indexed element
            for (int i = start; i <= end - 2; i += 2) {
                if (arr[i].getHeight() > arr[i + 1].getHeight()) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isSorted = false;
                    changedArray = true;
                }
            }
        }
        return changedArray;
    }
}