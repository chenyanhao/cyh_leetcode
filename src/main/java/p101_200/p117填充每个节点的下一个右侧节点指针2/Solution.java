package p101_200.p117填充每个节点的下一个右侧节点指针2;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    /**
     * 依然可以用 bfs 来解，但是空间复杂度为 O(N)
     */
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root != null) {
            q.offer(root);
        }
        while (! q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                Node node = q.poll();
                if (i < size - 1) {
                    node.next = q.peek();
                }

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return root;
    }
}