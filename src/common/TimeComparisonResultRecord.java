package common;

public record TimeComparisonResultRecord(long timeForRegularSort, long timeForParallelSort) {
    public long getTimeForRegularSort() {
        return timeForRegularSort;
    }

    public long getTimeForParallelSort() {
        return timeForParallelSort;
    }
}