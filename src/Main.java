import common.BookCharacter;
import common.SortCorrectnessCheck;
import parallel_bubble_sort.odd_even.ParallelOddEvenBubbleSort;
import simple_bubble_sort.modification.OddEvenSortSplitModification;

public class Main {
    public static void main(String[] args) {
        try {
//            defineBestAmountOfThreads();
            defineBestSplitsValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void defineBestAmountOfThreads() throws InterruptedException {

        final BookCharacter[] arr = BookCharacter.generateRandomArray(100000);


        long start = System.currentTimeMillis();
        final BookCharacter[] sortedArr = new BookCharacter[arr.length];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();
        final BookCharacter[] regularSortResult = sort.sort(sortedArr);
        long end = System.currentTimeMillis();
        final long timeTakenRegular = end - start;
        System.out.println("Time taken for array regular bubble sort: " + timeTakenRegular + "ms");


        final ParallelOddEvenBubbleSort parallelSort = new ParallelOddEvenBubbleSort();
        final BookCharacter[] parallelSortResult = parallelSort.defineFastestThreadsCount(arr);


        System.out.println("Time taken for array regular bubble sort: " + timeTakenRegular + "ms");

        System.out.println("Regular algorithm check passed: " + SortCorrectnessCheck.check(regularSortResult));
    }


    static void defineBestSplitsValue() throws InterruptedException {
        BookCharacter[] arr = BookCharacter.generateRandomArray(100000);

        ParallelOddEvenBubbleSort parallelSort = new ParallelOddEvenBubbleSort();

        parallelSort.defineBestSplitValue(arr);

        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();
        sort.defineBestSplitValue(arr);


    }
    /// Split - Polidovniy  - Parallel
    /// 10000 - 27          - 26
    /// 100000 - 29 за 2283 - 23 за 2245

}