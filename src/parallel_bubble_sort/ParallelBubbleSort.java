//package parallel_bubble_sort;
//
//import java.util.concurrent.ForkJoinPool;
//import java.util.concurrent.RecursiveAction;
//
//public class ParallelBubbleSort extends RecursiveAction {
//
//    private final int[] arr;
//    private final int low;
//    private final int high;
//
//    public ParallelBubbleSort(int[] arr, int low, int high) {
//        this.arr = arr;
//        this.low = low;
//        this.high = high;
//    }
//
//    public static void parallelSort(int[] arr) {
//        ForkJoinPool pool = new ForkJoinPool();
//        pool.invoke(new ParallelBubbleSort(arr, 0, arr.length));
//    }
//
//    @Override
//    protected void compute() {
//        if (high - low <= 5000) { // Threshold can be adjusted based on the size of the array
//            bubbleSort(low, high);
//        } else {
//            int mid = low + (high - low) / 2;
//            ParallelBubbleSort left = new ParallelBubbleSort(arr, low, mid);
//            ParallelBubbleSort right = new ParallelBubbleSort(arr, mid, high);
//            invokeAll(left, right);
//        }
//    }
//
//    private void bubbleSort(int low, int high) {
//        for (int i = low; i < high; i++) {
//            for (int j = low; j < high - 1; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//    }
//
//
//}