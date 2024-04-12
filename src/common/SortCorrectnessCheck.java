package common;

public class SortCorrectnessCheck {

    public static boolean check(BookCharacter[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].getHeight() > arr[i + 1].getHeight()) {
                return false;
            }
        }
        return true;
    }
}