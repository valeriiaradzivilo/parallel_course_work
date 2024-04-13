package parallel_bubble_sort.odd_even;

import common.BookCharacter;
import simple_bubble_sort.OddEvenBubbleSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelSort extends RecursiveAction {

    private final int splitValue;
    private final BookCharacter[] arr;
    private final int start;
    private final int end;

    private final int initialLength;

    int THREAD_NUM = 4;

    public ParallelSort(BookCharacter[] arr, int start, int end, int splitValue, int initialLength) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.splitValue = splitValue;
        this.initialLength = initialLength;
    }

    public void parallelSort(int threadNum) {
        if (arr.length < 100) {
            oddEvenSort(0, arr.length);
            return;
        }
        THREAD_NUM = threadNum;
        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_NUM);
        forkJoinPool.invoke(new ParallelSort(arr, start, end, splitValue, initialLength));
    }

    @Override
    public void compute() {
        if (end - start <= 1) {
            return;
        }
        if (end - start < initialLength) {
            oddEvenSort(0, arr.length);
            return;
        }

        final List<BookCharacter> list = new ArrayList<>(Arrays.asList(arr));
        final float maxHeight = list.stream().map(BookCharacter::getHeight).max(Float::compareTo).orElse(0.0f);

        List<BookCharacter[]> parts = new ArrayList<>(arr.length / splitValue);
        for (int i = arr.length / splitValue; i > 0; i--) {
            float maxVal = maxHeight / i;
            if (i == 1) maxVal++;
            final float maxValue = maxVal;
            float minVal = 0;
            if (i != arr.length / splitValue) minVal = maxHeight / (i + 1);
            final float minValue = minVal;
            parts.add(list.stream().filter(bookCharacter -> bookCharacter.getHeight() < maxValue && bookCharacter.getHeight() >= minValue).toArray(BookCharacter[]::new));
        }
        invokeAll(parts.stream().map(bookCharacters -> new ParallelSort(bookCharacters, 0, bookCharacters.length, splitValue, initialLength)).toList());

        List<BookCharacter> sortedList = new ArrayList<>();
        parts.forEach(part -> sortedList.addAll(Arrays.asList(part)));
        BookCharacter[] sortedArray = sortedList.toArray(BookCharacter[]::new);
        System.arraycopy(sortedArray, 0, arr, 0, arr.length);


    }

    private boolean oddEvenSort(int low, int high) {
        final OddEvenBubbleSort sort = new OddEvenBubbleSort();
        return sort.arrayIsChanged(arr, low, high);
    }


}