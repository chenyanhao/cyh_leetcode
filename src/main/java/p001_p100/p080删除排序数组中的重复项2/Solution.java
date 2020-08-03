package p001_p100.p080删除排序数组中的重复项2;

class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            // 慢指针只有小于 2 或者往前数 2 位小于快指针时，才往前推进
            if (slow < 2 || nums[slow - 2] < nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}