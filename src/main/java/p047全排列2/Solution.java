package p047全排列2;

import java.util.*;

class Solution {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, new ArrayDeque<>(), res, used);
        return res;
    }

    private static void dfs(int[] nums, Deque<Integer> path, List<List<Integer>> res, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        Set<Integer> notDunplicated = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (used[i]) {
                continue;
            }

            int n = nums[i];
            if (notDunplicated.contains(n)) {
                continue;
            }

            // 做选择
            path.addLast(n);
            notDunplicated.add(n);
            used[i] = true;

            dfs(nums, path, res, used);

            // 撤销选择，即回溯
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        List<List<Integer>> res = permuteUnique(nums);
        System.out.println(res);
    }
}