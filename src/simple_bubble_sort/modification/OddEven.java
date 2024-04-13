package simple_bubble_sort.modification;

import common.BookCharacter;
import simple_bubble_sort.OddEvenBubbleSort;

import java.util.HashMap;
import java.util.Map;

public class OddEven {
    int start;
    int end;

    int splitValue;

    BookCharacter[] arr;


    public OddEven(BookCharacter[] arr, int start, int end, int splitValue) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.splitValue = splitValue;

    }

    void sort() {
        if (arr.length < 100) {
            oddEvenSort(start, end);
            return;
        }
        loop();
    }

    void loop() {

        Map<Integer, Boolean> isSorted = new HashMap<>();
        isSorted.put(0, false);

        while (isSorted.containsValue(false)) {
            for (int i = 0; i < arr.length; i += splitValue) {
                int end = i + splitValue + 1;
                if (end > arr.length) {
                    end = arr.length;
                }
                final boolean arrayChanged = oddEvenSort(i, end);
                isSorted.put(i, !arrayChanged);
            }

        }

    }

    boolean oddEvenSort(int start, int end) {
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        return sort.arrayIsSorted(arr, start, end);
    }

}