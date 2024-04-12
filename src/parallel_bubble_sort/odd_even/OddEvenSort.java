package parallel_bubble_sort.odd_even;

import common.BookCharacter;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public class OddEvenSort implements Callable<BookCharacter[]> {
    private final Object lock = new Object();
    private final BookCharacter[] array;
    private final AtomicBoolean sorted;

    private final int start;

    public OddEvenSort(BookCharacter[] array, AtomicBoolean sorted, int start) {
        this.array = array;
        this.sorted = sorted;
        this.start = start;

    }

    public BookCharacter[] sort() throws InterruptedException {

        sorted.set(true);
        for (int i = start; i < array.length - 1; i += 2) {
            if (array[i].getHeight() > array[i + 1].getHeight()) {

                swap(array, i, i + 1);
                sorted.set(false);
            }
        }


        return array;
    }


    private void swap(BookCharacter[] arr, int i, int j) {
        BookCharacter temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    @Override
    public BookCharacter[] call() throws Exception {
        return sort();
    }
}