package parallel_bubble_sort.odd_even;

import common.BookCharacter;
import simple_bubble_sort.OddEvenBubbleSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        final List<BookCharacter> list = new ArrayList<>(Arrays.asList(arr));
        final int maxHeight = list.stream().map(BookCharacter::getHeight).max(Integer::compareTo).orElse(0);

        List<BookCharacter[]> parts = new ArrayList<>(threadNum);
        for (int i = threadNum; i > 0; i--) {
            int maxVal = maxHeight / i;
            if (i == 1) maxVal++;
            final int maxValue = maxVal;
            int minVal = 0;
            if (i != threadNum) minVal = maxHeight / (i + 1);
            final int minValue = minVal;
            parts.add(list.stream().filter(bookCharacter -> bookCharacter.getHeight() < maxValue && bookCharacter.getHeight() >= minValue).toArray(BookCharacter[]::new));
        }
        invokeAll(parts.stream().map(bookCharacters -> new ParallelSort(bookCharacters, 0, bookCharacters.length, splitValue)).toList());

        List<BookCharacter> sortedList = new ArrayList<>();
        parts.forEach(part -> sortedList.addAll(Arrays.asList(part)));
        BookCharacter[] sortedArray = sortedList.toArray(BookCharacter[]::new);
        System.arraycopy(sortedArray, 0, arr, 0, arr.length);

    }

    @Override
    public void compute() {

        oddEvenSort(0, arr.length);


    }

    private boolean oddEvenSort(int low, int high) {
        final OddEvenBubbleSort sort = new OddEvenBubbleSort();
        return sort.arrayIsChanged(arr, low, high);
    }


}