package p201_300.p219存在重复元素2;

import java.util.HashSet;
import java.util.Set;

/**
 * 用散列优化大小为 k 的滑动窗口
 */
class Solution2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}