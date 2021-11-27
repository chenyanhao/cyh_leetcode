package p201_300.p236二叉树的最近公共祖先;

import apple.laf.JRSUIUtils;

/**
 * 函数意义为，
 */
class Solution2 {

    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    // 是否在以root为根节点的树中能找到p或者q
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        if (root == p || root == q) {
            ans = root;
            return true;
        }

        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);

        if (left && right) {
            ans = root;
        }

        return left || right;
    }

}