package p101_200.p124二叉树中的最大路径和;

class Solution {

    private int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxValue;
    }

    // 返回经过 root 的分支最大和
    public int maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //左子节点的值
        int left = maxPathSumHelper(root.left);
        //右子节点的值
        int right = maxPathSumHelper(root.right);

        /**
         * 分四种情况：
         *  1）选一个：在 root/left/right 中三选一，仅选择一个节点
         *  2）选二个：root + root.left
         *  3) 选三个：root + root.right
         *  4) 选四个：root + root.left + root.right
         */
        //第1,2,3三种情况,返回当前值加上左右子节点的最大值
        int res = root.val + Math.max(0, Math.max(left, right));

        //第4种情况
        int cur = root.val + Math.max(0, left) + Math.max(0, right);

        //记录最大value值
        maxValue = Math.max(maxValue, Math.max(cur, res));

        //第1,2,3种情况属于递归子问题，所以返回的是res
        return res;
    }

}