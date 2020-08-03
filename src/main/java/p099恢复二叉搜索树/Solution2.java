package p099恢复二叉搜索树;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution2 {
    /**
     * 1）按中序遍历树。遍历后的数组应该是递增序的列表，其中只有两个元素被交换。
     * 2）确定 1 中数组中的两个交换元素 x 和 y。
     * 3）再次遍历树，将值 x 的节点改为 y，将值 y 的节点改为 x。
     *
     * 其中 1 和 2 可以合并为一步。即在中序遍历的过程中就确定交换的节点。
     *
     */
    public void recoverTree(TreeNode root) {
        TreeNode x = null, y = null, pre = null;

        /**
         * 用迭代的方式实现中序遍历：
         *  1)尽可能的向左走
         *  2)处理根节点
         *  3)向右走一步，重复一直到结束
         */
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (! stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            // 这部分逻辑有点像解法一中 findTwoSwapped 方法的逻辑，因为对 BST 中序遍历的结果期望是一个有序数组。
            if (pre != null && pre.val > root.val) {
                y = root;
                if (x == null) {
                    x = pre;
                } else {
                    break;
                }
            }
            pre = root;

            root = root.right;
        }

        swap(x, y);
    }

    private void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

}