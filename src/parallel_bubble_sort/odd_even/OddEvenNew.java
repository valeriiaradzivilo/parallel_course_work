//package parallel_bubble_sort.odd_even;
//
//import common.BookCharacter;
//import common.Sort;
//import common.SortCorrectnessCheck;
//
//import java.util.concurrent.BrokenBarrierException;
//import java.util.concurrent.CyclicBarrier;
//
//public class OddEvenNew extends Sort {
//
//    private static int THREAD_COUNT = 2;
//    private static final CyclicBarrier barrier = new CyclicBarrier(THREAD_COUNT);
//
//
//    private void oddEvenSort(int tid, BookCharacter[] array) throws InterruptedException, BrokenBarrierException {
//        int start = tid == 0 ? 1 : 0;
//        int end = tid == 0 ? array.length - 1 : array.length - 2;
//        boolean isSorted = false;
//
//        synchronized (array) {
//            for (int i = start; i <= end; i += 2) {
//                if (array[i].getHeight() > array[i + 1].getHeight()) {
//                    BookCharacter temp = array[i];
//                    array[i] = array[i + 1];
//                    array[i + 1] = temp;
//                }
//            }
//        }
//
//        barrier.await();
//
//        if (tid == 0 && isSorted) {
//            synchronized (array) {
//                array.notifyAll();
//            }
//        }
//
//        synchronized (array) {
//            for (int i = start; i <= end; i += 2) {
//                if (array[i].getHeight() > array[i + 1].getHeight()) {
//                    BookCharacter temp = array[i];
//                    array[i] = array[i + 1];
//                    array[i + 1] = temp;
//                    isSorted = false;
//                }
//            }
//        }
//
//        barrier.await();
//    }
//
//
//    @Override
//    protected BookCharacter[] sortAlgorithm(BookCharacter[] arr) throws InterruptedException {
//        BookCharacter[] sortedArr = new BookCharacter[arr.length];
//        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
//
//        Thread[] threads = new Thread[THREAD_COUNT];
//        for (int i = 0; i < THREAD_COUNT; i++) {
//            final int tid = i;
//            threads[i] = new Thread(() -> {
//                try {
//                    oddEvenSort(tid, sortedArr);
//                } catch (InterruptedException | BrokenBarrierException e) {
//                    e.printStackTrace();
//                }
//            });
//            threads[i].start();
//        }
//
//        for (Thread thread : threads) {
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        return sortedArr;
//    }
//
//
//    public void checkThreadCount(BookCharacter[] array) {
//        try {
//            int bestThreads = 1;
//            long bestTime = Long.MAX_VALUE;
//            for (int i = 1; i < 100; i++) {
//                THREAD_COUNT = i;
//                System.out.println("Thread count is: " + THREAD_COUNT);
//                //count time
//                long startTime = System.currentTimeMillis();
//
//                final BookCharacter[] result = sort(array);
//                long endTime = System.currentTimeMillis();
//                long duration = (endTime - startTime);
//                System.out.println("Duration: " + duration);
//                if (duration < bestTime && SortCorrectnessCheck.check(result)) {
//                    bestTime = duration;
//                    bestThreads = i;
//                }
//            }
//            System.out.println("Best time: " + bestTime + " with " + bestThreads + " threads");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//}