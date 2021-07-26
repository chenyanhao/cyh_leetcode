package p201_300.p222完全二叉树的节点个数;

/**
 * 直接的做法是基于 DFS 或者 BFS，遍历所有节点即可得到节点个数，这种方式的时间复杂度为 O(N)。
 * 题目给的为完全二叉树，是一种特殊的二叉树，因此可以用一些优化手段。
 *
 * 一个结论：满二叉树的层数为 h，则总节点数为 2^h - 1
 *
 * 解法思路：二分查找
 * 总节点数 = 倒数第二层及以上的节点数 + 最后一层的节点数，不妨设 depth_prev 为倒数第二层树的深度
 *  1) 除最后一层外，这棵树为满二叉树，节点数为：2^depth_prev - 1；
 *  2) 最后一层的节点数的范围是 [1, 2^depth_prev]；并且依次靠左排列；
 *  3) 所以现在的问题就转换为判断最后一层节点数，由于从右到左依次排列，这时就可以用二分查找了。
 *
 *
 * 时间复杂度：O(logn * logn)，n 为二叉树节点个数
 *
 */
class Solution2 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = countLevel(root);
        int depthPrev = depth - 1;
        int start = 1, end = (1 << depthPrev);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isExist(root, mid, depthPrev)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // start-1 为最后一层节点数
        return (1 << depthPrev) - 1 + (start - 1);
    }

    /**
     * 功能： 判断最后一层第index个索引是否存在
     *
     * @param root  二叉树根节点
     * @param index 判断最后一层索引为index的节点是否存在, 索引范围是 [1, 2^depth]
     * @param depth 倒数第二层的深度, 这是因为满二叉树最后一层的节点数等于 2^depth
     * @return
     */
    private boolean isExist(TreeNode root, int index, int depth) {
        TreeNode node = root;
        while (depth > 0) {
            int mid = (1 << depth) / 2;
            if (index > mid) {
                // 如果在右子树，需要更新索引值
                index -= mid;
                node = node.right;
            } else {
                node = node.left;
            }

            depth -= 1;
        }
        return node != null;
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