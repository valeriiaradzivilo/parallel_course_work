import common.BookCharacter;
import common.TimeArrayResultRecord;
import common.TimeComparisonResultRecord;
import org.junit.Test;
import parallel_bubble_sort.ParallelOddEvenBubbleSort;
import simple_bubble_sort.OddEvenBubbleSort;

import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class SpeedTest {
    @Test
    public void compare_parallel_and_regular_speed_small_array() throws InterruptedException {
        final int N = 100;
        final TimeComparisonResultRecord result = compare_parallel_and_regular_time(N);
        assert result.timeForRegularSort() > result.timeForParallelSort();
    }


    @Test
    public void compare_parallel_and_regular_speed_large_array() throws InterruptedException {
        final int N = 10000;
        final TimeComparisonResultRecord result = compare_parallel_and_regular_time(N);
        assert result.timeForRegularSort() > result.timeForParallelSort();

    }

    private TimeComparisonResultRecord compare_parallel_and_regular_time(int n) throws InterruptedException {
        BookCharacter[] arr = new BookCharacter[n];
        final Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = new BookCharacter("A" + i, rand.nextInt(n));
        }
        final TimeArrayResultRecord regularSortResult = checkRegularSort(arr);
        final TimeArrayResultRecord parallelSortResult = checkParallelSort(arr);

        assertArrayEquals(regularSortResult.array(), parallelSortResult.array());


        return new TimeComparisonResultRecord(regularSortResult.time(), parallelSortResult.time());

    }


    private TimeArrayResultRecord checkRegularSort(BookCharacter[] arr) throws InterruptedException {
        final long start = System.currentTimeMillis();
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        final BookCharacter[] regularSortResult = sort.sort(arr);
        final long end = System.currentTimeMillis();
        final long timeTakenRegular = end - start;
        System.out.println("Time taken for " + arr.length + " array regular bubble sort: " + timeTakenRegular + "ms");

        for (int i = 0; i < regularSortResult.length - 1; i++) {
            assert regularSortResult[i].getHeight() <= regularSortResult[i + 1].getHeight();
        }

        return new TimeArrayResultRecord(timeTakenRegular, regularSortResult);

    }

    private TimeArrayResultRecord checkParallelSort(BookCharacter[] arr) throws InterruptedException {
        ParallelOddEvenBubbleSort parallelSort = new ParallelOddEvenBubbleSort();
        final long start = System.currentTimeMillis();
        final BookCharacter[] parallelSortResult = parallelSort.sort(arr);
        final long end = System.currentTimeMillis();
        final long timeTakenParallel = end - start;
        System.out.println("Time taken for " + arr.length + " array parallel algorithm: " + timeTakenParallel + "ms");


        for (int i = 0; i < parallelSortResult.length - 1; i++) {
            assert parallelSortResult[i].getHeight() <= parallelSortResult[i + 1].getHeight();
        }

        return new TimeArrayResultRecord(timeTakenParallel, parallelSortResult);

    }

}