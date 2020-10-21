package p101_200.p129求根到叶子节点数字之和;

import java.util.LinkedList;
import java.util.List;

class Solution {
    private int sum;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, new LinkedList<>());
        return sum;
    }

    private void dfs(TreeNode root, LinkedList<Integer> path) {

        path.addLast(root.val);

        if (root.left == null && root.right == null) {
            sum += listSum(path);
        }

        if (root.left != null) {
            dfs(root.left, path);
        }
        if (root.right != null) {
            dfs(root.right, path);
        }
        path.removeLast();
    }

    private int listSum(List<Integer> src) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : src) {
            sb.append(i);
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        int res = new Solution().sumNumbers(n1);
        System.out.println(res);
    }
}