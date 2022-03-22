package p001_p100.p095不同的二叉搜索树2;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int start, int end) {
        List<TreeNode> ans = new LinkedList<>();

        if (start > end) {
            /**
             * /注意这里，必须往 list 中添加一个 null。
             * 因为下面代码中，依赖于对左右子树列表的遍历，也就是两层for循环的地方。如果其中一个列表为空，那么循环都将无法进行。
             */
            ans.add(null);
            return ans;
        }

        // i 为二叉搜索树的根节点，其左子树为 [start, i-1]，右子树为 [i+1, end]。不断枚举 i，并递归调用左右子树即可。
        for (int i = start; i <= end; ++i) {
            List<TreeNode> leftTree = dfs(start, i - 1);
            List<TreeNode> rightTree = dfs(i + 1, end);
            for (TreeNode l : leftTree) {
                for (TreeNode r : rightTree) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = l;
                    curr.right = r;
                    ans.add(curr);
                }
            }
        }

        return ans;
    }
}