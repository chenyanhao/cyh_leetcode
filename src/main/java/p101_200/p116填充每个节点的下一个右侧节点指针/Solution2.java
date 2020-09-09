package p101_200.p116填充每个节点的下一个右侧节点指针;

import java.util.LinkedList;
import java.util.Queue;

class Solution2 {

    /**
     * 利用 bfs 求解
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
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