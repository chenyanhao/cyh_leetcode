package p101_200.p101对称二叉树;

import java.util.LinkedList;
import java.util.Queue;

class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    /**
     * 特别注意：通过和解法一对比，掌握递归改写为循环的技巧和套路
     * 特别注意：通过和解法一对比，掌握递归改写为循环的技巧和套路
     * 特别注意：通过和解法一对比，掌握递归改写为循环的技巧和套路
     * 特别注意：通过和解法一对比，掌握递归改写为循环的技巧和套路
     * 特别注意：通过和解法一对比，掌握递归改写为循环的技巧和套路
     * 特别注意：通过和解法一对比，掌握递归改写为循环的技巧和套路
     *
     */
    private boolean check(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (! queue.isEmpty()) {
            TreeNode u = queue.poll();
            TreeNode v = queue.poll();
            if (u == null && v == null) {
                continue;
            }

            if (u == null || v == null) {
                return false;
            }

            if (u.val != v.val) {
                return false;
            }

            queue.offer(u.left);
            queue.offer(v.right);

            queue.offer(u.right);
            queue.offer(v.left);
        }
        return true;
    }
}