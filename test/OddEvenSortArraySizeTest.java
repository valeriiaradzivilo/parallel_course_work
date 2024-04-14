import common.BookCharacter;
import org.junit.Test;
import simple_bubble_sort.modification.OddEvenSortSplitModification;

public class OddEvenSortArraySizeTest {
    @Test
    public void size_10000() throws InterruptedException {
        BookCharacter[] arr = BookCharacter.generateRandomArray(10000);

        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();
        final BookCharacter[] sortedArr = sort.sort(arr);

        for (int i = 0; i < sortedArr.length - 1; i++) {
            assert sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight();
        }
    }

    @Test
    public void size_20000() throws InterruptedException {
        BookCharacter[] arr = BookCharacter.generateRandomArray(20000);

        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();
        final BookCharacter[] sortedArr = sort.sort(arr);

        for (int i = 0; i < sortedArr.length - 1; i++) {
            assert sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight();
        }
    }

    @Test
    public void size_30000() throws InterruptedException {
        BookCharacter[] arr = BookCharacter.generateRandomArray(30000);

        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();
        final BookCharacter[] sortedArr = sort.sort(arr);

        for (int i = 0; i < sortedArr.length - 1; i++) {
            assert sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight();
        }
    }

    @Test
    public void size_40000() throws InterruptedException {
        BookCharacter[] arr = BookCharacter.generateRandomArray(40000);

        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();
        final BookCharacter[] sortedArr = sort.sort(arr);

        for (int i = 0; i < sortedArr.length - 1; i++) {
            assert sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight();
        }
    }

    @Test
    public void size_50000() throws InterruptedException {
        BookCharacter[] arr = BookCharacter.generateRandomArray(50000);

        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();
        final BookCharacter[] sortedArr = sort.sort(arr);

        for (int i = 0; i < sortedArr.length - 1; i++) {
            assert sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight();
        }
    }

    @Test
    public void size_60000() throws InterruptedException {
        BookCharacter[] arr = BookCharacter.generateRandomArray(60000);

        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();
        final BookCharacter[] sortedArr = sort.sort(arr);

        for (int i = 0; i < sortedArr.length - 1; i++) {
            assert sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight();
        }
    }

    @Test
    public void size_70000() throws InterruptedException {
        BookCharacter[] arr = BookCharacter.generateRandomArray(70000);

        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();
        final BookCharacter[] sortedArr = sort.sort(arr);

        for (int i = 0; i < sortedArr.length - 1; i++) {
            assert sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight();
        }
    }

    @Test
    public void size_80000() throws InterruptedException {
        BookCharacter[] arr = BookCharacter.generateRandomArray(80000);

        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();
        final BookCharacter[] sortedArr = sort.sort(arr);

        for (int i = 0; i < sortedArr.length - 1; i++) {
            assert sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight();
        }
    }

    @Test
    public void size_90000() throws InterruptedException {
        BookCharacter[] arr = BookCharacter.generateRandomArray(90000);

        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();
        final BookCharacter[] sortedArr = sort.sort(arr);

        for (int i = 0; i < sortedArr.length - 1; i++) {
            assert sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight();
        }
    }

    @Test
    public void size_100000() throws InterruptedException {
        BookCharacter[] arr = BookCharacter.generateRandomArray(100000);

        OddEvenSortSplitModification sort = new OddEvenSortSplitModification();
        final BookCharacter[] sortedArr = sort.sort(arr);

        for (int i = 0; i < sortedArr.length - 1; i++) {
            assert sortedArr[i].getHeight() <= sortedArr[i + 1].getHeight();
        }
    }
}