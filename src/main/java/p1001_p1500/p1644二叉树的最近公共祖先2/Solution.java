package p1001_p1500.p1644二叉树的最近公共祖先2;

/**
 * 这种写法最清楚，但是复杂度会高，因为每遍历一个节点就需要至少调用一次find函数，而find函数本身的复杂度就是O(n)
 */
class Solution {

    private boolean foundP = false, foundQ = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = dfs(root, p.val, q.val);
        if (!foundP || !foundQ) {
            return null;
        }
        return ans;
    }

    // 在以root为根节点的树中，寻找值为val1或者val2的节点
    private TreeNode dfs(TreeNode root, int val1, int val2) {
        if (root == null) {
            return null;
        }

        TreeNode left = dfs(root.left, val1, val2);
        TreeNode right = dfs(root.right, val1, val2);

        // 在左右子树全部都遍历完成后，再进行下面逻辑，这样就保证了能遍历到二叉树的每一个节点

        if (left != null && right != null) {
            return root;
        }

        if (root.val == val1 || root.val == val2) {
            if (root.val == val1) {
                foundP = true;
            }
            if (root.val == val2) {
                foundQ = true;
            }
            return root;
        }

        return left != null ? left : right;
    }


}