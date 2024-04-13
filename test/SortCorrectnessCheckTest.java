import common.BookCharacter;
import common.SortCorrectnessCheck;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SortCorrectnessCheckTest {


    // The check method returns true when the input array is already sorted in ascending order.
    @Test
    public void test_sorted_array() {
        BookCharacter[] arr = {new BookCharacter("1", 1), new BookCharacter("2", 2), new BookCharacter("3", 3)};
        boolean result = SortCorrectnessCheck.check(arr);
        assertTrue(result);
    }

    // The check method returns true when the input array has only one element.
    @Test
    public void test_single_element_array() {
        BookCharacter[] arr = {new BookCharacter("1", 1)};
        boolean result = SortCorrectnessCheck.check(arr);
        assertTrue(result);
    }

    // The check method returns true when the input array has multiple elements and is sorted in ascending order.
    @Test
    public void test_multiple_elements_sorted_array() {
        BookCharacter[] arr = {new BookCharacter("1", 1), new BookCharacter("2", 2), new BookCharacter("3", 3)};
        boolean result = SortCorrectnessCheck.check(arr);
        assertTrue(result);
    }

    // The check method returns true when the input array has multiple elements and all elements are equal.
    @Test
    public void test_multiple_elements_equal_array() {
        BookCharacter[] arr = {new BookCharacter("1", 1), new BookCharacter("1", 1), new BookCharacter("1", 1)};
        boolean result = SortCorrectnessCheck.check(arr);
        assertTrue(result);
    }

    // The check method returns true when the input array has multiple elements and some elements are equal.
    @Test
    public void test_multiple_elements_some_equal_array() {
        BookCharacter[] arr = {new BookCharacter("1", 1), new BookCharacter("2", 2), new BookCharacter("1", 1)};
        boolean result = SortCorrectnessCheck.check(arr);
        assertFalse(result);
    }

    // The check method returns false when the input array is sorted in descending order.
    @Test
    public void test_descending_array() {
        BookCharacter[] arr = {new BookCharacter("3", 3), new BookCharacter("2", 2), new BookCharacter("1", 1)};
        boolean result = SortCorrectnessCheck.check(arr);
        assertFalse(result);
    }

    // The check method returns false when the input array has multiple elements and some elements are equal but not adjacent.
    @Test
    public void test_multiple_elements_not_adjacent_equal_array() {
        BookCharacter[] arr = {new BookCharacter("1", 1), new BookCharacter("2", 2), new BookCharacter("1", 1), new BookCharacter("3", 3)};
        boolean result = SortCorrectnessCheck.check(arr);
        assertFalse(result);
    }

    // The check method returns false when the input array has multiple elements and all elements are equal except for one.
    @Test
    public void test_multiple_elements_array() {
        BookCharacter[] arr = {new BookCharacter("1", 1), new BookCharacter("1", 1), new BookCharacter("2", 2)};
        boolean result = SortCorrectnessCheck.check(arr);
        assertTrue(result);
    }

    // The check method returns true when the input array is empty.
    @Test
    public void test_empty_array() {
        BookCharacter[] arr = {};
        boolean result = SortCorrectnessCheck.check(arr);
        assertTrue(result);
    }

    // The check method returns true when the input array has multiple elements and all elements have the same height but different ids.
    @Test
    public void test_multiple_elements_same_height_different_ids_array() {
        BookCharacter[] arr = {new BookCharacter("1", 1), new BookCharacter("2", 1), new BookCharacter("3", 1)};
        boolean result = SortCorrectnessCheck.check(arr);
        assertTrue(result);
    }

    // The check method returns false when the input array has multiple elements and all elements have the same id but different heights.
    @Test
    public void test_multiple_elements_same_id_different_heights_array() {
        BookCharacter[] arr = {new BookCharacter("1", 1), new BookCharacter("1", 2), new BookCharacter("1", 3)};
        boolean result = SortCorrectnessCheck.check(arr);
        assertTrue(result);
    }

    // The check method returns true when the input array has multiple elements and some elements have the same height and id.
    @Test
    public void test_multiple_elements_same_height_and_id_array() {
        BookCharacter[] arr = {new BookCharacter("1", 1), new BookCharacter("2", 2), new BookCharacter("1", 1)};
        boolean result = SortCorrectnessCheck.check(arr);
        assertFalse(result);
    }

}