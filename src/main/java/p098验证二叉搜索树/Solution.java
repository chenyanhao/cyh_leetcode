package p098验证二叉搜索树;

class Solution {
    /**
     * 二叉搜索树的两个特征：
     *  1)节点的左子树只包含小于当前节点的数。
     *  2)节点的右子树只包含大于当前节点的数。
     *
     * 换个角度，可以理解为：
     *  1)当前节点的值是其左子树的值的上界（最大值）
     *  2)当前节点的值是其右子树的值的下界（最小值）
     *
     */
    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }

    private boolean valid(TreeNode root, Integer lowerBound, Integer upperBound) {
        if (root == null) {
            return true;
        }

        int val = root.val;
        if (lowerBound != null && val <= lowerBound) {
            return false;
        }
        if (upperBound != null && val >= upperBound) {
            return false;
        }

        if (! valid(root.left, lowerBound, val)) {
            return false;
        }
        if (! valid(root.right, val, upperBound)) {
            return false;
        }

        return true;
    }
}