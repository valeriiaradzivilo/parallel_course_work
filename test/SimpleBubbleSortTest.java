//import org.junit.Test;
//import simple_bubble_sort.SimpleBubbleSort;
//
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//import java.util.Arrays;
//import java.util.Random;
//
//import static org.junit.Assert.*;
//
//public class SimpleBubbleSortTest {
//    // The method 'sort' sorts an array of integers in ascending order.
//    @Test
//    public void test_sort_array_in_ascending_order() {
//        SimpleBubbleSort bubbleSort = new SimpleBubbleSort();
//        int[] arr = {5, 2, 3, 1, 4};
//        int[] sortedArr = bubbleSort.sort(arr);
//        int[] expectedArr = {1, 2, 3, 4, 5};
//        assertArrayEquals(expectedArr, sortedArr);
//    }
//
//    // The method 'sort' correctly sorts an array of integers with duplicate values.
//    @Test
//    public void test_sort_array_with_duplicate_values() {
//        SimpleBubbleSort bubbleSort = new SimpleBubbleSort();
//        int[] arr = {5, 2, 3, 1, 4, 2};
//        int[] sortedArr = bubbleSort.sort(arr);
//        int[] expectedArr = {1, 2, 2, 3, 4, 5};
//        assertArrayEquals(expectedArr, sortedArr);
//    }
//
//    // The method 'sort' correctly sorts an array of integers with negative values.
//    @Test
//    public void test_sort_array_with_negative_values() {
//        SimpleBubbleSort bubbleSort = new SimpleBubbleSort();
//        int[] arr = {5, -2, 3, -1, 4};
//        int[] sortedArr = bubbleSort.sort(arr);
//        int[] expectedArr = {-2, -1, 3, 4, 5};
//        assertArrayEquals(expectedArr, sortedArr);
//    }
//
//    // The method 'sort' correctly sorts an array of integers with a single value.
//    @Test
//    public void test_sort_array_with_single_value() {
//        SimpleBubbleSort bubbleSort = new SimpleBubbleSort();
//        int[] arr = {5};
//        int[] sortedArr = bubbleSort.sort(arr);
//        int[] expectedArr = {5};
//        assertArrayEquals(expectedArr, sortedArr);
//    }
//
//    // The method 'sort' correctly sorts an array of integers with a large number of elements.
//    @Test
//    public void test_sort_array_with_large_number_of_elements() {
//        SimpleBubbleSort bubbleSort = new SimpleBubbleSort();
//        Random rand = new Random();
//        int[] arr = new int[1000000];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = rand.nextInt(10000); // Generate random numbers between 0 and 999
//        }
//
//        // Create a copy of the array and sort it to get the expected result
//        int[] expectedArr = arr.clone();
//        Arrays.sort(expectedArr);
//
//        int[] sortedArr = bubbleSort.sort(arr);
//        assertArrayEquals(expectedArr, sortedArr);
//    }
//
//    // The method 'print' prints an array of integers to the console without errors.
//    @Test
//    public void test_print_array_without_errors() {
//        SimpleBubbleSort bubbleSort = new SimpleBubbleSort();
//        int[] arr = {5, 2, 3, 1, 4};
//        bubbleSort.print(arr);
//        // No assertion needed, just checking for any errors during printing
//    }
//
//    // The method 'sort' correctly sorts an empty array of integers.
//    @Test
//    public void test_sort_empty_array() {
//        SimpleBubbleSort bubbleSort = new SimpleBubbleSort();
//        int[] arr = {};
//        int[] sortedArr = bubbleSort.sort(arr);
//        int[] expectedArr = {};
//        assertArrayEquals(expectedArr, sortedArr);
//    }
//
//    // The method 'sort' correctly sorts an array of integers in descending order.
//    @Test
//    public void test_sort_array_in_descending_order() {
//        SimpleBubbleSort bubbleSort = new SimpleBubbleSort();
//        int[] arr = {5, 4, 3, 2, 1};
//        int[] sortedArr = bubbleSort.sort(arr);
//        int[] expectedArr = {1, 2, 3, 4, 5};
//        assertArrayEquals(expectedArr, sortedArr);
//    }
//
//    // The method 'sort' correctly sorts an array of integers with the same value for all elements.
//    @Test
//    public void test_sort_array_with_same_value() {
//        SimpleBubbleSort bubbleSort = new SimpleBubbleSort();
//        int[] arr = {5, 5, 5, 5, 5};
//        int[] sortedArr = bubbleSort.sort(arr);
//        int[] expectedArr = {5, 5, 5, 5, 5};
//        assertArrayEquals(expectedArr, sortedArr);
//    }
//
//    // The method 'sort' does not modify the original array passed as an argument.
//    @Test
//    public void test_sort_does_not_modify_original_array() {
//        SimpleBubbleSort bubbleSort = new SimpleBubbleSort();
//        int[] arr = {5, 2, 3, 1, 4};
//        int[] sortedArr = bubbleSort.sort(arr);
//        int[] expectedArr = {5, 2, 3, 1, 4};
//        assertNotSame(expectedArr, sortedArr);
//        assertArrayEquals(expectedArr, arr);
//    }
//
//    // The method 'sort' returns an array with the same length as the input array.
//    @Test
//    public void test_sort_returns_array_with_same_length() {
//        SimpleBubbleSort bubbleSort = new SimpleBubbleSort();
//        int[] arr = {5, 2, 3, 1, 4};
//        int[] sortedArr = bubbleSort.sort(arr);
//        assertEquals(arr.length, sortedArr.length);
//    }
//
//    // The method 'sort' handles null input arrays gracefully.
//    @Test
//    public void test_sort_handles_null_input_array() {
//        SimpleBubbleSort bubbleSort = new SimpleBubbleSort();
//        int[] arr = null;
//        int[] sortedArr = bubbleSort.sort(arr);
//        assertNull(sortedArr);
//    }
//
//    // The method 'print' prints an empty array of integers to the console without errors.
//    @Test
//    public void test_print_empty_array() {
//        // Create an instance of SimpleBubbleSort
//        SimpleBubbleSort bubbleSort = new SimpleBubbleSort();
//
//        // Create an empty array
//        int[] arr = {};
//
//        // Redirect System.out to a ByteArrayOutputStream
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//
//        // Call the print method
//        bubbleSort.print(arr);
//
//        // Assert that the output is an empty string
//        assertEquals("", outContent.toString());
//    }
//
//    // The method 'print' prints an array of integers with a single value to the console without errors.
//    @Test
//    public void test_print_single_value() {
//        int[] arr = {5};
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//
//        SimpleBubbleSort simpleBubbleSort = new SimpleBubbleSort();
//        simpleBubbleSort.print(arr);
//
//        assertEquals("5 ", outContent.toString());
//    }
//
//}