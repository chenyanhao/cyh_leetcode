package 框架代码.快速排序;

import java.util.Random;

/**
 * 相比于基础版的快速排序，随机化的改动在于 partition(int[] arr, int l, int r) 方法；
 * 基础版在选择 pivot 的时候，永远选择第1个元素，在近乎有序的数组中，会退化成 O(n^2) 的复杂度；
 * 随机版在选择 pivot 的时候，从 arr 中任选一个来，换到第一个位置去，算法其余部分不变
 *
 */
public class 一路快排加随机选择pivot {

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

    /**
     *
     * 游标 j 是关键；
     * j 的右边全是比 pivot 大的；
     * j 的左边（包括 j）一直到 arr[l + 1]，都比 pivot 小；
     *
     * 循环结束，把 l 和 j 换一下，pivot 到了它该到的位置
     */
    public int partition(int[] arr, int l, int r) {

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int)(Math.random() * (r - l + 1)) + l);

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
        new 一路快排加随机选择pivot().quickSort(arr);

        for (int i = 0; i < arr.length; ++i) {
            System.out.println(arr[i]);
        }
    }

}
