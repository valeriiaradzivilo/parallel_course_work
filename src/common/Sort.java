package common;

public abstract class Sort {

    public abstract int[] sort(int[] arr);


    public void print(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    public void test() {
        int[] arr = {5, 2, 3, 1, 4};
        sort(arr);
        print(arr);
    }
}