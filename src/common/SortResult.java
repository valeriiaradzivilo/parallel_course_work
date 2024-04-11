package common;

import java.util.List;

public class SortResult {

    private final List<BookCharacter> sortedData;
    private final long timeElapsed;

    public SortResult(List<BookCharacter> sortedData, long timeElapsed) {

        this.sortedData = sortedData;
        this.timeElapsed = timeElapsed;
    }


    public List<BookCharacter> getSortedData() {
        return sortedData;
    }

    public long getTimeElapsed() {
        return timeElapsed;
    }
}