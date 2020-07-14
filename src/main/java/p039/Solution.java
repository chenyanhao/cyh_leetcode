package p039;

import java.util.*;

class Solution {
    /**
     *
     * 剪枝提速
     *      把候选数组排个序，遇到一个较大的数，如果以这个数为起点都搜索不到结果，后面的数就更搜索不到结果了。（排序是为了提高搜索速度，非必要）
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayDeque<>(), res);
        return res;
    }

    private void dfs(int[] candidates, int target, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < candidates.length; ++i) {
            if (target - candidates[begin] < 0) {
                break;
            }
            path.addLast(candidates[i]);
            dfs(candidates, target - candidates[i], i, path, res);
            path.removeLast();
        }
    }
}