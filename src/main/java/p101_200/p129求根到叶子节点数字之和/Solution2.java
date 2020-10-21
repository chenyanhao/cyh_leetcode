package p101_200.p129求根到叶子节点数字之和;

class Solution2 {
    private int res;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += sum;
        }

        dfs(root.left, sum);
        dfs(root.right, sum);
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

        int res = new Solution2().sumNumbers(n1);
        System.out.println(res);
    }
}