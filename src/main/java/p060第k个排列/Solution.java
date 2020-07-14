package p060第k个排列;

import java.util.LinkedList;

class Solution {
    public static String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = i + 1;
        }
        StringBuilder res = new StringBuilder();
        dfs(nums, 0, new LinkedList<>(), res, k);
        return res.toString();
    }

    private static void dfs(int[] nums, int depth, LinkedList<Integer> path, StringBuilder res, int k) {
        if (depth == nums.length) {
            for (Integer i : path) {
                res.append(i);
            }
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            // 当前元素被使用过，剪枝
            if (path.contains(nums[i])) {
                continue;
            }

            // 当前的排列组合数小于k，说明就算这一层排完了，也到不了第k个，剪枝
            int cur = factorial(nums.length - 1 - depth);
            if (cur < k) {
                k -= cur;
                continue;
            }

            path.addLast(nums[i]);
            dfs(nums, depth + 1, path, res, k);
            // path.removeLast(); // 切忌，这行代码不能加，因为本题只需要一个结果，也仅有一个符合条件的结果
        }
    }

    private static int factorial(int n) {
        int res = 1;
        while (n > 0) {
            res *= n--;
        }
        return res;
    }

    public static void main(String[] args) {
        String permutation = getPermutation(3, 3);
        System.out.println(permutation);
    }
}