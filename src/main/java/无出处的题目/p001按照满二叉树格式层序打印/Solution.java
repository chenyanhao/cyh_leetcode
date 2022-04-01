package 无出处的题目.p001按照满二叉树格式层序打印;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<String>> levelOrderAsFullBinaryTree(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        int depth = depth(root);

        List<List<String>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (! queue.isEmpty()) {
            if (ans.size() == depth) {
                break;
            }

            int size = queue.size();
            List<String> thisLevel = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node == null) {
                    thisLevel.add("-");
                    queue.add(null);
                    queue.add(null);
                    continue;
                }

                thisLevel.add(String.valueOf(node.val));
                if (node.left != null) {
                    queue.add(node.left);
                } else {
                    queue.add(null);
                }

                if (node.right != null) {
                    queue.add(node.right);
                } else {
                    queue.add(null);
                }
            }

            ans.add(thisLevel);
        }

        return ans;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        t4.left = t6;

        int depth = new Solution().depth(t1);
        System.out.println(depth);

        List<List<String>> ans = new Solution().levelOrderAsFullBinaryTree(t1);
        System.out.println(ans);
    }

}