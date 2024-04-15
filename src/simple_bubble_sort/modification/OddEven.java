package simple_bubble_sort.modification;

import common.BookCharacter;
import simple_bubble_sort.OddEvenBubbleSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OddEven {
    int start;
    int end;
    BookCharacter[] arr;
    private int splitValue = 8;

    public OddEven(BookCharacter[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

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
        final Optional<BookCharacter> maxCharacter = list.stream().max((o1, o2) -> (int) (o1.getHeight() - o2.getHeight()));
        final double maxHeight = maxCharacter.map(BookCharacter::getHeight).orElse(0.0f);
        List<BookCharacter[]> parts = new ArrayList<>((int) (maxHeight / splitValue));
        for (int i = arr.length / splitValue; i > 0; i--) {
            float maxVal = (float) (maxHeight / i);
            if (i == 1) maxVal++;
            final float maxValue = maxVal;
            float minVal = 0;
            if (i != arr.length / splitValue) minVal = (float) (maxHeight / (i + 1));
            final float minValue = minVal;
            parts.add(list.stream().filter(bookCharacter -> bookCharacter.getHeight() < maxValue && bookCharacter.getHeight() >= minValue).toArray(BookCharacter[]::new));
        }
        List<BookCharacter[]> sorted = new ArrayList<>();

        parts.forEach(bookCharacters -> sorted.add(oddEvenSort(bookCharacters, 0, bookCharacters.length)));

        List<BookCharacter> sortedList = new ArrayList<>();
        sorted.forEach(part -> sortedList.addAll(Arrays.asList(part)));
        BookCharacter[] sortedArray = sortedList.toArray(BookCharacter[]::new);
        System.arraycopy(sortedArray, 0, arr, 0, arr.length);
    }


    BookCharacter[] oddEvenSort(BookCharacter[] arr, int start, int end) {
        OddEvenBubbleSort sort = new OddEvenBubbleSort();
        return sort.sort(arr, start, end);
    }


}