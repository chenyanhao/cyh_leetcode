package 框架代码.快速排序;

import java.util.Random;

public class 一路快排 {

    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    public int partition(int[] arr, int l, int r) {
        int pivot = arr[l];
        int j = l;

        //循环结束后：arr[l] = pivot; arr[l+1..j] < pivot; arr[j+1..r] > pivot
        for (int i = l + 1; i <= r; ++i) {
            if (arr[i] < pivot) {
                swap(arr, j + 1, i);
                ++j;
            }
        }

        swap(arr, l, j);
        return j;
    }

    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = new Random().nextInt(100);
        }
        new 一路快排().quickSort(arr);

        for (int i = 0; i < arr.length; ++i) {
            System.out.println(arr[i]);
        }
    }

}
