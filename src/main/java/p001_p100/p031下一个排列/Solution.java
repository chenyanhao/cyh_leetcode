package p001_p100.p031下一个排列;

import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        // 从右侧开始，找递增对
        int n = nums.length - 1;
        for (int i = n - 1; i >= 0; --i) {
            if (nums[i] < nums[i + 1]) {
                // 找到 i 后面，比 i 大，但是又最接近它的值的下标
                int j = n;
                while (j > i && nums[j] <= nums[i]) {
                    --j;
                }
                swap(nums, i, j);
                Arrays.sort(nums, i + 1, nums.length);
                return;
            }
        }
        Arrays.sort(nums, 0, nums.length);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}