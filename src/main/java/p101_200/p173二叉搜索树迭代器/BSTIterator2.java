package p101_200.p173二叉搜索树迭代器;

import java.util.Stack;

/**
 * 使用自定义的栈来模拟中序遍历的过程，以减小空间复杂度。
 */
class BSTIterator2 {

    private Stack<TreeNode> stack;

    public BSTIterator2(TreeNode root) {
        stack = new Stack<>();
        leftmostInorder(root);
    }

    /**
     * 一路往左走到底
     */
    private void leftmostInorder(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode topNode = stack.pop();

        if (topNode.right != null) {
            leftmostInorder(topNode.right);
        }

        return topNode.val;
    }

    public boolean hasNext() {
        return stack.size() > 0;
    }
}