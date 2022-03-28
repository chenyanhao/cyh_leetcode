package 框架代码.归并排序;

public class 自顶向下归并 {

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        // left > right 为递归终止条件。left == right 说明只有一个元素需要排序。这两种情况都直接返回
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    // arr[left : mid]  arr[mid+1 : right]
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid+1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                ++i;
                ++k;
            } else {
                temp[k] = arr[j];
                ++j;
                ++k;
            }
        }

        while (i <= mid) {
            temp[k] = arr[i];
            ++i;
            ++k;
        }

        while (j <= right) {
            temp[k] = arr[j];
            ++j;
            ++k;
        }

        // 新数组覆盖老数组
        for (int p = 0; p < temp.length; ++p) {
            arr[left+p] = temp[p];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,6,77,8,5,2,4,56,9,0};
        mergeSort(arr);
        for (int e : arr) {
            System.out.println(e);
        }
    }

}
