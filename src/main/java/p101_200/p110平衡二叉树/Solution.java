package p101_200.p110平衡二叉树;

class Solution {

    /**
     * 自顶向下递归，对于同一个节点 height 函数会多次调用，可以用备忘录优化
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }

}