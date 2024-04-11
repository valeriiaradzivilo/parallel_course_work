package common;

import java.util.UUID;

public class BookCharacter implements Comparable {
    private final String id;

    private final int height;

    public BookCharacter(String id, int height) {
        this.id = id;
        if (height < 0)
            throw new IllegalArgumentException("Height cannot be negative");
        this.height = height;
    }

    public static BookCharacter[] generateRandomArray(int length) {
        BookCharacter[] array = new BookCharacter[length];
        for (int i = 0; i < length; i++) {
            array[i] = new BookCharacter(UUID.randomUUID().toString(), (int) (Math.random() * length * 100));
        }
        return array;
    }

    public String toString() {
        return height + "";
    }

    public String getId() {
        return id;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof BookCharacter) {
            return this.height - ((BookCharacter) o).height;
        }
        return -1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BookCharacter) {
            return this.height == ((BookCharacter) obj).height;
        }
        return false;
    }

}