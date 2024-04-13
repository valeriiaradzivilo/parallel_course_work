package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayPartitioner {

    public List<BookCharacter[]> partitionArray(BookCharacter[] arr, int threads) {
        List<BookCharacter[]> partitions = new ArrayList<>();

        // Get Max height
        float maxHeight = Arrays.stream(arr).map(BookCharacter::getHeight).max(Float::compare).orElse(0.0f);

        int start = 0;

        while (threads >= 1) {
            int end = start;
            while (end < arr.length && arr[end].getHeight() < arr.length / threads) {
                end++;
            }
            partitions.add(Arrays.copyOfRange(arr, start, end));
            start = end;
            threads--;
        }

        partitions.add(Arrays.copyOfRange(arr, start, arr.length));

        return partitions;
    }
}