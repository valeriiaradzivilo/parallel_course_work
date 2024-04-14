package parallel_bubble_sort.odd_even;

import common.BookCharacter;
import common.Sort;


public class ParallelOddEvenBubbleSort extends Sort {
    private int N;

    private final int MAX_THREAD = 4;

    public BookCharacter[] sortAlgorithm(BookCharacter[] arr) {

        return algorithm(arr);

    }

    private BookCharacter[] algorithm(BookCharacter[] arr) {
        N = arr.length;

        ParallelSort parallelSort = new ParallelSort(arr, 0, N);
        parallelSort.parallelSort(MAX_THREAD);
        return arr;
    }


}