package p101_200.p103二叉树的锯齿形层次遍历;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        //双端队列，两边都可以操作
        Deque<TreeNode> deque = new LinkedList<>();
        //添加到队列的头
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            //统计这一行有多少个节点
            int count = deque.size();
            //遍历这一行的所有节点
            TreeNode cur;
            for (int i = 0; i < count; i++) {
                if (res.size() % 2 == 1) {
                    //从左边往右边打印
                    //移除队列头部的元素，如果子节点不为空加入到队列的尾部
                    cur = deque.removeFirst();
                    if (cur.right != null)
                        deque.addLast(cur.right);
                    if (cur.left != null)
                        deque.addLast(cur.left);
                } else {
                    //从右边往左边打印
                    //移除队列尾部的元素，如果子节点不为空加入到队列的头部
                    cur = deque.removeLast();
                    if (cur.left != null)
                        deque.addFirst(cur.left);
                    if (cur.right != null)
                        deque.addFirst(cur.right);
                }
                level.add(cur.val);
            }
            res.add(level);
        }
        return res;
    }


}