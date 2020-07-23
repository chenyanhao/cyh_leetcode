package p090子集2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayDeque<>(), res);
        return res;
    }

    private void dfs(int[] nums, int start, ArrayDeque<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; ++i) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            path.addLast(nums[i]);
            dfs(nums, i + 1, path, res); // 注意这里是 i+1，而不是 start+1
            path.removeLast();
        }
    }

}