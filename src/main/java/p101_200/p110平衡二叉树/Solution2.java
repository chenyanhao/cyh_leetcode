package p101_200.p110平衡二叉树;

class Solution2 {

    /**
     * 自底向上递归，对于同一个节点 height 函数只会调用一次
     *
     * 自底向上递归的做法类似于后序遍历，对于当前遍历到的节点，先递归地判断其左右子树是否平衡，
     * 再判断以当前节点为根的子树是否平衡。
     * 如果一棵子树是平衡的，则返回其高度（高度一定是非负整数），否则返回 −1。
     * 如果存在一棵子树不平衡，则整个二叉树一定不平衡。
     *
     */
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

}