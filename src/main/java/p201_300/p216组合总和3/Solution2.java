package p201_300.p216组合总和3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 第二种递归写法，注意和第一种区分对比
 */
class Solution2 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < nums.length; ++i) {
            dfs(nums, i, 1, k, n, new LinkedList<>(), res);
        }
        return res;
    }

    private void dfs(int[] nums, int i, int depth, int k, int n, LinkedList<Integer> path, List<List<Integer>> res) {
        path.addLast(nums[i]);
        if (depth == k) {
            if (sumList(path) == n) {
                res.add(new LinkedList<>(path));
            }
        }

        for (int j = i+1; j < 9; ++j) {
            dfs(nums, j, depth+1, k, n, path, res);
        }
        path.removeLast();
    }

    private int sumList(List<Integer> src) {
        return src.stream().reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Solution2().combinationSum3(3, 9);
        System.out.println(res);
    }
}