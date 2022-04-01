package 剑指offer.p045二叉树最底层最左边的值;

import java.util.LinkedList;
import java.util.Queue;

class Solution2 {
    public int findBottomLeftValue(TreeNode root) {
        TreeNode ans = null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (! queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    ans = node;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return ans.val;
    }

}