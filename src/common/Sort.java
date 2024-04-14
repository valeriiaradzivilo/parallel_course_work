package common;

import java.util.Arrays;

public abstract class Sort {

    public BookCharacter[] sort(BookCharacter[] arr)   {
        if (arr == null) {
            System.out.println("The given array is null.");
            return null;
        }
        if (arr.length == 0 || arr.length == 1) {
            System.out.println("The given array is empty.");
            return arr;
        }
        if (Arrays.stream(arr).anyMatch(x -> x == null || x.getId() == null)) {
            System.out.println("The given array contains null elements.");
            return null;
        }

        BookCharacter[] sortedArr = new BookCharacter[arr.length];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
        return sortAlgorithm(sortedArr);
    }


    public void print(BookCharacter[] arr) {
        for (BookCharacter j : arr) {
            System.out.print(j.getHeight() + " ");
        }
    }


    protected abstract BookCharacter[] sortAlgorithm(BookCharacter[] arr);
}