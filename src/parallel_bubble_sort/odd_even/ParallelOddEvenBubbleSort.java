package parallel_bubble_sort.odd_even;

import common.BookCharacter;
import common.Sort;
import common.SortCorrectnessCheck;

import java.util.Map;


public class ParallelOddEvenBubbleSort extends Sort {

    private final Map<Integer, Integer> optimalAmountOfThreads = Map.of(
            100, 2,
            1000, 3,
            10000, 4,
            20000, 5,
            100000, 8,
            100005, 10
    );
    private int N;
    private int MAX_THREAD = 10;

    public BookCharacter[] sortAlgorithm(BookCharacter[] arr) throws InterruptedException {
        for (Map.Entry<Integer, Integer> entry : optimalAmountOfThreads.entrySet()) {
            if (arr.length <= entry.getKey()) {
                MAX_THREAD = entry.getValue();
                break;
            }
        }
        return algorithm(arr);

    }

    private BookCharacter[] algorithm(BookCharacter[] arr) throws InterruptedException {
        N = arr.length;

        ParallelSort parallelSort = new ParallelSort(arr, 0, N, 100);
        parallelSort.parallelSort(MAX_THREAD);
        return arr;
    }

    public BookCharacter[] defineFastestThreadsCount(BookCharacter[] arr) throws InterruptedException {
        N = arr.length;
        long bestTime = Long.MAX_VALUE;
        int bestAmountOfThreads = 1;
        BookCharacter[] bestArr = new BookCharacter[N];


        for (int j = 2; j < N / 2; j++) {

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