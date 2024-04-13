import common.BookCharacter;
import common.TimeArrayResultRecord;
import org.junit.Test;
import parallel_bubble_sort.odd_even.ParallelOddEvenBubbleSort;
import simple_bubble_sort.OddEvenBubbleSort;
import simple_bubble_sort.modification.OddEvenSortSplitModification;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;

public class SpeedTest {

    @Test
    public void compare_parallel_and_regular_speed_20000_array() throws InterruptedException {
        final int N = 20000;
        compare_parallel_and_regular_time(N);

    }


    @Test
    public void compare_parallel_and_regular_speed_50000_array() throws InterruptedException {
        final int N = 50000;
        compare_parallel_and_regular_time(N);


    }

    @Test
    public void compare_parallel_and_regular_speed_100000_array() throws InterruptedException {
        final int N = 100000;
        compare_parallel_and_regular_time(N);


    }

    @Test
    public void compare_parallel_and_regular_speed_200000_array() throws InterruptedException {
        final int N = 200000;
        compare_parallel_and_regular_time(N);


    }

    private void compare_parallel_and_regular_time(int n) throws InterruptedException {
        BookCharacter[] arr = new BookCharacter[n];
        final Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = new BookCharacter("A" + i, rand.nextInt(n));
        }

        final TimeArrayResultRecord regularSortResult = checkRegularSortWithSplitModification(arr);
        assertFalse(Arrays.equals(arr, regularSortResult.array()));

        final TimeArrayResultRecord parallelSortResult = checkParallelSort(arr);
        assertFalse(Arrays.equals(arr, parallelSortResult.array()));

        for (int i = 0; i < parallelSortResult.array().length - 1; i++) {
            assert parallelSortResult.array()[i].getHeight() <= parallelSortResult.array()[i + 1].getHeight();
        }

//        final TimeArrayResultRecord regSortResult = checkRegularSort(arr);
//        assertFalse(Arrays.equals(arr, regSortResult.array()));


        assertArrayEquals(regularSortResult.array(), parallelSortResult.array());
//        assertArrayEquals(regularSortResult.array(), regSortResult.array());


        assert regularSortResult.time() >= parallelSortResult.time();
//        assert regSortResult.time() >= parallelSortResult.time();

    }


    private TimeArrayResultRecord checkRegularSortWithSplitModification(BookCharacter[] arr) throws InterruptedException {
        final long start = System.currentTimeMillis();
        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();
        final BookCharacter[] regularSortResult = sort.sort(arr);
        final long end = System.currentTimeMillis();
        final long timeTakenRegular = end - start;
        System.out.println("Time taken for " + arr.length + " array regular with modifications bubble sort: " + timeTakenRegular + "ms");

        for (int i = 0; i < regularSortResult.length - 1; i++) {
            assert regularSortResult[i].getHeight() <= regularSortResult[i + 1].getHeight();
        }

        return new TimeArrayResultRecord(timeTakenRegular, regularSortResult);

    }

    private TimeArrayResultRecord checkRegularSort(BookCharacter[] arr) {
        BookCharacter[] arrCopy = new BookCharacter[arr.length];
        System.arraycopy(arr, 0, arrCopy, 0, arr.length);

        final long start = System.currentTimeMillis();
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        final BookCharacter[] regularSortResult = sort.sort(arrCopy);
        final long end = System.currentTimeMillis();
        final long timeTakenRegular = end - start;
        System.out.println("Time taken for " + arrCopy.length + " array regular bubble sort: " + timeTakenRegular + "ms");

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