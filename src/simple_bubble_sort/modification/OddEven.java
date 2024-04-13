package simple_bubble_sort.modification;

import common.BookCharacter;
import simple_bubble_sort.OddEvenBubbleSort;

import java.util.ArrayList;
import java.util.List;

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
        splitAndSort(arr);
    }

    void splitAndSort(BookCharacter[] arr) {
        List<BookCharacter[]> parts = new ArrayList<>(2);

        BookCharacter[] leftPart = new BookCharacter[arr.length / 2];
        System.arraycopy(arr, 0, leftPart, 0, arr.length / 2);
        parts.add(leftPart);

        BookCharacter[] rightPart = new BookCharacter[arr.length - arr.length / 2];
        System.arraycopy(arr, arr.length / 2, rightPart, 0, arr.length - arr.length / 2);
        parts.add(rightPart);


        parts.forEach(part -> oddEvenSort(part, 0, part.length));
        merge(parts.get(0), parts.get(1));


    }

    void oddEvenSort(BookCharacter[] arr, int start, int end) {
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        sort.sort(arr, start, end);
    }


    void merge(BookCharacter[] left, BookCharacter[] right) {

        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].getHeight() <= right[j].getHeight()) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }

    }
}