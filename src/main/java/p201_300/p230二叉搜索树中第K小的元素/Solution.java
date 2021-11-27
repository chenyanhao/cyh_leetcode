package p201_300.p230二叉搜索树中第K小的元素;

/**
 * 对二叉搜索树进行中序遍历，得到的遍历序列为有序序列。因此该题用中序遍历可解。
 */
class Solution {
    int k, ans;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null || k <= 0) {
            return;
        }

        dfs(root.left);
        --k;
        if (k == 0) {
            ans = root.val;
        }
        dfs(root.right);
    }

}