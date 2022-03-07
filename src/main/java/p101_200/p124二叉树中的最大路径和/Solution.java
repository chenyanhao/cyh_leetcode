package p101_200.p124二叉树中的最大路径和;

class Solution {

    private int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxValue;
    }

    // 返回经过 root 节点的分支的最大和
    public int maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //左子节点的值
        int left = maxPathSumHelper(root.left);
        //右子节点的值
        int right = maxPathSumHelper(root.right);

        /**
         * 分三种情况：
         *  1）left + right + root，此时不连接 root 的父节点。此种情况无法通过递归处理，所以代码中用 cur 来记录这种情况的最大值。
         *  2）root + left + root父节点，此时连接 root 的父节点。因为连接了父节点，所以此种情况可以递归处理
         *  3）root + right + root父节点，此时连接 root 的父节点。因为连接了父节点，所以此种情况可以递归处理
         *
         *  当然结点有可能是负值，所以最大和肯定就要想办法舍弃负值，跟 0 比较的意思就是舍弃负值。
         */
        // 上述第2或第3种情况，返回当前值加上左右子节点中的最大值
        int res = root.val + Math.max(0, Math.max(left, right));

        // 杉树第1种情况
        int cur = root.val + Math.max(0, left) + Math.max(0, right);

        // 记录最大value值
        maxValue = Math.max(maxValue, Math.max(cur, res));

        // 上述第2或第3种情况属于递归子问题，所以返回的是res
        return res;
    }

}