package parallel_bubble_sort.odd_even;

import common.BookCharacter;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class OddEvenMultithreading extends RecursiveTask<Void> {

    int start, end;
    BookCharacter[] arr;
    AtomicBoolean isSorted;

    public OddEvenMultithreading(int start, int end, BookCharacter[] arr, AtomicBoolean isSorted) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.isSorted = isSorted;
    }

    @Override
    protected Void compute() {
        if (isSorted.get()) return null;

        isSorted.set(true);

        // Handle odd indexed elements
        for (int i = start; i < end; i += 2) {
            if (arr[i].getHeight() > arr[i + 1].getHeight()) {
                BookCharacter temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                isSorted.set(false);
            }
        }

        // Handle even indexed elements
        for (int i = start + 1; i < end; i += 2) {
            if (arr[i].getHeight() > arr[i + 1].getHeight()) {
                BookCharacter temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                isSorted.set(false);
            }
        }


        return null;
    }
}