package p101_200.p107二叉树的层次遍历2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (! q.isEmpty()) {
            int size = q.size();
            List<Integer> thisLevel = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode node = q.poll();
                thisLevel.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            res.addFirst(thisLevel);
        }

        return res;
    }
}