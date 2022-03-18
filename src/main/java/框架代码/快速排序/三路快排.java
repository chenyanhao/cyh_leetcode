package 框架代码.快速排序;

import java.util.Random;

public class 三路快排 {

    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int[] p = partition(arr, l, r);
        quickSort(arr, l, p[0] - 1);
        quickSort(arr, p[1], r);
    }

    // arr[l] = pivot; arr[l+1..lt] < pivot; arr[lt+1..i-1] = pivot; arr[gt..r] > pivot
    // i 为当前的遍历元素，最终循环结束的时机为：i == gt
    public int[] partition(int[] arr, int l, int r) {
        int pivot = arr[l];

        // arr[l+1..lt] < pivot，arr[gt..r] > pivot。初始化时保证这两个左闭右闭区间都为空
        int lt = l, gt = r + 1;

        int i = l + 1;
        while (i < gt) {
            if (arr[i] < pivot) {
                ++lt;
                swap(arr, i, lt);
                ++i;
            } else if (arr[i] > pivot) {
                --gt;
                swap(arr, i, gt);
            } else {
                ++i;
            }
        }
        swap(arr, l, lt);
        return new int[] {lt, gt};
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
        new 三路快排().quickSort(arr);

        for (int i = 0; i < arr.length; ++i) {
            System.out.println(arr[i]);
        }
    }

}
