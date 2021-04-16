import java.util.*;

public class Main {
    private static final int ARRAY_SIZE = 1000;

    public static void main(String[] args) {
        Integer[] arr = new Integer[ARRAY_SIZE];
        for(int i = 0; i < ARRAY_SIZE; i++) {
            arr[i] = i;
        }
        Collections.shuffle(Arrays.asList(arr));
        int[] newArr = Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
        bubbleSort(newArr);

        for(int i : newArr) {
            System.out.println(i);
        }
    }

    public static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length-1; i++) {
            for(int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx2];
        arr[idx2] = arr[idx1];
        arr[idx1] = tmp;
    }
}