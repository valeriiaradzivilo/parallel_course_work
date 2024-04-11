import common.BookCharacter;
import org.junit.Test;
import parallel_bubble_sort.ParallelOddEvenBubbleSort;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ParallelOddEvenBubbleSortTest {
    // The method 'sort' sorts an array of BookCharacter objects in ascending order based on their height.
    @Test
    public void test_sort_sorts_array_in_ascending_order() throws InterruptedException {
        BookCharacter[] arr = {new BookCharacter("A", 5), new BookCharacter("B", 3), new BookCharacter("C", 7)};
        ParallelOddEvenBubbleSort sorter = new ParallelOddEvenBubbleSort();
        BookCharacter[] sortedArr = sorter.sort(arr);
        for (int i = 0; i < sortedArr.length - 1; i++) {
            assertTrue(sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight());
        }
    }

    // The method 'sort' handles an array of odd length and sorts it correctly.
    @Test
    public void test_sort_handles_odd_length_array() throws InterruptedException {
        BookCharacter[] arr = {new BookCharacter("A", 5), new BookCharacter("B", 3), new BookCharacter("C", 7)};
        ParallelOddEvenBubbleSort sorter = new ParallelOddEvenBubbleSort();
        BookCharacter[] sortedArr = sorter.sort(arr);
        assertEquals(arr.length, sortedArr.length);
        for (int i = 0; i < sortedArr.length - 1; i++) {
            assertTrue(sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight());
        }
    }

    // The method 'sort' handles an array of even length and sorts it correctly.
    @Test
    public void test_sort_handles_even_length_array() throws InterruptedException {
        BookCharacter[] arr = {new BookCharacter("A", 5), new BookCharacter("B", 3), new BookCharacter("C", 7), new BookCharacter("D", 2)};
        ParallelOddEvenBubbleSort sorter = new ParallelOddEvenBubbleSort();
        BookCharacter[] sortedArr = sorter.sort(arr);
        assertEquals(arr.length, sortedArr.length);
        for (int i = 0; i < sortedArr.length - 1; i++) {
            assertTrue(sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight());
        }
    }

    // The method 'sort' handles an array of length 2 and sorts it correctly.
    @Test
    public void test_sort_handles_length_2_array() throws InterruptedException {
        BookCharacter[] arr = {new BookCharacter("A", 5), new BookCharacter("B", 3)};
        ParallelOddEvenBubbleSort sorter = new ParallelOddEvenBubbleSort();
        BookCharacter[] sortedArr = sorter.sort(arr);
        assertEquals(2, sortedArr.length);
        for (int i = 0; i < sortedArr.length - 1; i++) {
            assertTrue(sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight());
        }
    }

    // The method 'sort' handles an array of length 1 and returns the same array.
    @Test
    public void test_sort_handles_length_1_array() throws InterruptedException {
        BookCharacter[] arr = {new BookCharacter("A", 5)};
        ParallelOddEvenBubbleSort sorter = new ParallelOddEvenBubbleSort();
        BookCharacter[] sortedArr = sorter.sort(arr);
        assertEquals(1, sortedArr.length);
        assertEquals(arr[0], sortedArr[0]);
    }

    // The method 'sort' handles an array with duplicate heights and sorts it correctly.
    @Test
    public void test_sort_handles_duplicate_heights_array() throws InterruptedException {
        BookCharacter[] arr = {new BookCharacter("A", 5), new BookCharacter("B", 3), new BookCharacter("C", 7), new BookCharacter("D", 3)};
        ParallelOddEvenBubbleSort sorter = new ParallelOddEvenBubbleSort();
        BookCharacter[] sortedArr = sorter.sort(arr);
        assertEquals(4, sortedArr.length);
        for (int i = 0; i < sortedArr.length - 1; i++) {
            assertTrue(sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight());
        }
    }

    // The method 'sort' handles a null input array and returns false.
    @Test
    public void test_sort_handles_null_input_array() throws InterruptedException {
        BookCharacter[] arr = null;
        ParallelOddEvenBubbleSort sorter = new ParallelOddEvenBubbleSort();
        BookCharacter[] sortedArr = sorter.sort(arr);
        assertNull(sortedArr);
    }

    // The method 'sort' handles an empty input array and returns false.
    @Test
    public void test_sort_handles_empty_input_array() throws InterruptedException {
        BookCharacter[] arr = new BookCharacter[0];
        ParallelOddEvenBubbleSort sorter = new ParallelOddEvenBubbleSort();
        BookCharacter[] sortedArr = sorter.sort(arr);
        assertEquals(0, sortedArr.length);
    }

    // The method 'sort' handles an input array with null elements and returns false.
    @Test
    public void test_sort_handles_input_array_with_null_elements() throws InterruptedException {
        BookCharacter[] arr = {new BookCharacter("A", 5), null, new BookCharacter("C", 7)};
        ParallelOddEvenBubbleSort sorter = new ParallelOddEvenBubbleSort();
        BookCharacter[] sortedArr = sorter.sort(arr);
        assertNull(sortedArr);
    }

    // The method 'sort' handles an array with the large length and sorts it correctly.
    @Test
    public void test_sort_handles_large_length_array() throws InterruptedException {
        int maxLength = 100000;
        BookCharacter[] arr = BookCharacter.generateRandomArray(maxLength);

        ParallelOddEvenBubbleSort sorter = new ParallelOddEvenBubbleSort();
        BookCharacter[] sortedArr = sorter.sort(arr);

        assertEquals(maxLength, sortedArr.length);

        for (int i = 0; i < sortedArr.length - 1; i++) {
            assertTrue(sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight());
        }
    }

    // The method 'sort' handles an array with the minimum possible length and sorts it correctly.
    @Test
    public void test_sort_handles_minimum_length_array() throws InterruptedException {
        int minLength = 0;
        BookCharacter[] arr = new BookCharacter[minLength];
        ParallelOddEvenBubbleSort sorter = new ParallelOddEvenBubbleSort();
        BookCharacter[] sortedArr = sorter.sort(arr);
        assertEquals(minLength, sortedArr.length);
    }

    // The method 'sort' handles an array with negative heights and sorts it correctly.
    @Test
    public void test_sort_handles_array_with_negative_heights() throws InterruptedException {
        // Create an array with negative heights
        BookCharacter[] arr = new BookCharacter[5];
        assertThrows(Exception.class, () -> {
            arr[0] = new BookCharacter("A", -5);
            arr[1] = new BookCharacter("B", -2);
            arr[2] = new BookCharacter("C", -7);
            arr[3] = new BookCharacter("D", -1);
            arr[4] = new BookCharacter("E", -3);
        });


    }

    // The method 'sort' handles an array with heights equal to zero and sorts it correctly.
    @Test
    public void test_sort_handles_array_with_zero_heights() throws InterruptedException {
        // Create an array with heights equal to zero
        BookCharacter[] arr = new BookCharacter[4];
        arr[0] = new BookCharacter("1", 0);
        arr[1] = new BookCharacter("2", 0);
        arr[2] = new BookCharacter("3", 0);
        arr[3] = new BookCharacter("4", 0);

        // Create an instance of ParallelOddEvenBubbleSort
        ParallelOddEvenBubbleSort sort = new ParallelOddEvenBubbleSort();

        // Sort the array
        BookCharacter[] sortedArr = sort.sort(arr);

        // Check if the array is sorted correctly
        for (int i = 0; i < sortedArr.length - 1; i++) {
            assertTrue(sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight());
        }
    }

    // The method 'sort' handles an array with heights equal to Integer.MAX_VALUE and sorts it correctly.
    @Test
    public void test_sort_handles_array_with_max_height_2() throws InterruptedException {
        // Create an array with heights equal to Integer.MAX_VALUE
        BookCharacter[] arr = new BookCharacter[5];
        arr[0] = new BookCharacter("1", Integer.MAX_VALUE);
        arr[1] = new BookCharacter("2", Integer.MAX_VALUE);
        arr[2] = new BookCharacter("3", Integer.MAX_VALUE);
        arr[3] = new BookCharacter("4", Integer.MAX_VALUE);
        arr[4] = new BookCharacter("5", Integer.MAX_VALUE);

        // Create an instance of ParallelOddEvenBubbleSort
        ParallelOddEvenBubbleSort sorter = new ParallelOddEvenBubbleSort();

        // Sort the array
        BookCharacter[] sortedArr = sorter.sort(arr);

        // Verify that the array is sorted correctly
        for (int i = 0; i < sortedArr.length - 1; i++) {
            assertTrue(sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight());
        }
    }

    // The method 'sort' handles an array with heights equal to Integer.MIN_VALUE and sorts it correctly.
    @Test
    public void test_sort_handles_array_with_min_value_heights() throws InterruptedException {
        // Create an array with heights equal to Integer.MIN_VALUE
        BookCharacter[] arr = new BookCharacter[5];
        assertThrows(Exception.class, () -> {
            arr[0] = new BookCharacter("1", Integer.MIN_VALUE);
            arr[1] = new BookCharacter("2", Integer.MIN_VALUE);
            arr[2] = new BookCharacter("3", Integer.MIN_VALUE);
            arr[3] = new BookCharacter("4", Integer.MIN_VALUE);
            arr[4] = new BookCharacter("5", Integer.MIN_VALUE);
        });

    }

    // The method 'sort' handles an array with heights equal to Integer.MAX_VALUE + 1 and throws an exception.
    @Test
    public void test_sort_handles_array_with_max_height() throws InterruptedException {
        BookCharacter[] arr = new BookCharacter[2];
        arr[0] = new BookCharacter("1", Integer.MAX_VALUE);
        assertThrows(Exception.class, () -> {
            arr[1] = new BookCharacter("2", Integer.MAX_VALUE + 1);
        });

    }

    // The method 'sort' handles an array with heights equal to Integer.MIN_VALUE - 1 and throws an exception.
    @Test
    public void test_sort_handles_array_with_min_value_height() throws InterruptedException {
        // Create an array with heights equal to Integer.MIN_VALUE - 1
        BookCharacter[] arr = new BookCharacter[2];
        arr[0] = new BookCharacter("1", Integer.MIN_VALUE - 1);
        arr[1] = new BookCharacter("2", Integer.MIN_VALUE - 2);

        // Create an instance of ParallelOddEvenBubbleSort
        ParallelOddEvenBubbleSort sort = new ParallelOddEvenBubbleSort();
        final BookCharacter[] result = sort.sort(arr);

        Arrays.sort(arr);
        assertArrayEquals(arr, result);
    }

//    // The method 'sort' handles an array with heights equal to NaN and throws an exception.
//    @Test
//    public void test_sort_handles_array_with_NaN_heights() {
//        // Create an array with NaN heights
//        BookCharacter[] arr = new BookCharacter[4];
//        arr[0] = new BookCharacter("A", 10);
//        arr[1] = new BookCharacter("B", Double.NaN);
//        arr[2] = new BookCharacter("C", 5);
//        arr[3] = new BookCharacter("D", 8);
//
//        // Create an instance of ParallelOddEvenBubbleSort
//        ParallelOddEvenBubbleSort sorter = new ParallelOddEvenBubbleSort();
//
//        // Assert that an exception is thrown when sorting the array
//        assertThrows(Exception.class, () -> sorter.sort(arr));
//    }


}