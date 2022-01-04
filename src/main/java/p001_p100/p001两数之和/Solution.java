package p001_p100.p001两数之和;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (indexMap.containsKey(target - nums[i])) {
                return new int[] {i, indexMap.get(target - nums[i])};
            }
            indexMap.put(nums[i], i);
        }
        return new int[]{};
    }
}