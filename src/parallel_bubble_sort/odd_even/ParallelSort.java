package parallel_bubble_sort.odd_even;

import common.BookCharacter;
import simple_bubble_sort.OddEvenBubbleSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelSort extends RecursiveAction {

    private final int splitValue;
    private final BookCharacter[] arr;
    private final int start;
    private final int end;

    public ParallelSort(BookCharacter[] arr, int start, int end, int splitValue) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.splitValue = splitValue;
    }

    public void parallelSort(int threadNum) {
        if (arr.length < 100) {
            oddEvenSort(0, arr.length);
            return;
        }

        ForkJoinPool pool = new ForkJoinPool(threadNum);
        ArrayList<BookCharacter> sorted = new ArrayList<>(Arrays.asList(arr));
        final int midVal = Collections.max(sorted).getHeight() / 2;

        final ArrayList<BookCharacter> less = new ArrayList<>();
        final ArrayList<BookCharacter> more = new ArrayList<>();

        for (BookCharacter bookCharacter : arr) {
            if (bookCharacter.getHeight() < midVal) {
                less.add(bookCharacter);
            } else {
                more.add(bookCharacter);
            }
        }

        BookCharacter[] newArr = new BookCharacter[arr.length];
        System.arraycopy(less.toArray(), 0, newArr, 0, less.size());
        System.arraycopy(more.toArray(), 0, newArr, less.size(), more.size());

        System.arraycopy(newArr, 0, arr, 0, newArr.length);

        pool.invoke(new ParallelSort(arr, 0, arr.length, splitValue));
    }

    @Override
    protected void compute() {
        boolean changedArray = true;
        while (changedArray) {
            if (end - start <= splitValue) {
                changedArray = oddEvenSort(start, end);
            } else {
                int mid = start + (end - start) / 2;
                ParallelSort left = new ParallelSort(arr, start, mid + 1, splitValue);
                ParallelSort right = new ParallelSort(arr, mid, end, splitValue);
                invokeAll(left, right);
            }
        }

    }

    private boolean oddEvenSort(int low, int high) {
        final OddEvenBubbleSort sort = new OddEvenBubbleSort();
        return sort.arrayIsSorted(arr, low, high);
    }
    
}