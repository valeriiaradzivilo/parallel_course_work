package common;

public record TimeArrayResultRecord(long time, BookCharacter[] array) {
    public long getTime() {
        return time;
    }

    public BookCharacter[] getArray() {
        return array;
    }
}