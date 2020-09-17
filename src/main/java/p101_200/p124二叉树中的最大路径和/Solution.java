package p101_200.p124二叉树中的最大路径和;

class Solution {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    // 返回经过 root 的单边分支最大和
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //因为当前求得是最大path值，所以假如左path sum小于0，当前点就从自己开始，不连左子边
        int leftMax = Math.max(0,dfs(root.left));
        //计算右边分支最大值，右边分支如果为负数还不如不选择
        int rightMax = Math.max(0,dfs(root.right));

        //对与当前点，path有4可能:just自己, 自己+左子path，自己+右子path，自己+左+右     //left->root->right 作为路径与历史最大值做比较
        max = Math.max(max, root.val + leftMax + rightMax);

        //对于上一层node，要的是一条单边而不是倒V型的path，使用当前层的左右最多取一条      // 返回经过root的单边最大分支给上游
        return Math.max(leftMax, rightMax) + root.val;
    }
}