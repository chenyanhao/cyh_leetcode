package p201_300.p222完全二叉树的节点个数;

/**
 * 直接的做法是基于 DFS 或者 BFS，遍历所有节点即可得到节点个数，这种方式的时间复杂度为 O(N)。
 * 题目给的为完全二叉树，是一种特殊的二叉树，因此可以用一些优化手段。
 *
 * 一个结论：满二叉树的层数为 h，则总节点数为 2^h - 1
 *
 * 解法思路：
 * 对 root 节点的左右子树进行高度统计，分别记为 left 和 right，此时分两种情况：
 *  1）left == right。此时左子树一定是满二叉树，故左子树的节点总数为 2^left - 1，加上当前 root，正好是 2^left。接下来对右子树递归就好。示意图如下，
 *        1
 *     2    3
 *    4 5  6
 *
 *  2）left != right。此时最后一层不满，但倒数第二层已经满了，也就是说右子树是满二叉树，因此可以直接得到右子树的节点个数。
 *      右子树节点个数、再加上 root 节点，总数为 2^right。再对左子树进行递归查找。示意图如下，
 *        1
 *     2    3
 *    4 5  6 7
 *   8
 *
 * 另外，计算 2^left，最快的方法是移位计算，因为运算符的优先级问题，记得加括号。
 *
 * 时间复杂度：O(logn * logn)，n 为二叉树节点个数
 *
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if (left == right) {
            return countNodes(root.right) + (1 << left);
        } else {
            return countNodes(root.left) + (1 << right);
        }
    }

    // 该辅助函数计算完全二叉树的高度
    private int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            ++level;
            root = root.left;
        }
        return level;
    }
}