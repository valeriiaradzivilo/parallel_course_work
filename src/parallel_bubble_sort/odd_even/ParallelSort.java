package parallel_bubble_sort.odd_even;

import common.BookCharacter;
import simple_bubble_sort.OddEvenBubbleSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class ParallelSort extends RecursiveAction {


    private final BookCharacter[] arr;


    private final int start;
    private final int end;


    int THREAD_NUM = 4;

    public ParallelSort(BookCharacter[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    public void parallelSort(int threadNum) {
        if (arr.length < 100) {
            oddEvenSort();
            return;
        }
        THREAD_NUM = threadNum;


        final List<BookCharacter> list = new ArrayList<>(Arrays.asList(arr));
        final float maxHeight = list.stream().map(BookCharacter::getHeight).max(Float::compareTo).orElse(0.0f);

        List<BookCharacter[]> parts = new ArrayList<>(threadNum);
        for (int i = threadNum; i > 0; i--) {
            final float maxValue = (i == 1) ? maxHeight / i + 1 : maxHeight / i;
            final float minValue = (i != threadNum) ? maxHeight / (i + 1) : 0;
            parts.add(list.stream().filter(bookCharacter -> bookCharacter.getHeight() < maxValue && bookCharacter.getHeight() >= minValue).toArray(BookCharacter[]::new));
        }
        final List<ParallelSort> tasks = parts.stream().map(bookCharacters -> new ParallelSort(bookCharacters, 0, bookCharacters.length)).toList();
        invokeAll(tasks);
        List<BookCharacter> sortedList = new ArrayList<>();
        parts.forEach(part -> sortedList.addAll(Arrays.asList(part)));
        BookCharacter[] sortedArray = sortedList.toArray(BookCharacter[]::new);
        System.arraycopy(sortedArray, 0, arr, 0, arr.length);
    }

    @Override
    public void compute() {
        oddEvenSort();

    }

    private void oddEvenSort() {
        final OddEvenBubbleSort sort = new OddEvenBubbleSort();
        sort.sort(arr, start, end);
    }


}