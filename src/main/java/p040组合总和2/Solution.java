package p040组合总和2;

import java.util.*;

class Solution {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayDeque<>(), res);
        return res;
    }

    private static void dfs(int[] candidates, int target, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < candidates.length; ++i) {
            // 大剪枝
            if (target - candidates[begin] < 0) {
                break;
            }

            // 小剪枝：防止 candidate 重复元素带来的最终结果重复
            //      input[i - 1] == input[i] 表明当前选出来的数等于当前层前一个分支选出来的数
            //      因为前一个分支的候选集合一定大于后一个分支的候选集合，故后面出现的分支中一定包含了前面分支出现的结果，因此剪枝防止重复
            if (i - 1 >= begin && candidates[i - 1] == candidates[i]) {
                continue;
            }

            path.addLast(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[] {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> lists = combinationSum2(candidates, target);
        System.out.println(lists);
    }

}