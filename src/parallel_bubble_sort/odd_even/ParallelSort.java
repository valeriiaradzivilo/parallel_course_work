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
    private final int start;
    private final int end;
    int THREAD_NUM = 5;

    public ParallelSort(BookCharacter[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }


    int getEnd() {
        return end;
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

        List<BookCharacter> sortedList = new ArrayList<>();
        parts.forEach(task -> sortedList.addAll(Arrays.asList(task)));
        BookCharacter[] sortedArray = sortedList.toArray(BookCharacter[]::new);
        System.arraycopy(sortedArray, 0, arr, 0, arr.length);
        ParallelSort[] tasks = new ParallelSort[parts.size()];
        for (int i = 0; i < parts.size(); i++) {
            final int startingPoint = i > 0 ? tasks[i - 1].getEnd() : 0;
            tasks[i] = new ParallelSort(arr, startingPoint, startingPoint + parts.get(i).length);

        }

        pool.invokeAll((Arrays.asList(tasks)));
    }

    @Override
    public Void call() {
        oddEvenSort();
        return null;
    }

    private void oddEvenSort() {
        final OddEvenBubbleSort sort = new OddEvenBubbleSort();
        sort.sort(arr, start, end);
    }
}