package p001_p100.p075颜色分类;

/**
 * 单指针对数组进行两次遍历。第一次将所有的 0 交换到头部，第二次将所有的 1 交换到 0 之后
 */
class Solution {
    public void sortColors(int[] nums) {
        int ptr = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                swap(nums, i, ptr);
                ++ptr;
            }
        }

        for (int i = ptr; i < nums.length; ++i) {
            if (nums[i] == 1) {
                swap(nums, i, ptr);
                ++ptr;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}