package simple_bubble_sort.modification;

import common.BookCharacter;
import simple_bubble_sort.OddEvenBubbleSort;

import java.util.ArrayList;
import java.util.Arrays;
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

        final List<BookCharacter> list = List.of(arr);
        final int maxHeight = list.stream().map(BookCharacter::getHeight).max(Integer::compareTo).orElse(0);
        List<BookCharacter[]> parts = new ArrayList<>(maxHeight / splitValue);
        for (int i = arr.length / splitValue; i > 0; i--) {
            int maxVal = maxHeight / i;
            if (i == 1) maxVal++;
            final int maxValue = maxVal;
            int minVal = 0;
            if (i != arr.length / splitValue) minVal = maxHeight / (i + 1);
            final int minValue = minVal;
            parts.add(list.stream().filter(bookCharacter -> bookCharacter.getHeight() < maxValue && bookCharacter.getHeight() >= minValue).toArray(BookCharacter[]::new));
        }
        parts.forEach(bookCharacters -> oddEvenSort(bookCharacters, 0, bookCharacters.length));

        List<BookCharacter> sortedList = new ArrayList<>();
        parts.forEach(part -> sortedList.addAll(Arrays.asList(part)));
        BookCharacter[] sortedArray = sortedList.toArray(new BookCharacter[0]);
        System.arraycopy(sortedArray, 0, arr, 0, arr.length);


    }


    BookCharacter[] oddEvenSort(BookCharacter[] arr, int start, int end) {
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        return sort.sort(arr, start, end);
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