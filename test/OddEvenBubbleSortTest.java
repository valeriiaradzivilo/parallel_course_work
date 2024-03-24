import org.junit.Test;
import simple_bubble_sort.OddEvenBubbleSort;

import static org.junit.Assert.*;

public class OddEvenBubbleSortTest {
    // The method 'sort' should correctly sort an array of integers in ascending order.
    @Test
    public void test_sort_ascending_order() {
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        int[] arr = {5, 2, 3, 1, 4};
        int[] expected = {1, 2, 3, 4, 5};
        int[] result = sort.sort(arr);
        assertArrayEquals(expected, result);
    }
    

    // The method 'sort' should correctly sort an array of integers with duplicate values.
    @Test
    public void test_sort_duplicate_values() {
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        int[] arr = {5, 2, 3, 1, 4, 2};
        int[] expected = {1, 2, 2, 3, 4, 5};
        int[] result = sort.sort(arr);
        assertArrayEquals(expected, result);
    }

    // The method 'sort' should correctly sort an array of integers with negative values.
    @Test
    public void test_sort_negative_values() {
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        int[] arr = {5, -2, 3, -1, 4};
        int[] expected = {-2, -1, 3, 4, 5};
        int[] result = sort.sort(arr);
        assertArrayEquals(expected, result);
    }

    // The method 'sort' should correctly sort an array of integers with only one element.
    @Test
    public void test_sort_single_element() {
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        int[] arr = {5};
        int[] expected = {5};
        int[] result = sort.sort(arr);
        assertArrayEquals(expected, result);
    }

    // The method 'sort' should correctly sort an empty array of integers.
    @Test
    public void test_sort_empty_array() {
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        int[] arr = {};
        int[] expected = {};
        int[] result = sort.sort(arr);
        assertArrayEquals(expected, result);
    }

    // The method 'sort' should correctly sort an array of integers with all elements equal.
    @Test
    public void test_sort_all_elements_equal() {
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        int[] arr = {5, 5, 5, 5, 5};
        int[] expected = {5, 5, 5, 5, 5};
        int[] result = sort.sort(arr);
        assertArrayEquals(expected, result);
    }

    // The method 'sort' should correctly sort an array of integers with odd length.
    @Test
    public void test_sort_odd_length() {
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        int[] arr = {5, 2, 3, 1, 4};
        int[] expected = {1, 2, 3, 4, 5};
        int[] result = sort.sort(arr);
        assertArrayEquals(expected, result);
    }

    // The method 'sort' should correctly sort an array of integers with even length.
    @Test
    public void test_sort_even_length() {
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        int[] arr = {5, 2, 3, 1};
        int[] expected = {1, 2, 3, 5};
        int[] result = sort.sort(arr);
        assertArrayEquals(expected, result);
    }

    // The method 'sort' should not modify the original array passed as argument.
    @Test
    public void test_sort_no_modification() {
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        int[] arr = {5, 2, 3, 1, 4};
        int[] expected = {5, 2, 3, 1, 4};
        sort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    // The method 'sort' should return an array with the same length as the original array.
    @Test
    public void test_sort_same_length() {
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        int[] arr = {5, 2, 3, 1, 4};
        int[] result = sort.sort(arr);
        assertEquals(arr.length, result.length);
    }

    // The method 'sort' should handle null input gracefully.
    @Test
    public void test_sort_null_input() {
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        int[] arr = null;
        assertThrows(NullPointerException.class, () -> {
            sort.sort(arr);
        });
    }

    // The method 'sort' should handle input with very large values.
    @Test
    public void test_sort_with_large_values() {
        int[] arr = {1000000, 500000, 100000, 50000, 10000};
        int[] expected = {10000, 50000, 100000, 500000, 1000000};
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        int[] result = sort.sort(arr);
        assertArrayEquals(expected, result);
    }

    // The method 'sort' should handle input with large number of elements.
    @Test
    public void test_sort_large_number_of_elements() {
        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr.length - i;
        }
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        int[] sortedArr = sort.sort(arr);
        for (int i = 0; i < sortedArr.length - 1; i++) {
            assertTrue(sortedArr[i] <= sortedArr[i + 1]);
        }
    }

}