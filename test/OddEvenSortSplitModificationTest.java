import common.BookCharacter;
import org.junit.Test;
import simple_bubble_sort.modification.OddEvenSortSplitModification;

import java.util.Arrays;

import static org.junit.Assert.*;

public class OddEvenSortSplitModificationTest {
    // sorts an array of BookCharacter objects using the odd-even sort algorithm
    @Test
    public void test_sorts_array_of_BookCharacter_objects_using_odd_even_sort_algorithm() throws InterruptedException {
        BookCharacter[] arr = BookCharacter.generateRandomArray(10);
        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();
        BookCharacter[] sortedArr = sort.sort(arr);
        Arrays.sort(arr);
        assertArrayEquals(arr, sortedArr);
    }

    // handles null input array by returning null
    @Test
    public void test_handles_null_input_array_by_returning_null() throws InterruptedException {
        BookCharacter[] arr = null;
        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();
        BookCharacter[] sortedArr = sort.sort(arr);
        assertNull(sortedArr);
    }

    // handles empty input array by returning the same array
    @Test
    public void test_handles_empty_input_array_by_returning_same_array() throws InterruptedException {
        BookCharacter[] arr = new BookCharacter[0];
        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();
        BookCharacter[] sortedArr = sort.sort(arr);
        assertSame(arr, sortedArr);
    }

    // handles input array with null elements by returning null
    @Test
    public void test_handles_input_array_with_null_elements_by_returning_null() throws InterruptedException {
        BookCharacter[] arr = new BookCharacter[3];
        arr[0] = new BookCharacter("1", 10);
        arr[1] = null;
        arr[2] = new BookCharacter("3", 20);
        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();
        BookCharacter[] sortedArr = sort.sort(arr);
        assertNull(sortedArr);
    }

    // sorts an input array of length 2
    @Test
    public void test_sorts_input_array_of_length_2() throws InterruptedException {
        BookCharacter[] arr = new BookCharacter[2];
        arr[0] = new BookCharacter("1", 20);
        arr[1] = new BookCharacter("2", 10);
        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();
        BookCharacter[] sortedArr = sort.sort(arr);
        Arrays.sort(arr);
        assertArrayEquals(arr, sortedArr);
    }

    // sorts an input array of length 3
    @Test
    public void test_sorts_input_array_of_length_3() throws InterruptedException {
        BookCharacter[] arr = new BookCharacter[3];
        arr[0] = new BookCharacter("1", 20);
        arr[1] = new BookCharacter("2", 10);
        arr[2] = new BookCharacter("3", 30);
        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();
        BookCharacter[] sortedArr = sort.sort(arr);
        Arrays.sort(arr);
        assertArrayEquals(arr, sortedArr);
    }

    // sorts an input array of length 1
    @Test
    public void test_sorts_input_array_of_length_1() throws InterruptedException {
        BookCharacter[] arr = new BookCharacter[1];
        arr[0] = new BookCharacter("1", 10);
        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();
        BookCharacter[] sortedArr = sort.sort(arr);
        assertArrayEquals(arr, sortedArr);
    }

    // handles input array with elements having null id by returning null
    @Test
    public void test_handles_input_array_with_elements_having_null_id_by_returning_null() throws InterruptedException {
        BookCharacter[] arr = new BookCharacter[2];
        arr[0] = new BookCharacter("1", 10);
        arr[1] = new BookCharacter(null, 20);
        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();
        BookCharacter[] sortedArr = sort.sort(arr);
        assertNull(sortedArr);
    }

    // sorts an input array of length 10
    @Test
    public void test_sorts_input_array_of_length_10() throws InterruptedException {
        BookCharacter[] arr = BookCharacter.generateRandomArray(10);
        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();
        BookCharacter[] sortedArr = sort.sort(arr);
        for (int i = 0; i < sortedArr.length - 1; i++) {
            assert sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight();
        }
    }

    // sorts an input array of length 100
    @Test
    public void test_sorts_input_array_of_length_100() throws InterruptedException {
        BookCharacter[] arr = BookCharacter.generateRandomArray(100);
        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();
        BookCharacter[] sortedArr = sort.sort(arr);
        for (int i = 0; i < sortedArr.length - 1; i++) {
            assert sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight();
        }

    }

    // handles input array with elements having the same height
    @Test
    public void test_handles_input_array_with_elements_having_the_same_height() throws InterruptedException {
        BookCharacter[] arr = new BookCharacter[3];
        arr[0] = new BookCharacter("1", 10);
        arr[1] = new BookCharacter("2", 10);
        arr[2] = new BookCharacter("3", 10);
        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();
        BookCharacter[] sortedArr = sort.sort(arr);
        assertArrayEquals(arr, sortedArr);
    }

    // handles input array with elements having the same id
    @Test
    public void test_handles_input_array_with_same_id() throws InterruptedException {
        // Create an array with elements having the same id
        BookCharacter[] arr = new BookCharacter[200];
        String id = "same_id";
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new BookCharacter(id, (int) (Math.random() * 100));
        }

        // Create an instance of OddEvenSortSplitModification
        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();

        // Sort the array

        final BookCharacter[] sortedArr = sort.sort(arr);


        // Check if the array is sorted
        for (int i = 0; i < sortedArr.length - 1; i++) {
            assertTrue(sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight());
        }
    }

    // handles input array with elements having the same height and id
    @Test
    public void test_handles_input_array_with_same_height_and_id() throws InterruptedException {
        // Create an array with elements having the same height and id
        BookCharacter[] arr = new BookCharacter[5];
        arr[0] = new BookCharacter("1", 10);
        arr[1] = new BookCharacter("2", 10);
        arr[2] = new BookCharacter("3", 10);
        arr[3] = new BookCharacter("4", 10);
        arr[4] = new BookCharacter("5", 10);

        // Create an instance of OddEvenSortSplitModification
        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();

        // Call the sort method
        try {
            BookCharacter[] sortedArr = sort.sort(arr);

            // Assert that the array is sorted in ascending order
            for (int i = 0; i < sortedArr.length - 1; i++) {
                assertTrue(sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight());
            }
        } catch (InterruptedException e) {
            fail("Sorting was interrupted.");
        }
    }

    // handles input array with elements having maximum allowed height
    @Test
    public void test_handles_input_array_with_maximum_height() throws InterruptedException {
        // Create an array with elements having maximum allowed height
        BookCharacter[] arr = new BookCharacter[5];
        arr[0] = new BookCharacter("1", Integer.MAX_VALUE);
        arr[1] = new BookCharacter("2", Integer.MAX_VALUE);
        arr[2] = new BookCharacter("3", Integer.MAX_VALUE);
        arr[3] = new BookCharacter("4", Integer.MAX_VALUE);
        arr[4] = new BookCharacter("5", Integer.MAX_VALUE);

        // Create an instance of OddEvenSortSplitModification
        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();

        // Call the sort method
        try {
            BookCharacter[] sortedArr = sort.sort(arr);

            // Assert that the array is sorted in ascending order
            for (int i = 0; i < sortedArr.length - 1; i++) {
                assertTrue(sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight());
            }
        } catch (InterruptedException e) {
            fail("Sorting was interrupted.");
        }
    }

}