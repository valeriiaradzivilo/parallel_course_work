package parallel_bubble_sort;

import common.BookCharacter;
import common.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/// 100 - 6,8 threads
/// 1000 - 18 threads
/// 10000 - 64,75 threads
/// 100000 - 18 threads

public class ParallelOddEvenBubbleSort extends Sort {

    private final int tmp = 0;
    private int N;
    private int MAX_THREAD;

    // Write parallel bubble sort algorithm using threads odd even

    public BookCharacter[] sortAlgorithm(BookCharacter[] arr) throws InterruptedException {
        N = arr.length;
        MAX_THREAD = Math.min(4, N / 2);
        return algorithm(arr);

    }

    private BookCharacter[] algorithm(BookCharacter[] arr) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(MAX_THREAD);

        final BookCharacter[] sortedArr = new BookCharacter[N];
        System.arraycopy(arr, 0, sortedArr, 0, N);

        List<Task> list = new ArrayList<>();
        boolean sortedFlag = false;


        int iteration = 0;

        while (!sortedFlag) {
            sortedFlag = true;

            for (int i = iteration; i < N - 1; i += 2) {
                list.add(new Task(sortedArr, i, i + 1));
            }

            List<Future<Boolean>> futures = executor.invokeAll(list);

            try {
                for (Future<Boolean> future : futures) {
                    if (!future.get()) {
                        sortedFlag = false;
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (iteration == 0) {
                iteration = 1;
            } else {
                iteration = 0;
            }

            list.clear();
        }


        executor.shutdown();


        return sortedArr;
    }


    public BookCharacter[] defineFastestThreadsCount(BookCharacter[] arr) throws InterruptedException {

        N = arr.length;
        long bestTime = Long.MAX_VALUE;
        int bestAmountOfThreads = 0;
        BookCharacter[] bestArr = new BookCharacter[N];


        for (int j = 2; j < N / 2 + 2; j++) {
            if (N >= 10000) {
                j--;
                j *= 2;
            }
            BookCharacter[] sortedArr = new BookCharacter[N];

            System.arraycopy(arr, 0, sortedArr, 0, N);

            System.out.println("Threads: " + j);
            MAX_THREAD = j;

            //count time
            long startTime = System.currentTimeMillis();

            algorithm(sortedArr);

            long endTime = System.currentTimeMillis();
            long duration = (endTime - startTime);
            if (duration < bestTime) {
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