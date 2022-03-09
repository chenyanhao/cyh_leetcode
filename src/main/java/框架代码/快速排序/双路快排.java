package 框架代码.快速排序;

import java.util.Random;

public class 双路快排 {

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

    // arr[l] = pivot; arr[l+1..i-1] < pivot; arr[j+1..r] > pivot;
    public int partition(int[] arr, int l, int r) {
        int pivot = arr[l];
        int i = l + 1, j = r;
        while (true) {
            // 接下来两个循环条件不能带等号的原因：没有等号，最终返回的 j 会停在中间；有等号，返回的 j 会停在最边上，这就没有起到二分的效果。
            while (i <= r && arr[i] < pivot) { // 注意这里不能带等号。
                ++i;
            }
            while (j >= l + 1 && arr[j] > pivot) { // 注意这里不能带等号
                --j;
            }

            // i、j 2个游标相向而行，i>j 表示相遇并刚好错过的情形，意味着2个游标一起把数组遍历了一遍
            // 如果这里带等号，当 i==j 时循环就结束了，相当于没遍历完数组
            if (i > j) { // 注意不能带等号
                break;
            }

            swap(arr, i, j);
            ++i;
            --j;
        }

        // 接下来逻辑和一路快排一样
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
        new 双路快排().quickSort(arr);

        for (int i = 0; i < arr.length; ++i) {
            System.out.println(arr[i]);
        }
    }
}
