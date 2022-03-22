package p001_p100.p099恢复二叉搜索树;

class Solution3 {
    /**
     * 1）按中序遍历树。遍历后的数组应该是递增序的列表，其中只有两个元素被交换。
     * 2）确定 1 中数组中的两个交换元素 firstNode 和 secondNode。
     * 3）再次遍历树，将值 firstNode 的节点改为 secondNode，将值 secondNode 的节点改为 firstNode。
     *
     * 其中 1 和 2 可以合并为一步。即在中序遍历的过程中就确定交换的节点。
     *
     */

    private TreeNode firstNode = null, secondNode = null, preNode = null;

    public void recoverTree(TreeNode root) {
        dfs(root);
        swap(firstNode, secondNode);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        /**
         * 以中序遍历顺序为 [4,2,3,1] 为例，这里显然 4 和 1 分别对应 firstNode 和 secondNode。
         * 遍历到 2 时，此时 preNode=4、root=2，对应下面第一个if条件；
         * 遍历到 1 时，此时 preNode=3、root=1，对应下面第二个if条件。
         *
         * 换种表述就是说，
         * firstNode，是第一个按照中序遍历时候，前一个节点大于后一个节点；
         * secondNode，是在第一个节点找到之后，后面出现前一个节点大于后一个节点。
         */
        if (firstNode == null && preNode.val >= root.val) {
            firstNode = preNode;
        }
        if (firstNode != null && preNode.val >= root.val) {
            secondNode = root;
        }

        preNode = root;

        dfs(root.right);

    }

    private void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

}