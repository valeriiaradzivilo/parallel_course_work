import common.BookCharacter;
import parallel_bubble_sort.odd_even.ParallelOddEvenBubbleSort;
import simple_bubble_sort.modification.OddEvenSortSplitModification;

import java.util.ArrayList;

public class Main {

    final static int[] sizes = {10000, 20000, 40000, 80000, 100000};

    public static void main(String[] args) {
        try {
            // count average time for running OddEvenSortSplitModification and ParallelOddEvenBubbleSort

            ArrayList<Long> regularSortTime = new ArrayList<>();
            ArrayList<Long> parallelSortTime = new ArrayList<>();
            for (final int size : sizes) {
                for (int i = 0; i < 10; i++) {
                    BookCharacter[] arr = BookCharacter.generateRandomArray(size);


                    final long startTime = System.currentTimeMillis();
                    OddEvenSortSplitModification sortRegular = new OddEvenSortSplitModification();
                    sortRegular.sort(arr);
                    final long endTime = System.currentTimeMillis();
                    regularSortTime.add(endTime - startTime);
//                System.out.println("Sequential odd-even sort time: " + (endTime - startTime) + "ms for size " + arr.length);

                    final long startTimeParallel = System.currentTimeMillis();
                    ParallelOddEvenBubbleSort parallelSort = new ParallelOddEvenBubbleSort();
                    parallelSort.sort(arr);
                    final long endTimeParallel = System.currentTimeMillis();
                    parallelSortTime.add(endTimeParallel - startTimeParallel);
//                System.out.println("Parallel odd-even sort time: " + (endTimeParallel - startTimeParallel) + "ms for size " + arr.length);
                }
                long regularSortAverage = regularSortTime.stream().mapToLong(Long::longValue).sum() / regularSortTime.size();
                System.out.println("Average time for regular sort: " + regularSortAverage + " ms for size " + size);
                long parallelSortAverage = parallelSortTime.stream().mapToLong(Long::longValue).sum() / parallelSortTime.size();
                System.out.println("Average time for parallel sort: " + parallelSortAverage + " ms for size " + size);
            }
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