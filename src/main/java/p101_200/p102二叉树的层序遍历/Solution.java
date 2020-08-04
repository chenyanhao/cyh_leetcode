package p101_200.p102二叉树的层序遍历;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (! q.isEmpty()) {
            int size = q.size();
            List<Integer> thisLevel = new ArrayList<>();
            for (int i = 0; i < size; ++i) { // 此处的 i 无意义，只是为了循环 size 次
                TreeNode node = q.poll();
                thisLevel.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            res.add(thisLevel);
        }
        return res;
    }
}