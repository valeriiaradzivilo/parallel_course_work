package parallel_bubble_sort.odd_even;

import common.BookCharacter;

import java.util.concurrent.atomic.AtomicBoolean;

public class ParallelOddEvenAction implements Runnable {
    private final BookCharacter[] arr;
    private final int left;


    private final AtomicBoolean sorted;


    public ParallelOddEvenAction(BookCharacter[] arr, int left, AtomicBoolean sorted) {
        this.arr = arr;
        this.left = left;
        this.sorted = sorted;

    }

    private void bubbleSort(BookCharacter[] arr, int i) {
        BookCharacter temp = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = temp;
        sorted.set(false);

    }

    @Override
    public void run() {

        if (arr[left].getHeight() > arr[left + 1].getHeight()) {
            bubbleSort(arr, left);
        }


    }
}