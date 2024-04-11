package parallel_bubble_sort;

import common.BookCharacter;

import java.util.concurrent.Callable;

public class Task implements Callable<Boolean> {
    private final BookCharacter[] array;
    private final int firstIndex;

    private final int secondIndex;

    public Task(BookCharacter[] array, int firstIndex, int secondIndex) {
        this.array = array;
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
    }

    @Override
    public Boolean call() {

        BookCharacter temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
        return false;


    }
}