package p101_200.p116填充每个节点的下一个右侧节点指针;

class Solution {

    /**
     * 思路：
     *  1）每个 node 左子树的 next , 就是 node 的右子树
     *  2）每个 node 右子树的 next, 就是 node.next 的 左子树
     *
     * 这里递归实现，因为依赖于 node 左子树的 next，所以递归时需要先递归 node.left
     */
    public Node connect(Node root) {
        dfs(root, null);
        return root;
    }

    private void dfs(Node node, Node next) {
        if (node == null) {
            return;
        }

        node.next = next;
        dfs(node.left, node.right);
        dfs(node.right, node.next == null ? null : node.next.left);
    }
}