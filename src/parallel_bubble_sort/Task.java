//package parallel_bubble_sort;
//
//import common.BookCharacter;
//
//import java.util.concurrent.atomic.AtomicBoolean;
//
//public class Task extends Thread {
//    private final BookCharacter[] array;
//    private final int firstIndex;
//
//    private final int secondIndex;
//
//    private final AtomicBoolean swapped;
//
//
//    public Task(BookCharacter[] array, int firstIndex, int secondIndex, AtomicBoolean swapped) {
//        this.array = array;
//        this.firstIndex = firstIndex;
//        this.secondIndex = secondIndex;
//
//        this.swapped = swapped;
//    }
//
//    @Override
//    public void run() {
//
//        if (array[firstIndex].getHeight() > array[secondIndex].getHeight()) {
//            BookCharacter temp = array[firstIndex];
//            array[firstIndex] = array[secondIndex];
//            array[secondIndex] = temp;
//
//            swapped.set(false);
//        }
//
//
//    }
//}