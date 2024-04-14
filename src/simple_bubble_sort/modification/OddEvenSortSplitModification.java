package simple_bubble_sort.modification;

import common.BookCharacter;
import common.Sort;

public class OddEvenSortSplitModification extends Sort {
    @Override
    protected BookCharacter[] sortAlgorithm(BookCharacter[] arr) {
        BookCharacter[] sortedArr = new BookCharacter[arr.length];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
        OddEven oddEven = new OddEven(sortedArr, 0, arr.length);
        oddEven.sort();
        return sortedArr;
    }


}