import common.BookCharacter;
import common.SortCorrectnessCheck;
import parallel_bubble_sort.odd_even.ParallelOddEvenBubbleSort;
import simple_bubble_sort.OddEvenBubbleSort;

public class Main {
    public static void main(String[] args) {
        try {
            defineBestAmountOfThreads();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private static void defineBestAmountOfThreads() throws InterruptedException {
        final BookCharacter[] arr = BookCharacter.generateRandomArray(100000);


        final ParallelOddEvenBubbleSort parallelSort = new ParallelOddEvenBubbleSort();
        final BookCharacter[] parallelSortResult = parallelSort.defineFastestThreadsCount(arr);


        long start = System.currentTimeMillis();
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        final BookCharacter[] regularSortResult = sort.sort(arr);
        long end = System.currentTimeMillis();
        final long timeTakenRegular = end - start;
        System.out.println("Time taken for array regular bubble sort: " + timeTakenRegular + "ms");

        System.out.println("Regular algorithm check passed: " + SortCorrectnessCheck.check(regularSortResult));
    }
}