package parallel_bubble_sort;

import common.BookCharacter;
import common.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/// 100 - 2 threads
/// 1000 - 25 threads

public class ParallelOddEvenBubbleSort extends Sort {

    private final int tmp = 0;
    private int N;
    private int MAX_THREAD;

    // Write parallel bubble sort algorithm using threads odd even

    public BookCharacter[] sortAlgorithm(BookCharacter[] arr) throws InterruptedException {
        N = arr.length;
        MAX_THREAD = N / 2 + 1;
        return algorithm(arr);

    }

    private BookCharacter[] algorithm(BookCharacter[] arr) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(MAX_THREAD);

        final BookCharacter[] sortedArr = new BookCharacter[N];
        System.arraycopy(arr, 0, sortedArr, 0, N);

        List<Task> list = new ArrayList<>();
        boolean sortedFlag = false;


        while (!sortedFlag) {
            sortedFlag = true;

            for (int i = 1; i < N - 1; i += 2) {
                if (sortedArr[i].getHeight() > sortedArr[i + 1].getHeight()) {
                    list.add(new Task(sortedArr, i, i + 1));
                    sortedFlag = false;
                }
            }

            for (int i = 0; i < N - 1; i += 2) {
                if (sortedArr[i].getHeight() > sortedArr[i + 1].getHeight()) {
                    list.add(new Task(sortedArr, i, i + 1));
                    sortedFlag = false;
                }
            }


            executor.invokeAll(list);


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


        for (int j = Math.min(25, N / 100); j < N / 2 + 2; j++) {
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
            }

        }
        System.out.println("Result: ");
        System.out.println("Best time: " + bestTime + " with " + bestAmountOfThreads + " threads");
        return bestArr;

    }

}