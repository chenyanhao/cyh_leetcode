package p101_200.p199二叉树的右视图;

import java.util.ArrayList;
import java.util.List;

/**
 * 按照 「根结点 -> 右子树 -> 左子树」 的顺序访问，就可以保证每层都是最先访问最右边的节点的。
 *
 * （与先序遍历 「根结点 -> 左子树 -> 右子树」 正好相反，先序遍历每层最先访问的是最左边的节点）
 *
 * 时间复杂度： O(N)，每个节点都访问了 1 次。
 * 空间复杂度： O(N)，二叉树的深度 logN, 最坏的情况下会退化成一条链表，深度就是 N，因此递归时使用的栈空间是 O(N) 的。
 *
 */
class Solution2 {

    private List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        // 先访问 当前节点，再递归地访问 右子树 和 左子树。

        // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
        if (res.size() == depth) {
            res.add(root.val);
        }
        ++depth;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }
}