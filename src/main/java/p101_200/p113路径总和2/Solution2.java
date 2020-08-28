package p101_200.p113路径总和2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<Integer> path = new LinkedList<>();
        path.addLast(root.val);
        dfs(res, path, root, sum - root.val);
        path.removeLast();
        return res;
    }

    /**
     * path: 进入函数时，path 包含 root 节点
     * sum: 进入函数时，sum 已包含 root 节点的 val
     *
     * 此时为标准的回溯模板
     * 该例可以和 p079 对比，path 是否包含 root，会导致写法不同
     */
    private void dfs(List<List<Integer>> res, LinkedList<Integer> path, TreeNode root, Integer sum) {
        if (root.left == null && root.right == null && 0 == sum) {
            res.add(new LinkedList<>(path));
            return;
        }

        if (root.left != null) {
            TreeNode node = root.left;
            path.addLast(node.val);
            dfs(res, path, node, sum - node.val);
            path.removeLast();
        }

        if (root.right != null) {
            TreeNode node = root.right;
            path.addLast(node.val);
            dfs(res, path, node, sum - node.val);
            path.removeLast();
        }
    }

}