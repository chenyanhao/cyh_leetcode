package 剑指offer.p045二叉树最底层最左边的值;

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return max.val;
    }

    private TreeNode max = null;
    private int maxHeight = -1;

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (depth > maxHeight) {
            maxHeight = depth;
            max = root;
        }

        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }
}