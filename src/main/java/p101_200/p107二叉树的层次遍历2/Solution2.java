package p101_200.p107二叉树的层次遍历2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        int depth = getDepth(root);
        List<List<Integer>> res = new ArrayList<>(depth);
        Collections.fill(res, new ArrayList<>());
        dfs(root, res, depth - 1);
        return res;
    }

    /**
     * level 为当前遍历到的层数，从 0 开始计数
     */
    private void dfs(TreeNode cur, List<List<Integer>> res, int level) {
        if (cur == null) {
            return;
        }

        res.get(level).add(cur.val);

        dfs(cur.left, res, --level);
        dfs(cur.right, res, --level);
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }

}