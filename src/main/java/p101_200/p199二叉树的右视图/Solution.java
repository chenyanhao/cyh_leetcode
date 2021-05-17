package p101_200.p199二叉树的右视图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 利用 BFS 进行层次遍历，记录下每层的最后一个元素。
 *
 * 时间复杂度： O(N)，每个节点都入队出队了 1 次。
 * 空间复杂度： O(N)，使用了额外的队列空间。
 *
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (! queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (i == size - 1) {
                    res.add(node.val);
                }

            }
        }

        return res;
    }
}