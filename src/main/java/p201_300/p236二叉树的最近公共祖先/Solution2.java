package p201_300.p236二叉树的最近公共祖先;

import apple.laf.JRSUIUtils;

class Solution2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p.val, q.val);
    }

    // 在以root为根节点的树中，寻找值为val1或者val2的节点
    private TreeNode dfs(TreeNode root, int val1, int val2) {
        if (root == null) {
            return null;
        }

        if (root.val == val1 || root.val == val2) {
            return root;
        }

        TreeNode left = dfs(root.left, val1, val2);
        TreeNode right = dfs(root.right, val1, val2);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

}