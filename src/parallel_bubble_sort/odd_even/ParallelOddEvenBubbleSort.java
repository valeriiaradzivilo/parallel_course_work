package parallel_bubble_sort.odd_even;

import common.BookCharacter;
import common.Sort;
import common.SortCorrectnessCheck;


public class ParallelOddEvenBubbleSort extends Sort {
    private int N;

    private int MAX_THREAD = 4;

    public BookCharacter[] sortAlgorithm(BookCharacter[] arr) throws InterruptedException {

        return algorithm(arr);

    }

    private BookCharacter[] algorithm(BookCharacter[] arr) throws InterruptedException {
        N = arr.length;

        ParallelSort parallelSort = new ParallelSort(arr);
        parallelSort.parallelSort(MAX_THREAD);
        return arr;
    }

    public BookCharacter[] defineFastestThreadsCount(BookCharacter[] arr) throws InterruptedException {
        N = arr.length;
        long bestTime = Long.MAX_VALUE;
        int bestAmountOfThreads = 1;
        BookCharacter[] bestArr = new BookCharacter[N];


        for (int j = 2; j < 10; j++) {

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
            if (!check)
                throw new InterruptedException("Array is not sorted correctly");

        }
        System.out.println("Result: ");
        System.out.println("Best time: " + bestTime + " ms with " + bestAmountOfThreads + " threads");
        return bestArr;

    }


}