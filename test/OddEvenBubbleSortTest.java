import common.BookCharacter;
import org.junit.Test;
import simple_bubble_sort.OddEvenBubbleSort;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class OddEvenBubbleSortTest {
    // The method sorts an array of BookCharacters in ascending order based on their height.
    @Test
    public void test_sorts_array_in_ascending_order() {
        BookCharacter[] arr = {new BookCharacter("A", 5), new BookCharacter("B", 3), new BookCharacter("C", 7)};
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        BookCharacter[] sortedArr = sort.sort(arr, 0, arr.length);
        assertSame(3, sortedArr[0].getHeight());
        assertSame(5, sortedArr[1].getHeight());
        assertSame(7, sortedArr[2].getHeight());
    }

    // The method returns a sorted array of BookCharacters.
    @Test
    public void test_returns_sorted_array() {
        BookCharacter[] arr = {new BookCharacter("A", 5), new BookCharacter("B", 3), new BookCharacter("C", 7)};
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        BookCharacter[] sortedArr = sort.sort(arr, 0, arr.length);
        Arrays.sort(arr, 0, arr.length);
        assertArrayEquals(arr, sortedArr);
    }

    // The method can sort an array of BookCharacters with duplicate heights.
    @Test
    public void test_sorts_array_with_duplicate_heights() {
        BookCharacter[] arr = {new BookCharacter("A", 5), new BookCharacter("B", 3), new BookCharacter("C", 5)};
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        BookCharacter[] sortedArr = sort.sort(arr, 0, arr.length);
        assertSame(3, sortedArr[0].getHeight());
        assertSame(5, sortedArr[1].getHeight());
        assertSame(5, sortedArr[2].getHeight());
    }


    // The method can sort an array of BookCharacters with only one element.
    @Test
    public void test_sorts_array_with_one_element() {
        BookCharacter[] arr = {new BookCharacter("A", 5)};
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        BookCharacter[] sortedArr = sort.sort(arr, 0, arr.length);
        assertSame(5, sortedArr[0].getHeight());
    }

    // The method can sort an array of BookCharacters with two elements.
    @Test
    public void test_sorts_array_with_two_elements() {
        BookCharacter[] arr = {new BookCharacter("A", 5), new BookCharacter("B", 3)};
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        BookCharacter[] sortedArr = sort.sort(arr, 0, arr.length);
        assertSame(3, sortedArr[0].getHeight());
        assertSame(5, sortedArr[1].getHeight());
    }

    // The method can sort an array of BookCharacters with a large number of elements.
    @Test
    public void test_sorts_array_with_large_number_of_elements() {
        BookCharacter[] arr = new BookCharacter[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = new BookCharacter("A", i);
        }
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        BookCharacter[] sortedArr = sort.sort(arr, 0, arr.length);
        for (int i = 0; i < arr.length; i++) {
            assertSame(i, sortedArr[i].getHeight());
        }
    }

    // The method can sort an array of BookCharacters with heights equal to Integer.MAX_VALUE.
    @Test
    public void test_sorts_array_with_max_value_heights() {
        BookCharacter[] arr = {new BookCharacter("A", Integer.MAX_VALUE), new BookCharacter("B", Integer.MAX_VALUE - 1), new BookCharacter("C", Integer.MAX_VALUE - 2)};
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        BookCharacter[] sortedArr = sort.sort(arr, 0, arr.length);
        assertSame(Integer.MAX_VALUE - 2, sortedArr[0].getHeight());
        assertSame(Integer.MAX_VALUE - 1, sortedArr[1].getHeight());
        assertSame(Integer.MAX_VALUE, sortedArr[2].getHeight());
    }


    // The method can sort an empty array of BookCharacters.
    @Test
    public void test_sorts_empty_array() {
        BookCharacter[] arr = {};
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        BookCharacter[] sortedArr = sort.sort(arr, 0, arr.length);
        assertEquals(0, sortedArr.length);
    }

    // The method can sort an array of BookCharacters with three elements.
    @Test
    public void test_sorts_array_with_three_elements() {
        BookCharacter[] arr = {new BookCharacter("A", 5), new BookCharacter("B", 3), new BookCharacter("C", 7)};
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        BookCharacter[] sortedArr = sort.sort(arr, 0, arr.length);
        assertSame(3, sortedArr[0].getHeight());
        assertSame(5, sortedArr[1].getHeight());
        assertSame(7, sortedArr[2].getHeight());
    }


    // The method has a time complexity of O(n^2).
    @Test
    public void test_odd_even_bubble_sort() {
        BookCharacter[] arr = new BookCharacter[]{
                new BookCharacter("1", 5),
                new BookCharacter("2", 3),
                new BookCharacter("3", 8),
                new BookCharacter("4", 2),
                new BookCharacter("5", 6)
        };

        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        BookCharacter[] sortedArr = sort.sort(arr, 0, arr.length);

        for (int i = 0; i < sortedArr.length - 1; i++) {
            assertTrue(sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight());
        }
    }


    @Test
    public void test_handle_large_array() {
        int n = 1000;
        Random rand = new Random();
        BookCharacter[] arr = new BookCharacter[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new BookCharacter("Id_" + n, rand.nextInt(n * 100));
        }

        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        BookCharacter[] sortedArr = sort.sort(arr, 0, arr.length);

        for (int i = 0; i < sortedArr.length - 1; i++) {
            assertTrue(sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight());
        }
    }

}