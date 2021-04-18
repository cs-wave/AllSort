import java.util.*;

public class HeapSort {
    private static final int ARRAY_SIZE = 1000;

    public static void main(String[] args) {
        Integer[] arr = new Integer[ARRAY_SIZE];
        for(int i = 0; i < ARRAY_SIZE; i++) {
            arr[i] = i;
        }
        Collections.shuffle(Arrays.asList(arr));
        int[] newArr = Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
        heapSort(newArr, ARRAY_SIZE);

        print_array("HeapSort", newArr);
    }

    public static void heapSort(int[] arr, int len) {
        if(len < 1) return;

        int[] heap = new int[len];
        for(int i = 0; i < len; i++) {
            push(heap, i, arr[i]);
        }
        for(int j = len-1; j > -1; j--) {
            pop(arr, heap, j);
        }
    }


    public static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx2];
        arr[idx2] = arr[idx1];
        arr[idx1] = tmp;
    }

    public static void push(int[] heap, int idx, int v) {
        heap[idx] = v;
        high(heap, idx);
    }

    public static void pop(int[] arr, int[] heap, int idx) {
        arr[idx] = heap[0];
        swap(heap, 0, idx);
        low(heap, 0, idx-1);
    }

    public static void high(int[] heap, int idx) {
        if(idx == 0) return;
        int idx2 = (idx-1)/2;
        if(heap[idx] > heap[idx2]) {
            swap(heap, idx, idx2);
            high(heap, idx2);
        }
    }

    public static void low(int[] heap, int idx, int max) {
        int left = idx*2+1;
        int right = idx*2+2;
        if(right > max) {
            if(left <= max && heap[left] > heap[idx]) {
                swap(heap, idx, left);
                low(heap, left, max);
            }
        } else {
            if(heap[left] > heap[right]) {
                if(heap[left] > heap[idx]) {
                    swap(heap, idx, left);
                    low(heap, left, max);
                }
            } else {
                if(heap[right] > heap[idx]) {
                    swap(heap, idx, right);
                    low(heap, right, max);
                }
            }
        }
    }

    public static void print_array(String namespace, int[] arr) {
        System.out.printf("%s: ", namespace);
        for(int i : arr) {
            System.out.printf("%d ", i);
        }
    }
}