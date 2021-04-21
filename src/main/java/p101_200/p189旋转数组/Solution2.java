package p101_200.p189旋转数组;

/**
 * 递归翻转
 *
 * 以 n=7，k=3 为例：
 * 原始数组 	                    1 2 3 4 5 6 7
 * 翻转所有元素 	                7 6 5 4 3 2 1
 * 翻转 [0,k mod n−1]区间的元素 	5 6 7 4 3 2 1
 * 翻转 [k mod n,n−1]区间的元素 	5 6 7 1 2 3 4
 *
 * 时间复杂度：O(n)。每个元素被翻转两次，一共 n 个元素，因此总时间复杂度为 O(2n)=O(n)。
 * 空间复杂度：O(1)。
 *
 */
class Solution2 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            ++start;
            --end;
        }
    }
}