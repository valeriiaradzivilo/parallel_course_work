package parallel_bubble_sort.odd_even;

import common.BookCharacter;
import simple_bubble_sort.OddEvenBubbleSort;

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
        pool.invoke(new ParallelSort(arr, 0, arr.length, splitValue));

    }

    @Override
    protected void compute() {

        if (end - start <= splitValue) {
            oddEvenSort(start, end);
        } else {
            int mid = start + (end - start) / 2;
            final BookCharacter[] leftArr = new BookCharacter[mid - start];
            final BookCharacter[] rightArr = new BookCharacter[end - mid];
            System.arraycopy(arr, start, leftArr, 0, mid - start);
            System.arraycopy(arr, mid, rightArr, 0, end - mid);
            ParallelSort left = new ParallelSort(leftArr, 0, leftArr.length, splitValue);
            ParallelSort right = new ParallelSort(rightArr, 0, rightArr.length, splitValue);
            invokeAll(left, right);
            merge(left.arr, right.arr);
        }
    }

    private boolean oddEvenSort(int low, int high) {
        final OddEvenBubbleSort sort = new OddEvenBubbleSort();
        return sort.arrayIsChanged(arr, low, high);
    }

    private void merge(BookCharacter[] left, BookCharacter[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].getHeight() <= right[j].getHeight()) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}