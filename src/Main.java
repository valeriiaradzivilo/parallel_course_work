import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100); // Generate random numbers between 0 to 99
        }

        // Print the array
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}