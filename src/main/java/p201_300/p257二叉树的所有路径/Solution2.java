package p201_300.p257二叉树的所有路径;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution2 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> bfsQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();
        bfsQueue.add(root);
        pathQueue.add(String.valueOf(root.val));

        while (! bfsQueue.isEmpty()) {
            TreeNode node = bfsQueue.poll();
            String path = pathQueue.poll();
            if (node.left == null && node.right == null) {
                ans.add(path);
            } else {
                if (node.left != null) {
                    bfsQueue.offer(node.left);
                    pathQueue.offer(new StringBuilder(path).append("->").append(node.left.val).toString());
                }

                if (node.right != null) {
                    bfsQueue.offer(node.right);
                    pathQueue.offer(new StringBuilder(path).append("->").append(node.right.val).toString());
                }
            }
        }

        return ans;
    }
}