import common.BookCharacter;
import org.junit.Test;
import simple_bubble_sort.OddEvenBubbleSort;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class OddEvenBubbleSortTest {
    // The method sorts an array of BookCharacters in ascending order based on their height.
    @Test
    public void test_sorts_array_in_ascending_order() throws InterruptedException {
        BookCharacter[] arr = {new BookCharacter("A", 5), new BookCharacter("B", 3), new BookCharacter("C", 7)};
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        BookCharacter[] sortedArr = sort.sort(arr);
        assertEquals(3, sortedArr[0].getHeight());
        assertEquals(5, sortedArr[1].getHeight());
        assertEquals(7, sortedArr[2].getHeight());
    }

    // The method returns a sorted array of BookCharacters.
    @Test
    public void test_returns_sorted_array() throws InterruptedException {
        BookCharacter[] arr = {new BookCharacter("A", 5), new BookCharacter("B", 3), new BookCharacter("C", 7)};
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        BookCharacter[] sortedArr = sort.sort(arr);
        Arrays.sort(arr);
        assertArrayEquals(arr, sortedArr);
    }

    // The method can sort an array of BookCharacters with duplicate heights.
    @Test
    public void test_sorts_array_with_duplicate_heights() throws InterruptedException {
        BookCharacter[] arr = {new BookCharacter("A", 5), new BookCharacter("B", 3), new BookCharacter("C", 5)};
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        BookCharacter[] sortedArr = sort.sort(arr);
        assertEquals(3, sortedArr[0].getHeight());
        assertEquals(5, sortedArr[1].getHeight());
        assertEquals(5, sortedArr[2].getHeight());
    }

    // The method can sort an array of BookCharacters with negative heights.
    @Test
    public void test_sorts_array_with_negative_heights() throws InterruptedException {
        BookCharacter[] arr = {new BookCharacter("A", -5), new BookCharacter("B", -3), new BookCharacter("C", -7)};
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        BookCharacter[] sortedArr = sort.sort(arr);
        assertEquals(-7, sortedArr[0].getHeight());
        assertEquals(-5, sortedArr[1].getHeight());
        assertEquals(-3, sortedArr[2].getHeight());
    }

    // The method can sort an array of BookCharacters with only one element.
    @Test
    public void test_sorts_array_with_one_element() throws InterruptedException {
        BookCharacter[] arr = {new BookCharacter("A", 5)};
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        BookCharacter[] sortedArr = sort.sort(arr);
        assertEquals(5, sortedArr[0].getHeight());
    }

    // The method can sort an array of BookCharacters with two elements.
    @Test
    public void test_sorts_array_with_two_elements() throws InterruptedException {
        BookCharacter[] arr = {new BookCharacter("A", 5), new BookCharacter("B", 3)};
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        BookCharacter[] sortedArr = sort.sort(arr);
        assertEquals(3, sortedArr[0].getHeight());
        assertEquals(5, sortedArr[1].getHeight());
    }

    // The method can sort an array of BookCharacters with a large number of elements.
    @Test
    public void test_sorts_array_with_large_number_of_elements() throws InterruptedException {
        BookCharacter[] arr = new BookCharacter[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = new BookCharacter("A", i);
        }
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        BookCharacter[] sortedArr = sort.sort(arr);
        for (int i = 0; i < 1000; i++) {
            assertEquals(i, sortedArr[i].getHeight());
        }
    }

    // The method can sort an array of BookCharacters with heights equal to Integer.MAX_VALUE.
    @Test
    public void test_sorts_array_with_max_value_heights() throws InterruptedException {
        BookCharacter[] arr = {new BookCharacter("A", Integer.MAX_VALUE), new BookCharacter("B", Integer.MAX_VALUE - 1), new BookCharacter("C", Integer.MAX_VALUE - 2)};
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        BookCharacter[] sortedArr = sort.sort(arr);
        assertEquals(Integer.MAX_VALUE - 2, sortedArr[0].getHeight());
        assertEquals(Integer.MAX_VALUE - 1, sortedArr[1].getHeight());
        assertEquals(Integer.MAX_VALUE, sortedArr[2].getHeight());
    }

    // The method can sort an array of BookCharacters with heights equal to Integer.MIN_VALUE.
    @Test
    public void test_sorts_array_with_min_value_heights() throws InterruptedException {
        BookCharacter[] arr = {new BookCharacter("A", Integer.MIN_VALUE), new BookCharacter("B", Integer.MIN_VALUE + 1), new BookCharacter("C", Integer.MIN_VALUE + 2)};
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        BookCharacter[] sortedArr = sort.sort(arr);
        assertEquals(Integer.MIN_VALUE, sortedArr[0].getHeight());
        assertEquals(Integer.MIN_VALUE + 1, sortedArr[1].getHeight());
        assertEquals(Integer.MIN_VALUE + 2, sortedArr[2].getHeight());
    }

    // The method can sort an array of BookCharacters with null elements.
    @Test
    public void test_sorts_array_with_null_elements() throws InterruptedException {
        BookCharacter[] arr = {null, new BookCharacter("B", 3), null};
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        BookCharacter[] sortedArr = sort.sort(arr);
        assertNull(sortedArr);
    }

    // The method can sort an empty array of BookCharacters.
    @Test
    public void test_sorts_empty_array() throws InterruptedException {
        BookCharacter[] arr = {};
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        BookCharacter[] sortedArr = sort.sort(arr);
        assertEquals(0, sortedArr.length);
    }

    // The method can sort an array of BookCharacters with three elements.
    @Test
    public void test_sorts_array_with_three_elements() throws InterruptedException {
        BookCharacter[] arr = {new BookCharacter("A", 5), new BookCharacter("B", 3), new BookCharacter("C", 7)};
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        BookCharacter[] sortedArr = sort.sort(arr);
        assertEquals(3, sortedArr[0].getHeight());
        assertEquals(5, sortedArr[1].getHeight());
        assertEquals(7, sortedArr[2].getHeight());
    }

    // The method does not modify the original array of BookCharacters.
    @Test
    public void test_does_not_modify_original_array_with_duplicates() throws InterruptedException {
        BookCharacter[] arr = {new BookCharacter("1", 5), new BookCharacter("2", 3), new BookCharacter("3", 7), new BookCharacter("4", 3)};
        BookCharacter[] originalArr = {new BookCharacter("1", 5), new BookCharacter("2", 3), new BookCharacter("3", 7), new BookCharacter("4", 3)};

        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        BookCharacter[] sortedArr = sort.sort(arr);

        assertArrayEquals(originalArr, arr);

    }

    // The method has a time complexity of O(n^2).
    @Test
    public void test_odd_even_bubble_sort() throws InterruptedException {
        BookCharacter[] arr = new BookCharacter[]{
                new BookCharacter("1", 5),
                new BookCharacter("2", 3),
                new BookCharacter("3", 8),
                new BookCharacter("4", 2),
                new BookCharacter("5", 6)
        };

        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        BookCharacter[] sortedArr = sort.sort(arr);

        for (int i = 0; i < sortedArr.length - 1; i++) {
            assertTrue(sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight());
        }
    }

    // The method can handle arrays of BookCharacters with null ids.
    @Test
    public void test_handle_null_ids() throws InterruptedException {
        BookCharacter[] arr = new BookCharacter[5];
        arr[0] = new BookCharacter(null, 5);
        arr[1] = new BookCharacter("B", 3);
        arr[2] = new BookCharacter(null, 7);
        arr[3] = new BookCharacter("A", 2);
        arr[4] = new BookCharacter("C", 4);

        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        BookCharacter[] sortedArr = sort.sort(arr);

        assertNull(sortedArr);
    }


    @Test
    public void test_handle_large_array() throws InterruptedException {
        int n = 100000;
        Random rand = new Random();
        BookCharacter[] arr = new BookCharacter[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new BookCharacter("Id_" + n, rand.nextInt(n * 100));
        }

        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        BookCharacter[] sortedArr = sort.sort(arr);

        for (int i = 0; i < sortedArr.length - 1; i++) {
            assertTrue(sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight());
        }
    }

}