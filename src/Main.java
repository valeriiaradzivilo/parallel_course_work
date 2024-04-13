import common.BookCharacter;
import parallel_bubble_sort.odd_even.ParallelOddEvenBubbleSort;
import simple_bubble_sort.modification.OddEvenSortSplitModification;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            // count average time for running OddEvenSortSplitModification and ParallelOddEvenBubbleSort
            BookCharacter[] arr = BookCharacter.generateRandomArray(30000);
            ArrayList<Long> regularSortTime = new ArrayList<>();
            ArrayList<Long> parallelSortTime = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                final long startTime = System.currentTimeMillis();
                OddEvenSortSplitModification sortRegular = new OddEvenSortSplitModification();
                sortRegular.sort(arr);
                final long endTime = System.currentTimeMillis();
                regularSortTime.add(endTime - startTime);

                final long startTimeParallel = System.currentTimeMillis();
                ParallelOddEvenBubbleSort parallelSort = new ParallelOddEvenBubbleSort();
                parallelSort.sort(arr);
                final long endTimeParallel = System.currentTimeMillis();
                parallelSortTime.add(endTimeParallel - startTimeParallel);
            }
            long regularSortAverage = regularSortTime.stream().mapToLong(Long::longValue).sum() / regularSortTime.size();
            long parallelSortAverage = parallelSortTime.stream().mapToLong(Long::longValue).sum() / parallelSortTime.size();
            System.out.println("Average time for regular sort: " + regularSortAverage + "ms");
            System.out.println("Average time for parallel sort: " + parallelSortAverage + "ms");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void defineBestAmountOfThreads() throws InterruptedException {

        final BookCharacter[] arr = BookCharacter.generateRandomArray(30000);


        final ParallelOddEvenBubbleSort parallelSort = new ParallelOddEvenBubbleSort();
        parallelSort.defineFastestThreadsCount(arr);


        System.out.println("\n\nRegular sort:");

        OddEvenSortSplitModification sortRegular = new OddEvenSortSplitModification();
        sortRegular.defineBestSplitValue(arr);


    }


}