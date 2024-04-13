import common.BookCharacter;
import parallel_bubble_sort.odd_even.ParallelOddEvenBubbleSort;
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

        final BookCharacter[] arr = BookCharacter.generateRandomArray(30000);


        final ParallelOddEvenBubbleSort parallelSort = new ParallelOddEvenBubbleSort();
        parallelSort.defineFastestThreadsCount(arr);


        System.out.println("\n\nRegular sort:");

        OddEvenSortSplitModification sortRegular = new OddEvenSortSplitModification();
        sortRegular.defineBestSplitValue(arr);


    }


}