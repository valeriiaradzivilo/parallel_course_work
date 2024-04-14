package for_papers;

import common.BookCharacter;
import org.junit.Test;
import parallel_bubble_sort.odd_even.ParallelOddEvenBubbleSort;

public class ParallelOddEvenSortArraySizeTest {
    @Test
    public void size_10000()   {
        BookCharacter[] arr = BookCharacter.generateRandomArray(10000);

        ParallelOddEvenBubbleSort sort = new ParallelOddEvenBubbleSort();
        final BookCharacter[] sortedArr = sort.sort(arr);

        for (int i = 0; i < sortedArr.length - 1; i++) {
            assert sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight();
        }
    }

    @Test
    public void size_20000()   {
        BookCharacter[] arr = BookCharacter.generateRandomArray(20000);

        ParallelOddEvenBubbleSort sort = new ParallelOddEvenBubbleSort();
        final BookCharacter[] sortedArr = sort.sort(arr);

        for (int i = 0; i < sortedArr.length - 1; i++) {
            assert sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight();
        }
    }

    @Test
    public void size_30000()   {
        BookCharacter[] arr = BookCharacter.generateRandomArray(30000);

        ParallelOddEvenBubbleSort sort = new ParallelOddEvenBubbleSort();
        final BookCharacter[] sortedArr = sort.sort(arr);

        for (int i = 0; i < sortedArr.length - 1; i++) {
            assert sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight();
        }
    }

    @Test
    public void size_40000()   {
        BookCharacter[] arr = BookCharacter.generateRandomArray(40000);

        ParallelOddEvenBubbleSort sort = new ParallelOddEvenBubbleSort();
        final BookCharacter[] sortedArr = sort.sort(arr);

        for (int i = 0; i < sortedArr.length - 1; i++) {
            assert sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight();
        }
    }

    @Test
    public void size_50000()   {
        BookCharacter[] arr = BookCharacter.generateRandomArray(50000);

        ParallelOddEvenBubbleSort sort = new ParallelOddEvenBubbleSort();
        final BookCharacter[] sortedArr = sort.sort(arr);

        for (int i = 0; i < sortedArr.length - 1; i++) {
            assert sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight();
        }
    }

    @Test
    public void size_60000()   {
        BookCharacter[] arr = BookCharacter.generateRandomArray(60000);

        ParallelOddEvenBubbleSort sort = new ParallelOddEvenBubbleSort();
        final BookCharacter[] sortedArr = sort.sort(arr);

        for (int i = 0; i < sortedArr.length - 1; i++) {
            assert sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight();
        }
    }

    @Test
    public void size_70000()   {
        BookCharacter[] arr = BookCharacter.generateRandomArray(70000);

        ParallelOddEvenBubbleSort sort = new ParallelOddEvenBubbleSort();
        final BookCharacter[] sortedArr = sort.sort(arr);

        for (int i = 0; i < sortedArr.length - 1; i++) {
            assert sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight();
        }
    }

    @Test
    public void size_80000()   {
        BookCharacter[] arr = BookCharacter.generateRandomArray(80000);

        ParallelOddEvenBubbleSort sort = new ParallelOddEvenBubbleSort();
        final BookCharacter[] sortedArr = sort.sort(arr);

        for (int i = 0; i < sortedArr.length - 1; i++) {
            assert sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight();
        }
    }

    @Test
    public void size_90000()   {
        BookCharacter[] arr = BookCharacter.generateRandomArray(90000);

        ParallelOddEvenBubbleSort sort = new ParallelOddEvenBubbleSort();
        final BookCharacter[] sortedArr = sort.sort(arr);

        for (int i = 0; i < sortedArr.length - 1; i++) {
            assert sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight();
        }
    }

    @Test
    public void size_100000()   {
        BookCharacter[] arr = BookCharacter.generateRandomArray(100000);

        ParallelOddEvenBubbleSort sort = new ParallelOddEvenBubbleSort();
        final BookCharacter[] sortedArr = sort.sort(arr);

        for (int i = 0; i < sortedArr.length - 1; i++) {
            assert sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight();
        }
    }
}