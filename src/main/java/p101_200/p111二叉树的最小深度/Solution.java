package p101_200.p111二叉树的最小深度;

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (root.left == null || root.right == null) { // 如果有一个子节点其中一个为空，那么 left/right 其中一个为 0
            return left + right + 1;
        } else {
            return Math.min(left, right) + 1;
        }
    }

}