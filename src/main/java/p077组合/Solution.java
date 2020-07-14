package p077组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = i + 1;
        }

        boolean[] used = new boolean[n];
        Arrays.fill(used, false);

        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, used, new LinkedList<>(), res, k);
        return res;
    }

    private static void dfs(int[] nums, int depth, boolean[] used, LinkedList<Integer> path, List<List<Integer>> res, int k) {
        if (depth == k) {
            res.add(new ArrayList<>(path));
        }

        for (int i = 0; i < nums.length; ++i) {
            if (used[i]) {
                continue;
            }
            if (path.size() > 0 && path.getLast() > nums[i]) {
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, depth + 1, used, path, res, k);
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine.size());
    }
}