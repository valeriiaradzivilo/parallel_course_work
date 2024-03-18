import org.junit.Test;
import simple_bubble_sort.SimpleBubbleSort;

import static org.junit.Assert.*;


public class SimpleBubbleSortTest {
    // The method should sort an array of integers in ascending order.
    @Test
    public void test_sort_array_in_ascending_order() {
        int[] arr = {5, 2, 8, 1, 9};
        int[] expected = {1, 2, 5, 8, 9};
        int[] result = SimpleBubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, result);
        assertNotSame(arr, result);
    }

    // The method should return a new sorted array and not modify the original array.
    @Test
    public void test_return_new_sorted_array() {
        int[] arr = {3, 6, 2, 9, 4};
        int[] result = SimpleBubbleSort.bubbleSort(arr);
        assertNotSame(arr, result);
    }

    // The method should handle an array with negative integers.
    @Test
    public void test_handle_array_with_negative_integers() {
        int[] arr = {-5, -2, -8, -1, -9};
        int[] expected = {-9, -8, -5, -2, -1};
        int[] result = SimpleBubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, result);
    }

    // The method should handle an array with large integers.
    @Test
    public void test_handle_array_with_large_integers() {
        int[] arr = {1000000, 500000, 2000000, 3000000, 1500000};
        int[] expected = {500000, 1000000, 1500000, 2000000, 3000000};
        int[] result = SimpleBubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, result);
    }

    // The method should handle an empty array and return an empty array.
    @Test
    public void test_emptyArray_returnsEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        int[] result = SimpleBubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, result);
    }

    // The method should handle an array with a single element and return the same array.
    @Test
    public void test_single_element_array() {
        int[] arr = {5};
        int[] expected = {5};
        int[] result = SimpleBubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, result);
    }

    // The method should handle an array with duplicate elements.
    @Test
    public void test_handle_duplicate_elements() {
        int[] arr = {5, 2, 8, 2, 1};
        int[] expected = {1, 2, 2, 5, 8};
        int[] result = SimpleBubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, result);
    }

    // The method should handle an array with both negative and large integers.
    @Test
    public void test_handle_negative_and_large_integers() {
        int[] arr = {-5, 10, -20, 15, 0, 25};
        int[] expected = {-20, -5, 0, 10, 15, 25};
        int[] result = SimpleBubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, result);
    }

    // The method should handle an array with all elements already sorted in ascending order.
    @Test
    public void test_sorted_array() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        int[] result = SimpleBubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, result);
    }

    // The method should handle an array with all elements sorted in descending order.
    @Test
    public void test_sortedArrayDescendingOrder() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        int[] result = SimpleBubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, result);
    }


    // The method should handle null input and throw a NullPointerException.
    @Test
    public void test_handle_null_input() {
        assertThrows(NullPointerException.class, () -> {
            SimpleBubbleSort.bubbleSort(null);
        });
    }

    // The method should handle an array with very large number of elements.
    @Test
    public void test_handle_large_array() {
        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr.length - i;
        }
        int[] sortedArr = SimpleBubbleSort.bubbleSort(arr);
        for (int i = 0; i < sortedArr.length - 1; i++) {
            assertTrue(sortedArr[i] <= sortedArr[i + 1]);
        }
    }

    // The method should handle an array with very small number of elements.
    @Test
    public void test_handle_small_number_of_elements() {
        int[] arr = {5};
        int[] expected = {5};
        int[] result = SimpleBubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, result);
    }

    // The method should handle an array with NaN and Infinity values.
//    @Test
//    public void test_handle_array_with_nan_and_infinity_values() {
//        int[] arr = {1, 2, 3, 4, 5};
//        int[] expected = {1, 2, 3, 4, 5};
//        int[] result = SimpleBubbleSort.bubbleSort(arr);
//        assertArrayEquals(expected, result);
//
//        arr = new int[]{5, 4, 3, 2, 1};
//        expected = new int[]{1, 2, 3, 4, 5};
//        result = SimpleBubbleSort.bubbleSort(arr);
//        assertArrayEquals(expected, result);
//
//        arr = new int[]{3, 1, 4, 2, 5};
//        expected = new int[]{1, 2, 3, 4, 5};
//        result = SimpleBubbleSort.bubbleSort(arr);
//        assertArrayEquals(expected, result);
//
//        arr = new int[]{5, 4, 3, Integer.MAX_VALUE, Integer.MIN_VALUE};
//        expected = new int[]{Integer.MIN_VALUE, 3, 4, 5, Integer.MAX_VALUE};
//        result = SimpleBubbleSort.bubbleSort(arr);
//        assertArrayEquals(expected, result);
//
//        arr = new int[]{5, 4, 3, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE};
//        expected = new int[]{Integer.MIN_VALUE, 3, 4, 5, Integer.MAX_VALUE, Integer.MAX_VALUE};
//        result = SimpleBubbleSort.bubbleSort(arr);
//        assertArrayEquals(expected, result);
//
//        arr = new int[]{5, 4, 3, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE};
//        expected = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, 3, 4, 5, Integer.MAX_VALUE, Integer.MAX_VALUE};
//        result = SimpleBubbleSort.bubbleSort(arr);
//        assertArrayEquals(expected, result);
//
//        arr = new int[]{5, 4, 3, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
//        expected = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, 0, 3, 4, 5, Integer.MAX_VALUE, Integer.MAX_VALUE};
//        result = SimpleBubbleSort.bubbleSort(arr);
//        assertArrayEquals(expected, result);
//
//        arr = new int[]{5, 4, 3, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1};
//        expected = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, -1, 0, 3, 4, 5, Integer.MAX_VALUE, Integer.MAX_VALUE};
//        result = SimpleBubbleSort.bubbleSort(arr);
//        assertArrayEquals(expected, result);
//
//        arr = new int[]{5, 4, 3, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1, -2};
//        expected = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, -2, -1, 0, 3, 4, 5, Integer.MAX_VALUE, Integer.MAX_VALUE};
//        result = SimpleBubbleSort.bubbleSort(arr);
//        assertArrayEquals(expected, result);
//
//        arr = new int[]{5, 4, 3, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1, -2, Integer.MAX_VALUE};
//        expected = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, -2, -1, 0, 3, 4, 5, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
//        result = SimpleBubbleSort.bubbleSort(arr);
//        assertArrayEquals(expected, result);
//
//        arr = new int[]{5, 4, 3, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1, -2, Integer.MAX_VALUE, Integer.MIN_VALUE};
//        expected = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, -2, -1, 0, 3, 4, 5, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
//        result = SimpleBubbleSort.bubbleSort(arr);
//        assertArrayEquals(expected, result);
//
//        arr = new int[]{5, 4, 3, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1, -2, Integer.MAX_VALUE, Integer.MIN_VALUE, 1};
//        expected = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, -2, -1, 0, 1, 3, 4, 5, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
//        result = SimpleBubbleSort.bubbleSort(arr);
//        assertArrayEquals(expected, result);
//
//        arr = new int[]{5, 4, 3, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1, -2, Integer.MAX_VALUE, Integer.MIN_VALUE, 1, 2};
//        expected = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, -2, -1, 0, 1, 2, 3, 4, 5, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
//        result = SimpleBubbleSort.bubbleSort(arr);
//        assertArrayEquals(expected, result);
//
//        arr = new int[]{5, 4, 3, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1, -2, Integer.MAX_VALUE, Integer.MIN_VALUE, 1, 2, 3};
//        expected = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, -2, -1, 0, 1, 2, 3, 3, 4, 5, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
//        result = SimpleBubbleSort.bubbleSort(arr);
//        assertArrayEquals(expected, result);
//
//        arr = new int[]{5, 4, 3, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1, -2, Integer.MAX_VALUE, Integer.MIN_VALUE, 1, 2, 3, 3};
//        expected = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, -2, -1, 0, 1, 2, 3, 3, 3, 4, 5, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
//        result = SimpleBubbleSort.bubbleSort(arr);
//        assertArrayEquals(expected, result);
//
//        arr = new int[]{5, 4, 3, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1, -2, Integer.MAX_VALUE, Integer.MIN_VALUE, 1, 2, 3, 3, 3};
//        expected = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, -2, -1, 0, 1, 2, 3, 3, 3, 3, 4, 5, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
//        result = SimpleBubbleSort.bubbleSort(arr);
//        assertArrayEquals(expected, result);
//
//        arr = new int[]{5, 4, 3, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1, -2, Integer.MAX_VALUE, Integer.MIN_VALUE, 1, 2, 3, 3, 3, 3};
//        expected = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, -2, -1, 0, 1, 2, 3, 3, 3, 3, 3, 4, 5, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
//        result = SimpleBubbleSort.bubbleSort(arr);
//        assertArrayEquals(expected, result);
//
//        arr = new int[]{5, 4, 3, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1, -2, Integer.MAX_VALUE, Integer.MIN_VALUE, 1, 2, 3, 3, 3, 3, 3};
//        expected = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, -2, -1, 0, 1, 2, 3, 3, 3, 3, 3, 3, 4, 5, Integer.MAX_VALUE, Integer.MAX_VALUE};
//        result = SimpleBubbleSort.bubbleSort(arr);
//        assertArrayEquals(expected, result);
//
//        arr = new int[]{5, 4, 3, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1, -2, Integer.MAX_VALUE, Integer.MIN_VALUE, 1, 2, 3, 3, 3, 3, 3, 3};
//        expected = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, -2, -1, 0, 1, 2, 3, 3, 3, 3, 3, 3, 3, 4, 5, Integer.MAX_VALUE, Integer.MAX_VALUE};
//        result = SimpleBubbleSort.bubbleSort(arr);
//        assertArrayEquals(expected, result);
//
//        arr = new int[]{5, 4, 3, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1, -2, Integer.MAX_VALUE, Integer.MIN_VALUE, 1, 2, 3, 3, 3, 3, 3, 3, 3};
//        expected = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, -2, -1, 0, 1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 5, Integer.MAX_VALUE};
//        result = SimpleBubbleSort.bubbleSort(arr);
//        assertArrayEquals(expected, result);
//
//        arr = new int[]{5, 4, 3, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1, -2, Integer.MAX_VALUE, Integer.MIN_VALUE, 1, 2, 3, 3, 3, 3, 3, 3, 3, 3};
//        expected = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, -2, -1, 0, 1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 5, Integer.MAX_VALUE};
//        result = SimpleBubbleSort.bubbleSort(arr);
//        assertArrayEquals(expected, result);
//
//        arr = new int[]{5, 4, 3, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1, -2, Integer.MAX_VALUE, Integer.MIN_VALUE, 1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3};
//        expected = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, -2, -1, 0, 1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 5};
//        result = SimpleBubbleSort.bubbleSort(arr);
//        assertArrayEquals(expected, result);
//
//        arr = new int[]{5, 4, 3, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1, -2, Integer.MAX_VALUE, Integer.MIN_VALUE, 1, 2, 3, 3, 3, 3, 3, 3, 3, 3};
//        expected = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, -2, -1, 0, 1, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4};
//        result = SimpleBubbleSort.bubbleSort(arr);
//        assertArrayEquals(expected, result);
//
//        arr = new int[]{5, 4, 3, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1, -2, Integer.MAX_VALUE, Integer.MIN_VALUE, 1, 2, 3, 3, 3, 3, 3, 3, 3};
//        expected = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, -2, -1, 0, 1, 2, 3, 3, 3, 3,
//
//        };
//    }
}