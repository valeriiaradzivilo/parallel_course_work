package common;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class BookCharacter implements Comparable {
    private final String id;

    private final float height;

    public BookCharacter(String id, float height) {
        this.id = id;
        if (height < 0)
            throw new IllegalArgumentException("Height cannot be negative");
        this.height = height;
    }

    public static BookCharacter[] generateRandomArray(int length) {
        BookCharacter[] array = new BookCharacter[length];
        for (int i = 0; i < length; i++) {
            array[i] = new BookCharacter(UUID.randomUUID().toString(), i + 0.1f);
        }
        // shuffle
        List<BookCharacter> list = Arrays.asList(array);
        Collections.shuffle(list);
        array = list.toArray(array);
        return array;
    }

    public String toString() {
        return height + "";
    }

    public String getId() {
        return id;
    }

    public float getHeight() {
        return height;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof BookCharacter) {
            return (int) (this.height - ((BookCharacter) o).height);
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