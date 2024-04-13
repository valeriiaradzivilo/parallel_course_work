package simple_bubble_sort.modification;

import common.BookCharacter;
import simple_bubble_sort.OddEvenBubbleSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
            oddEvenSort(arr, start, end);
            return;
        }
        loop();
    }

    void loop() {
        ArrayList<BookCharacter> sorted = new ArrayList<>(Arrays.asList(arr));
        final int midVal = Collections.max(sorted).getHeight() / 2;

        final ArrayList<BookCharacter> less = new ArrayList<>();
        final ArrayList<BookCharacter> more = new ArrayList<>();

        for (BookCharacter bookCharacter : arr) {
            if (bookCharacter.getHeight() < midVal) {
                less.add(bookCharacter);
            } else {
                more.add(bookCharacter);
            }
        }

        BookCharacter[] newArr = new BookCharacter[arr.length];
        System.arraycopy(less.toArray(), 0, newArr, 0, less.size());
        System.arraycopy(more.toArray(), 0, newArr, less.size(), more.size());

        splitAndSort(newArr);

        System.arraycopy(newArr, 0, arr, 0, newArr.length);

    }

    void splitAndSort(BookCharacter[] arr) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length; i += splitValue) {
                int end = i + splitValue + 1;
                if (end > arr.length) {
                    end = arr.length;
                }
                boolean sortedPart = oddEvenSort(arr, i, end);
                if (sortedPart) isSorted = false;
            }
        }
    }

    boolean oddEvenSort(BookCharacter[] arr, int start, int end) {
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        return sort.arrayIsSorted(arr, start, end);
    }

}