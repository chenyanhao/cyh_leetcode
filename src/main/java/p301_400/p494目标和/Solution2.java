package p301_400.p494目标和;

import java.util.*;

/**
 * 通过备忘录优化。
 * 可以看到备忘录 cache 目前是个 HashMap，
 * 其实也可以是个二维数组，一维是 depth，另一维是 trackSum。
 * 有次可见，带备忘录优化的递归和DP是等价的。
 */
class Solution2 {

    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, 0, 0, target, new HashMap<>());
    }

    // 备忘录 cache 也可以是个二维数组，一维是 depth，另一维是 trackSum
    private int dfs(int[] nums, int depth, int trackSum, int target, Map<String, Integer> cache) {
        if (depth == nums.length) {
            if (trackSum == target) {
                return 1;
            }
            return 0;
        }

        String key = depth + "_" + trackSum;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int left = dfs(nums, depth+1, trackSum+nums[depth], target, cache);
        int right = dfs(nums, depth+1, trackSum-nums[depth], target, cache);

        cache.put(key, left + right);
        return left + right;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 1, 1, 1};
        int ans = new Solution2().findTargetSumWays(nums, 3);
        System.out.println(ans);
    }
}