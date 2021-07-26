package p201_300.p215数组中的第K个最大元素;

import java.util.Random;

/**
 * 利用快排思想，快排每次 partition 后，一定可以确定 pivot 元素的最终位置，假设最终位置为 q。
 *
 * 1) q = index 直接返回 a[q]；
 * 2) q < index 递归右子区间；
 * 3) q > index 递归左子区间。
 *
 * 快排的性能和 partition 出的子数组的长度密切相关。
 * 每次规模为 n 的问题都划分成 1 和 n−1 的这种情况是最坏的，时间代价是 O(n^2)。
 * 可以引入随机化来加速这个过程，它的时间代价的期望是 O(n)，算法导论有证明。
 *
 *
 * 时间复杂度：如果是 randomPartion 则为 O(n)，如果是普通 partition 则为 O(n^2)
 * 空间复杂度：O(log n)，递归使用的栈空间。
 *
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int l, int r, int index) {
        int q = partition(nums, l, r);
        if (q == index) {
            return nums[q];
        } else if (q < index) {
            return quickSelect(nums, q + 1, r, index);
        } else {
            return quickSelect(nums, l, q-1, index);
        }
    }

    private int randomPartition(int[] nums, int l, int r) {
        Random random = new Random();
        int i = random.nextInt(r - l + 1) + l;
        swap(nums, i, l);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int j = l;
        int pivot = nums[l];
        //循环结束后：arr[l] = pivot; arr[l+1..j] < pivot; arr[j+1..r] > pivot
        for (int i = l+1; i <= r; ++i) {
            if (nums[i] < pivot) {
                swap(nums, j+1, i);
                ++j;
            }
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}