package parallel_bubble_sort.odd_even;

import common.BookCharacter;

public class OddEvenSort {
    private final Object lock = new Object();
    private final BookCharacter[] array;
    private boolean sorted;


    public OddEvenSort(BookCharacter[] array) {
        this.array = array;
        this.sorted = false;

    }

    public BookCharacter[] sort() throws InterruptedException {
        sorted = false;

        synchronized (lock) {
            while (!sorted) {
                sorted = true;

                sort(0);
                sort(1);
            }
        }

        return array;
    }

    private void sort(int start) throws InterruptedException {
        for (int i = start; i < array.length - 1; i += 2) {
            if (array[i].getHeight() > array[i + 1].getHeight()) {

                swap(array, i, i + 1);
                sorted = false;
            }
        }
    }

    private void swap(BookCharacter[] arr, int i, int j) {
        BookCharacter temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}