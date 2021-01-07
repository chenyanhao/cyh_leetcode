package p101_200.p173二叉搜索树迭代器;

import java.util.ArrayList;

/**
 * 时间复杂度：
 *  next()：O(1)
 *  hasNext()：O(1)
 *
 * 空间复杂度：O(N)，而题目要求 O(h)，因此这里需要优化
 */
class BSTIterator {

    private ArrayList<Integer> sorted;
    private int index;

    public BSTIterator(TreeNode root) {
        sorted = new ArrayList<>();
        index = -1;
        inorder(root);
    }
    
    public int next() {
        return sorted.get(++index);
    }
    
    public boolean hasNext() {
        return index + 1 < sorted.size();
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        this.inorder(root.left);
        sorted.add(root.val);
        this.inorder(root.right);
    }
}