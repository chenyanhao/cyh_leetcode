package p201_300.p219存在重复元素2;

/**
 * 暴力解法，会超时
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i+1; j < nums.length && j <= i + k; ++j) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}