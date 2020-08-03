package p001_p100.p046全排列;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new ArrayDeque<>(), res);
        return res;
    }

    private void dfs(int[] nums, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int n : nums) {
            if (path.contains(n)) {
                continue;
            }
            path.addLast(n);
            dfs(nums, path, res);
            path.removeLast();
        }
    }
}