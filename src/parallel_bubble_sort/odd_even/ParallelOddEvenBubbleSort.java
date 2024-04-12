package parallel_bubble_sort.odd_even;

import common.BookCharacter;
import common.Sort;
import common.SortCorrectnessCheck;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/// 100 - 3 threads
/// 1000 - 4 threads
/// 10000 - 23 threads
/// 100000 - 8192 threads

public class ParallelOddEvenBubbleSort extends Sort {

    private final int tmp = 0;
    private final Map<Integer, Integer> optimalAmountOfThreads = Map.of(
            100, 2,
            1000, 4,
            10000, 23,
            100000, 8192
    );
    private int N;
    private int MAX_THREAD;

    // Write parallel bubble sort algorithm using threads odd even

    private static void swap(BookCharacter[] arr, int i, int j) {
        BookCharacter temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public BookCharacter[] sortAlgorithm(BookCharacter[] arr) throws InterruptedException {
        N = arr.length;

        for (final Map.Entry<Integer, Integer> i : optimalAmountOfThreads.entrySet()) {
            if (N <= i.getKey()) {
                MAX_THREAD = i.getValue();
                break;
            }

        }

        return algorithm(arr);

    }

    private BookCharacter[] algorithm(BookCharacter[] arr) throws InterruptedException {
        try {
            BookCharacter[] sortedArr = new BookCharacter[N];
            System.arraycopy(arr, 0, sortedArr, 0, N);
            AtomicBoolean isSorted = new AtomicBoolean(false);

            ExecutorService executor = Executors.newFixedThreadPool(MAX_THREAD);

            while (!isSorted.get()) {
                executor.submit(new OddEvenSort(sortedArr, isSorted, 0)).get();
                executor.submit(new OddEvenSort(sortedArr, isSorted, 1)).get();

            }
            executor.shutdown();
            return sortedArr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    public BookCharacter[] defineFastestThreadsCount(BookCharacter[] arr) throws InterruptedException {

        N = arr.length;

        long bestTime = Long.MAX_VALUE;
        int bestAmountOfThreads = 1;
        BookCharacter[] bestArr = new BookCharacter[N];


        for (int j = 2; j < N / 2 + 1; j++) {
            if (N >= 10000 && j > 100) {
                j--;
                j += j / 2;
            }
            BookCharacter[] sortedArr = new BookCharacter[N];

            System.arraycopy(arr, 0, sortedArr, 0, N);

            System.out.println("Threads: " + j);
            MAX_THREAD = j;

            //count time
            long startTime = System.currentTimeMillis();

            final BookCharacter[] result = algorithm(sortedArr);

            long endTime = System.currentTimeMillis();
            long duration = (endTime - startTime);
            final boolean check = SortCorrectnessCheck.check(result);
            if (duration < bestTime && check) {
                System.out.println("Best time: " + duration + " with " + MAX_THREAD + " threads");
                bestTime = duration;
                bestAmountOfThreads = MAX_THREAD;
                System.arraycopy(bestArr, 0, sortedArr, 0, N);
                if (bestTime == 0) {
                    break;
                }
            }

        }
        System.out.println("Result: ");
        System.out.println("Best time: " + bestTime + " ms with " + bestAmountOfThreads + " threads");
        return bestArr;

    }

}