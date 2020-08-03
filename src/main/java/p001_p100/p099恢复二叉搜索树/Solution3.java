package p001_p100.p099恢复二叉搜索树;

class Solution3 {
    /**
     * 1）按中序遍历树。遍历后的数组应该是递增序的列表，其中只有两个元素被交换。
     * 2）确定 1 中数组中的两个交换元素 x 和 y。
     * 3）再次遍历树，将值 x 的节点改为 y，将值 y 的节点改为 x。
     *
     * 其中 1 和 2 可以合并为一步。即在中序遍历的过程中就确定交换的节点。
     *
     */

    private TreeNode x = null, y = null, pre = null;

    public void recoverTree(TreeNode root) {
        dfs(root);
        swap(x, y);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        // 这部分逻辑和解法一、解法二中的逻辑很一致，因为对 BST 中序遍历的结果期望是一个有序数组。
        if (pre != null && pre.val > root.val) {
            y = root;
            if (x == null) {
                x = pre;
            } else {
                return;
            }
        }
        pre = root;

        dfs(root.right);

    }

    private void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

}