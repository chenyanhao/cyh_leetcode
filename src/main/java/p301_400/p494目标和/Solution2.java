package p301_400.p494目标和;

import java.util.*;

class Solution2 {

    private Map<String, Boolean> cache = new LinkedHashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        List<List<Character>> ans = new LinkedList<>();
        dfs(nums, 0, 0, target, ans, new LinkedList<>());
        return ans.size();
    }

    // 备忘录 cache 也可以是个二维数组，一维是 depth，另一维是 trackSum
    private void dfs(int[] nums, int depth, int trackSum, int target,
                     List<List<Character>> ans, LinkedList<Character> path) {
        if (depth == nums.length) {
            if (trackSum == target) {
                ans.add(new LinkedList<>(path));
            }
            return;
        }

        String key = depth + "_" + trackSum;
        if (cache.containsKey(key)) {
            return;
        }

        path.addLast('+');
        dfs(nums, depth+1, trackSum+nums[depth], target, ans, path);
        path.removeLast();

        path.addLast('-');
        dfs(nums, depth+1, trackSum-nums[depth], target, ans, path);
        path.removeLast();

        cache.put(key, true);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 1, 1, 1};
        int ans = new Solution2().findTargetSumWays(nums, 3);
        System.out.println(ans);
    }
}