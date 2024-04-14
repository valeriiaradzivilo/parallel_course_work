package parallel_bubble_sort.odd_even;

import common.BookCharacter;
import simple_bubble_sort.OddEvenBubbleSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;

public class ParallelSort implements Callable<Void> {

    private final BookCharacter[] arr;
    int THREAD_NUM = 2;

    public ParallelSort(BookCharacter[] arr) {
        this.arr = arr;
    }

    public void parallelSort(int threadNum) {
        if (arr.length < 100) {
            oddEvenSort();
            return;
        }
        THREAD_NUM = threadNum;

        final ForkJoinPool pool = new ForkJoinPool(threadNum);

        final List<BookCharacter> list = new ArrayList<>(Arrays.asList(arr));
        final float maxHeight = list.stream().map(BookCharacter::getHeight).max(Float::compareTo).orElse(0.0f);

        List<BookCharacter[]> parts = new ArrayList<>(threadNum);
        for (int i = threadNum; i > 0; i--) {
            final float maxValue = (i == 1) ? maxHeight / i + 1 : maxHeight / i;
            final float minValue = (i != threadNum) ? maxHeight / (i + 1) : 0;
            parts.add(list.stream().filter(bookCharacter -> bookCharacter.getHeight() < maxValue && bookCharacter.getHeight() >= minValue).toArray(BookCharacter[]::new));
        }
        final List<ParallelSort> tasks = parts.stream().map(ParallelSort::new).toList();
        pool.invokeAll(tasks);
        List<BookCharacter> sortedList = new ArrayList<>();
        tasks.forEach(task -> sortedList.addAll(Arrays.asList(task.arr)));
        BookCharacter[] sortedArray = sortedList.toArray(BookCharacter[]::new);
        System.arraycopy(sortedArray, 0, arr, 0, arr.length);
    }

    @Override
    public Void call() {
        oddEvenSort();
        return null;
    }

    private void oddEvenSort() {
        final OddEvenBubbleSort sort = new OddEvenBubbleSort();
        sort.sort(arr);
    }
}