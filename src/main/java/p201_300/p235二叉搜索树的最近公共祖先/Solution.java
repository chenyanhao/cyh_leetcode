package p201_300.p235二叉搜索树的最近公共祖先;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int val1 = Math.min(p.val, q.val);
        int val2 = Math.max(p.val, q.val);
        return dfs(root, val1, val2);
    }

    private TreeNode dfs(TreeNode root, int val1, int val2) {
        if (root == null) {
            return null;
        }

        if (root.val > val2) { // 当前节点太大，因此去左子树找
            return dfs(root.left, val1, val2);
        }

        if (root.val < val1) { // 当前节点太小，因此去右子树找
            return dfs(root.right, val1, val2);
        }

        // val1 <= root.val <= val2，因此当前root就是最近公共祖先
        return root;
    }
}