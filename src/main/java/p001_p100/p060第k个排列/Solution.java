package p001_p100.p060第k个排列;

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
            // 例如 nums=[1,2,3,4,5]，第一次选1之后，候选集=[2,3,4,5]，候选集一共4个数，全排列有 4! 种情况。
            // 如果 k > 4!，那么这里就没必要展开递归了。因此提前计算这一分支能得到多少叶子节点，进而决定是展开分支还是跳过分支。
            int cur = factorial(nums.length-1 - depth);
            if (cur < k) {
                k -= cur;
                continue;
            }

            path.addLast(nums[i]);
            dfs(nums, depth + 1, path, res, k);

            // 切忌，这行代码不能加，因为本题只需要一个结果，也仅有一个符合条件的结果，所以算法设计是「一下子来到叶子结点」，没有回头的过程
            // path.removeLast();
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
        String permutation = getPermutation(3, 4);
        System.out.println(permutation);
    }
}