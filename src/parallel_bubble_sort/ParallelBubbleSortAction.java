package parallel_bubble_sort;

import common.BookCharacter;

import java.util.concurrent.RecursiveAction;

public class ParallelBubbleSortAction extends RecursiveAction {
    private final BookCharacter[] arr;
    private final int left;
    private final int right;

    public ParallelBubbleSortAction(BookCharacter[] arr, int left, int right) {
        this.arr = arr;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() {
        if (right - left <= 50) { // Threshold can be tuned for optimal performance
            bubbleSort(arr, left, right);
        } else {
            int mid = left + (right - left) / 2;
            invokeAll(new ParallelBubbleSortAction(arr, left, mid),
                    new ParallelBubbleSortAction(arr, mid + 1, right));
            merge(arr, left, mid, right);
        }
    }

    private void bubbleSort(BookCharacter[] arr, int left, int right) {
        for (int i = left; i < right; i++) {
            for (int j = left; j < right - i + left; j++) {
                if (arr[j].getHeight() > arr[j + 1].getHeight()) {
                    BookCharacter temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private void merge(BookCharacter[] arr, int left, int mid, int right) {
        BookCharacter[] temp = new BookCharacter[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i].getHeight() <= arr[j].getHeight()) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, 0, arr, left, temp.length);
    }
}