package simple_bubble_sort.modification;

import common.BookCharacter;
import common.Sort;

public class OddEvenSortSplitModification extends Sort {
    @Override
    protected BookCharacter[] sortAlgorithm(BookCharacter[] arr) throws InterruptedException {
        BookCharacter[] sortedArr = new BookCharacter[arr.length];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
        OddEven oddEven = new OddEven(sortedArr, 0, arr.length, sortedArr.length / 4);
        oddEven.sort();
        return sortedArr;
    }


    public void defineBestSplitValue(BookCharacter[] arr) {
        long bestTime = Long.MAX_VALUE;
        int bestSplitValue = 0;
        for (int i = arr.length / 4; i < arr.length; i++) {
            System.out.println("Split value: " + i);
            OddEven oddEven = new OddEven(arr, 0, arr.length, i);
            final long startTime = System.currentTimeMillis();
            oddEven.sort();
            final long endTime = System.currentTimeMillis();

            if ((endTime - startTime) < bestTime) {
                bestTime = endTime - startTime;
                bestSplitValue = i;
                System.out.println("Time taken for split value " + i + " is " + (endTime - startTime) + "ms");
            }
            if (bestTime == 0) {
                break;
            }
        }

        System.out.println("Best split value: " + bestSplitValue);


    }
}