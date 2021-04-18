import java.util.*;

public class TreeSort {
    private static final int ARRAY_SIZE = 1000;
    private static int index = 0;

    private static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        BinaryTree(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[ARRAY_SIZE];
        for(int i = 0; i < ARRAY_SIZE; i++) {
            arr[i] = i;
        }
        Collections.shuffle(Arrays.asList(arr));
        int[] newArr = Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
        treeSort(newArr, ARRAY_SIZE);

        print_array("TreeSort", newArr);
    }

    public static void treeSort(int[] arr, int len) {
        if(len < 1) return;

        BinaryTree root = null;
        for(int i = 0; i < len; i++) {
            root = insert(root, arr[i]);
        }
        inOrder(root, arr);
        index = 0;
    }

    public static BinaryTree insert(BinaryTree t, int value) {
        if(t == null) {
            return new BinaryTree(value);
        } else {
            if(value > t.value) {
                t.right = insert(t.right, value);
            } else {
                t.left = insert(t.left, value);
            }
            return t;
        }
    }

    public static void inOrder(BinaryTree t, int[] arr) {
        if(t != null) {
            inOrder(t.left, arr);
            arr[index++] = t.value;
            inOrder(t.right, arr);
        }
    }

    public static void print_array(String namespace, int[] arr) {
        System.out.printf("%s: ", namespace);
        for(int i : arr) {
            System.out.printf("%d ", i);
        }
    }
}