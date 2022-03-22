package p001_p100.p080删除排序数组中的重复项2;

class Solution {
    public int removeDuplicates(int[] nums) {
        // [0, slow) 表示符合条件的数组元素，fast表示当前遍历的元素
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (slow <= 1) {
                ++slow;
                ++fast;
                continue;
            }

            if (nums[fast] > nums[slow-2]) {
                nums[slow] = nums[fast];
                ++slow;
            }

            ++fast;
        }
        return slow;
    }
}