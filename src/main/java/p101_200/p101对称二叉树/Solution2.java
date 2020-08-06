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
     * 技巧：
     * 1）将递归的函数入参放在一个队列中保存起来。
     * 2）主体逻辑和 bfs 模板很相似。
     * 3）循环体中需要重现递归的逻辑。
     * 4）递归调用，用入队列来模拟。如果多次递归，那么就多次入队列。
     *
     */
    private boolean check(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (! queue.isEmpty()) {

            // 下面这几段和递归中的逻辑是一致的
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