import common.BookCharacter;
import common.SortCorrectnessCheck;
import parallel_bubble_sort.odd_even.ParallelOddEvenBubbleSort;
import simple_bubble_sort.OddEvenBubbleSort;
import simple_bubble_sort.modification.OddEvenSortSplitModification;

public class Main {
    public static void main(String[] args) {
        try {
            defineBestAmountOfThreads();
//            defineBestSplitsValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void defineBestAmountOfThreads() throws InterruptedException {

        final BookCharacter[] arr = BookCharacter.generateRandomArray(100000);


        long start = System.currentTimeMillis();
        final BookCharacter[] sortedArr = new BookCharacter[arr.length];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        final BookCharacter[] regularSortResult = sort.sort(sortedArr, 0, sortedArr.length);
        long end = System.currentTimeMillis();
        final long timeTakenRegular = end - start;
        System.out.println("Time taken for array regular bubble sort: " + timeTakenRegular + "ms");


        final ParallelOddEvenBubbleSort parallelSort = new ParallelOddEvenBubbleSort();
        final BookCharacter[] parallelSortResult = parallelSort.defineFastestThreadsCount(arr);


        System.out.println("Time taken for array regular bubble sort: " + timeTakenRegular + "ms");

        System.out.println("Regular algorithm check passed: " + SortCorrectnessCheck.check(regularSortResult));
    }


    static void defineBestSplitsValue() {
        BookCharacter[] arr = BookCharacter.generateRandomArray(1000);
        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();
        sort.defineBestSplitValue(arr);

    }
}