package parallel_bubble_sort.odd_even;

import common.BookCharacter;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelSort extends RecursiveAction {

    private static final int THRESHOLD = 100;
    private final BookCharacter[] arr;
    private final int low;
    private final int high;

    public ParallelSort(BookCharacter[] arr, int low, int high) {
        this.arr = arr;
        this.low = low;
        this.high = high;
    }

    public void parallelSort(int threadNum) {
        if (arr.length < 100) {
            oddEvenSort(0, arr.length);
            return;
        }

        ForkJoinPool pool = new ForkJoinPool(threadNum);
        pool.invoke(new ParallelSort(arr, 0, arr.length));
    }

    @Override
    protected void compute() {
        boolean changedArray = true;
        while (changedArray) {
            if (high - low <= THRESHOLD) {
                changedArray = oddEvenSort(low, high);
            } else {
                int mid = low + (high - low) / 2;
                ParallelSort left = new ParallelSort(arr, low, mid + 1);
                ParallelSort right = new ParallelSort(arr, mid, high);
                invokeAll(left, right);
            }
        }
    }

    private boolean oddEvenSort(int low, int high) {
        boolean isSorted = false;
        boolean changedArray = false;
        while (!isSorted) {
            isSorted = true;
            // Perform Bubble Sort on odd indexed element
            for (int i = low; i <= high - 2; i = i + 2) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    swap(arr, i, i + 1);
                    isSorted = false;
                    changedArray = true;
                }
            }
            // Perform Bubble Sort on even indexed element
            for (int i = low + 1; i <= high - 2; i = i + 2) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    swap(arr, i, i + 1);
                    isSorted = false;
                    changedArray = true;
                }
            }
        }
        return changedArray;
    }

    private void swap(BookCharacter[] arr, int i, int j) {
        BookCharacter temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}