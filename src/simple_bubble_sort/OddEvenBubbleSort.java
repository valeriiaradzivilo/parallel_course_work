package simple_bubble_sort;

import common.BookCharacter;

import java.util.List;

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

    public void sort(List<BookCharacter> list) {

        boolean isSorted = false; // Initially array is unsorted

        while (!isSorted) {
            isSorted = true;
            BookCharacter temp;

            // Perform Bubble sort on odd indexed element
            for (int i = 0; i <= list.size() - 2; i += 2) {
                if (list.get(i).getHeight() > list.get(i + 1).getHeight()) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    isSorted = false;
                }
            }

            // Perform Bubble sort on even indexed element
            for (int i = 1; i <= list.size() - 2; i += 2) {
                if (list.get(i).getHeight() > list.get(i + 1).getHeight()) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    isSorted = false;
                }
            }
        }
    }

    public boolean arrayIsChanged(BookCharacter[] arr, int start, int end) {
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