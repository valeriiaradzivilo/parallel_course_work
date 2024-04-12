//package parallel_bubble_sort.odd_even;
//
//import common.BookCharacter;
//
//import java.util.concurrent.atomic.AtomicBoolean;
//
//public class OddEvenSorter implements Runnable {
//    private final BookCharacter[] array;
//    private final int start;
//
//    private final AtomicBoolean sorted;
//
//    public OddEvenSorter(BookCharacter[] array, int start, AtomicBoolean sorted) {
//        this.array = array;
//        this.start = start;
//        this.sorted = sorted;
//    }
//
//    @Override
//    public void run() {
//        for (int i = start; i < array.length - 1; i += 2) {
//            if (array[i].getHeight() > array[i + 1].getHeight()) {
//                // Swap elements
//                BookCharacter temp = array[i];
//                array[i] = array[i + 1];
//                array[i + 1] = temp;
//                sorted.set(false);
//            }
//        }
//    }
//}