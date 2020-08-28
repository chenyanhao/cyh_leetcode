package p101_200.p113路径总和2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new LinkedList<>(), root, sum);
        return res;
    }

    /**
     * path: 进入函数时，path 不含 root 节点
     * sum: 进入函数时，sum 不包含 root 节点的 val
     */
    private void dfs(List<List<Integer>> res, LinkedList<Integer> path, TreeNode root, Integer sum) {
        if (root == null) {
            return;
        }

        path.addLast(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new LinkedList<>(path));
        }
        dfs(res, path, root.left, sum - root.val);
        dfs(res, path, root.right, sum - root.val);
        path.removeLast();
    }

}