package p201_300.p216组合总和3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        dfs(nums, 0, 0, k, n, new LinkedList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int i, int depth, int k, int n, LinkedList<Integer> path, List<List<Integer>> res) {
        if (depth == k) {
            if (sumList(path) == n) {
                res.add(new LinkedList<>(path));
            }
            return;
        }

        for (int j = 0; j < 9; ++j) {
            if (j < i) { // 剪枝，减少不必要的递归调用
                continue;
            }

            if (path.contains(nums[j])) { // 不能重复
                continue;
            }

            path.addLast(nums[j]);
            dfs(nums, j, depth+1, k, n, path, res);
            path.removeLast();
        }
    }

    private int sumList(List<Integer> src) {
        return src.stream().reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Solution().combinationSum3(3, 9);
        System.out.println(res);
    }
}