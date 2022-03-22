package p101_200.p116填充每个节点的下一个右侧节点指针;

class Solution {

    /**
     * 思路：
     *  1）每个 node 左子树的 next , 就是 node 的右子树
     *  2）每个 node 右子树的 next, 就是 node.next 的 左子树
     *
     * 这里递归实现，因为依赖于 node 左子树的 next，所以递归时需要先递归 node.left
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        if (root.left != null) {
            root.left.next = root.right;
            connect(root.left);
        }

        if (root.right != null) {
            root.right.next = root.next == null ? null : root.next.left;
            connect(root.right);
        }

        return root;
    }

}