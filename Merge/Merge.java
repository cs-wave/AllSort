import java.util.*;

public class Merge {
    private static final int ARRAY_SIZE = 1000;

    public static void main(String[] args) {
        Integer[] arr = new Integer[ARRAY_SIZE];
        for(int i = 0; i < ARRAY_SIZE; i++) {
            arr[i] = i;
        }
        Collections.shuffle(Arrays.asList(arr));
        int[] newArr = Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
        mergeSort(newArr, 0, ARRAY_SIZE-1);

        for(int i : newArr) {
            System.out.println(i);
        }
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if(end-start > 0) {
            int mid = (end+start)/2 + 1;
            mergeSort(arr, start, mid-1);
            mergeSort(arr, mid, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int[] map = new int[end-start+1];
        int i = start, j = mid, l = end-start+1, p = 0;

        while(i < mid && j < end+1) {
            if(arr[i] > arr[j]) {
                map[p++] = arr[j++];
            } else {
                map[p++] = arr[i++];
            }
        }

        while(i < mid) {
            map[p++] = arr[i++];
        }

        while(j < end+1) {
            map[p++] = arr[j++];
        }

        for(int k = 0; k < l; k++) {
            arr[k+start] = map[k];
        }
    }
}
