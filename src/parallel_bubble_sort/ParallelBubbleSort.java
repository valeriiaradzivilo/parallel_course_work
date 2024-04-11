package parallel_bubble_sort;

import common.BookCharacter;
import common.SortResult;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelBubbleSort {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<BookCharacter> lst = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            lst.add(new BookCharacter("BookCharacter" + i, new Random().nextInt(10000)));
        }
        SortResult result = sort(lst, 12);
        System.out.println(result.getSortedData());
        System.out.println("Time elapsed: ");
        System.out.println(result.getTimeElapsed());
    }

    public static SortResult sort(List<BookCharacter> value, int threadsCount) throws InterruptedException, ExecutionException {
        List<BookCharacter> lst = new ArrayList<>(value);
        int biggestItem = Collections.max(lst.stream().map(BookCharacter::getHeight).toList());

        long startTime = System.currentTimeMillis();

        List<List<BookCharacter>> lists = Stream.generate(ArrayList<BookCharacter>::new)
                .limit(threadsCount)

                .collect(Collectors.toList());

        // divide value into lists equally
        Iterator<BookCharacter> iterator = value.iterator();
        int size = (int) Math.ceil((double) value.size() / threadsCount);
        for (int i = 0; i < threadsCount; i++) {
            for (int j = 0; j < size; j++) {
                lists.get(i).add(iterator.next());
                if (!iterator.hasNext()) {
                    break;

                }
            }
        }


        ExecutorService executor = Executors.newFixedThreadPool(threadsCount);
        List<Future<?>> futures = new ArrayList<>();
        for (List<BookCharacter> list : lists) {
            Future<?> future = executor.submit(() -> bubbleSort(list));
            futures.add(future);
        }

        for (Future<?> future : futures) {
            future.get();
        }
        executor.shutdown();

        lst.clear();
        for (List<BookCharacter> list : lists) {
            lst.addAll(list);
        }
        long endTime = System.currentTimeMillis();

        return new SortResult(lst, endTime - startTime);
    }

    static void bubbleSort(List<BookCharacter> lst) {
        int n = lst.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (lst.get(j).getHeight() > lst.get(j + 1).getHeight()) {
                    Collections.swap(lst, j, j + 1);
                }
            }
        }
    }
}