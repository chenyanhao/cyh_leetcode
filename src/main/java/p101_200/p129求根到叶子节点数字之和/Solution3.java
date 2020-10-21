package p101_200.p129求根到叶子节点数字之和;

class Solution3 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    /**
     * 递归函数意义：
     * 返回从 root 出发，满足题意的 sum
     */
    private int dfs(TreeNode root, int sum) {
       if (root == null) {
           return 0;
       }

       sum = sum * 10 + root.val; // 构造满足题意的 sum
       if (root.left == null && root.right == null) {
           return sum;
       }

       // 两种选择：选择左子树 + 选择右子树
       return dfs(root.left, sum) + dfs(root.right, sum);
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

        int res = new Solution3().sumNumbers(n1);
        System.out.println(res);
    }
}