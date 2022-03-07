package p301_400.p494目标和;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        List<List<Character>> ans = new LinkedList<>();
        dfs(nums, 0, 0, target, ans, new LinkedList<>());
        return ans.size();
    }

    private void dfs(int[] nums, int depth, int trackSum, int target, List<List<Character>> ans, LinkedList<Character> path) {
        if (depth == nums.length) {
            if (trackSum == target) {
                ans.add(new LinkedList<>(path));
            }
            return;
        }

        path.addLast('+');
        dfs(nums, depth+1, trackSum+nums[depth], target, ans, path);
        path.removeLast();

        path.addLast('-');
        dfs(nums, depth+1, trackSum-nums[depth], target, ans, path);
        path.removeLast();
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 1, 1, 1};
        int ans = new Solution().findTargetSumWays(nums, 3);
        System.out.println(ans);
    }
}