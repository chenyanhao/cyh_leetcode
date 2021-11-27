package p201_300.p236二叉树的最近公共祖先;

/**
 * 这种写法最清楚，但是复杂度会高，因为每遍历一个节点就需要至少调用一次find函数，而find函数本身的复杂度就是O(n)
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        // 如果p,q为根节点，则公共祖先为根节点
        if (p == root || q == root) {
            return root;
        }

        // 如果p,q在左子树，则公共祖先在左子树查找
        if (find(root.left, p) && find(root.left, q)) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // 如果p,q在右子树，则公共祖先在右子树查找
        if (find(root.right, p) && find(root.right, q)) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // 如果p,q分属两侧，则公共祖先为根节点
        return root;
    }

    // 查找target是否在root为根节点的树中
    private boolean find(TreeNode root, TreeNode target) {
        if (root == null) {
            return false;
        }

        if (root.val == target.val) {
            return true;
        }

        return find(root.left, target) || find(root.right, target);
    }

}