package p101_200.p179最大数;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 利用快速排序，按照标准双路快排模板编写
 */
class Solution2 {
    public String largestNumber(int[] nums) {
        String[] strs = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        quickSort(strs, 0, strs.length - 1);

        // 排序后第一个数为 0，那么直接返回 0
        if (strs[0].equals("0")) {
            return "0";
        }
        return Arrays.stream(strs).collect(Collectors.joining(""));
    }

    private void quickSort(String[] strs, int l, int r) {
        if (l >= r) {
            return;
        }
        int pivot = partition(strs, l, r);
        quickSort(strs, l, pivot - 1);
        quickSort(strs, pivot + 1, r);
    }

    private int partition(String[] strs, int l, int r) {
        String pivot = strs[l];
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && (pivot+strs[i]).compareTo(strs[i]+pivot) < 0) {
                ++i;
            }
            while (j >= l && (strs[j]+pivot).compareTo(pivot+strs[j]) < 0) {
                --j;
            }
            if (i > j) {
                break;
            }

            swap(strs, i, j);
            ++i;
            --j;
        }

        swap(strs, l, j);
        return j;
    }

    private void swap(String[] strs, int a, int b) {
        String tmp = strs[a];
        strs[a] = strs[b];
        strs[b] = tmp;
    }


    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        String result = new Solution2().largestNumber(nums);
        System.out.println(result);
    }

}