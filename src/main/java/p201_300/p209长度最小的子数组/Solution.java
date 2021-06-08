package p201_300.p209长度最小的子数组;

import java.util.Arrays;

/**
 * 解法：前缀和 + 二分查找
 *
 * 申请一个临时数组 sums，其中 sums[i] 表示的是原数组 nums 前 i 个元素的和。
 * 题中的数组都是正整数，那么相加的和会越来越大，也就是 sums 数组中的元素是递增的，这确保了二分查找的正确性。
 * 所以问题转化成：只需要找到 sums[k]-sums[j]>=target，那么 [j..k] 就是满足的连续子数组，但不一定是最小的，所以要继续找，直到找到最小的为止。
 * 怎么找呢，可以使用两个 for 循环来枚举，这种复杂度太高，可以换种思路，sums[k]-sums[j]>=target 转换成求 sums[j]+target<=sums[k]，
 * 因为数组 sums 中的元素是有序的，因此只需要求出 sum[j]+target 的值，然后使用二分法查找即可找到这个 k。
 *
 */
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;

        /**
         * sums[0] = 0
         * sums[1] = sums[0] + nums[0]
         * sums[i] = sums[i-1] + nums[i-1]
         *
         * 即,
         * i>=1, sums[i] = nums[0..(i-1)] 的和
         * i==0, sums[i] = 0
         *
         */
        int[] sums = new int[length + 1];
        for (int i = 1; i <= length; ++i) {
            sums[i] = sums[i-1] + nums[i-1];
        }

        int res = Integer.MAX_VALUE;
        for (int j = 1; j <= length; ++j) {
            int k = binarySearch(target + sums[j-1], sums);
            if (k != -1) {
                /**
                 * 根据前面 sums 的定义，sums[j] 到 sums[k] 相当于 nums[0..(j-1)] 的和到 nums[0..(k-1)] 的和，
                 * 对于 nums 来说，写成左开右闭区间为 [j-1, k)，所以一共是 k - (j-1) 个元素
                 */
                res = Math.min(res, k - (j-1));
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    // 二分查找，找到 nums 中第一个大于等于 target 的数。找到返回下标，没找到返回 -1
    private int binarySearch(int target, int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return (nums[left] >= target) ? left : -1;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = new int[]{2,3,1,2,4,3};

        int length = nums.length;
        int[] sums = new int[length + 1];
        for (int i = 1; i <= length; ++i) {
            sums[i] = sums[i-1] + nums[i-1];
        }

        int index = new Solution().binarySearch(target, sums);
        System.out.println(index);

        int i = new Solution().minSubArrayLen(target, nums);
        System.out.println(i);
    }

}