import java.util.*;

public class RadixSort {
    private static final int ARRAY_SIZE = 1000;

    private static class Queue {
        private static final class Node {
            int val;
            Node next;

            Node(int val) {
                this.val = val;
            }
        }

        Node front = null;
        Node rear = null;

        void enqueue(int val) {
            Node n = new Node(val);
            if(rear != null) {
                rear.next = n;
            }
            rear = n;
            if(front == null) {
                front = rear;
            }
        }

        int dequeue() {
            if(isEmpty()) throw new NoSuchElementException();
            int v = front.val;
            front = front.next;
            if(front == null) rear = null;
            return v;
        }

        int peek() {
            if(isEmpty()) throw new NoSuchElementException();
            return front.val;
        }

        boolean isEmpty() {
            return front == null;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[ARRAY_SIZE];
        for(int i = 0; i < ARRAY_SIZE; i++) {
            arr[i] = i;
        }
        Collections.shuffle(Arrays.asList(arr));
        int[] newArr = Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
        radixSort(newArr, ARRAY_SIZE, 10);

        print_array("Array", newArr);
    }

    public static void radixSort(int[] arr, int len, int digits) {
        if(len < 1) return;

        Queue[] queues = new Queue[digits];
        int maxDigits = getMaxDigits(arr, len);
        for(int i = 0; i < digits; i++) {
            queues[i] = new Queue();
        }

        int x = 0;
        for(int k = 0; k <= maxDigits; k++) {
            for(int i = 0; i < len; i++) {
                int index = arr[i] % ((int) Math.pow(digits, k+1));
                index = index/((int) Math.pow(digits, k));
                queues[index].enqueue(arr[i]);
            }

            for(int j = 0; j < digits; j++) {
                while(!queues[j].isEmpty()) {
                    arr[x++] = queues[j].dequeue();
                }
            }
            x = 0;
        }
    }

    public static int getMaxDigits(int[] arr, int len) {
        int digit = 0;
        for(int i = 0; i < len; i++) {
            int d = (int) Math.log10(arr[i]);
            if(d > digit) digit = d;
        }
        return digit;
    }

    public static void print_array(String namespace, int[] arr) {
        System.out.printf("%s: ", namespace);
        for(int i : arr) {
            System.out.printf("%d ", i);
        }
    }
}