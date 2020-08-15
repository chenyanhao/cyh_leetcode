package p101_200.p107二叉树的层次遍历2;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        int depth = getDepth(root);
        List<List<Integer>> res = new ArrayList<>(depth);
        for (int i = 0; i < depth; ++i) {
            res.add(new ArrayList<>());
        }
        dfs(root, res, depth - 1);
        return res;
    }

    /**
     * level 为当前遍历到的层数，从 0 开始计数。
     */
    private void dfs(TreeNode cur, List<List<Integer>> res, int level) {
        if (cur == null || level < 0) {
            return;
        }

        res.get(level).add(cur.val);

        dfs(cur.left, res, level - 1); // 特别特别特别注意注意注意：这两句代码不能同时写成 --level，具体原因不明
        dfs(cur.right, res, level - 1);
    }

    // 获取二叉树的深度，root 非空时，计数值从 1 开始
    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;

        List<List<Integer>> lists = new Solution2().levelOrderBottom(t1);
        System.out.println(lists.size());
    }
}