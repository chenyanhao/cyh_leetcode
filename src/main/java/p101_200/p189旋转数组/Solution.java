package p101_200.p189旋转数组;

/**
 * 使用额外的数组来将每个元素放至正确的位置
 * 原数组下标为 i 的元素放至新数组下标为 (i+k) mod n 的位置
 *
 * 时间复杂度： O(n)
 * 空间复杂度： O(n)
 */
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }
}