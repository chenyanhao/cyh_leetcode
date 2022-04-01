package p101_200.p102二叉树的层序遍历;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    private void dfs(TreeNode root, int depth, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        if (res.size() <= depth) {
            List<Integer> newLevel = new ArrayList<>();
            res.add(newLevel);
        }

        List<Integer> thisLevel = res.get(depth);
        thisLevel.add(root.val);

        dfs(root.left, depth + 1, res);
        dfs(root.right, depth+1, res);

    }
}