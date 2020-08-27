package p101_200.p111二叉树的最小深度;

import java.util.LinkedList;
import java.util.Queue;

class Solution2 {

    private class QueueNode {
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<QueueNode> q = new LinkedList<>();
        q.offer(new QueueNode(root, 1));
        while (! q.isEmpty()) {
            QueueNode qn = q.poll();
            TreeNode node = qn.node;
            int depth = qn.depth;
            if (node.left == null && node.right == null) {
                return depth;
            }

            if (node.left != null) {
                q.offer(new QueueNode(node.left, depth + 1));
            }
            if (node.right != null) {
                q.offer(new QueueNode(node.right, depth + 1));
            }
        }

        return 0;
    }

}