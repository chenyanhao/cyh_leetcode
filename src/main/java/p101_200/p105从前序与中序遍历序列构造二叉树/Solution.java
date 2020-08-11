package p101_200.p105从前序与中序遍历序列构造二叉树;

import java.util.HashMap;

/**
 * 前序遍历：[ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
 * 中序遍历：[ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
 *
 * 关键思路点：
 * 1）在中序遍历中定位到根节点，那么就可以分别知道左子树和右子树中的节点数目。
 * 2）由于同一颗子树的前序遍历和中序遍历的长度显然是相同的，因此可以对应到前序遍历的结果中，对上述形式中的所有左右括号进行定位。
 * 3）这样一来，就知道了左子树的前序/中序遍历结果，以及右子树的前序/中序遍历结果，就可以递归地对构造出左子树和右子树。
 * 4）可以考虑使用 HashMap 来快速地定位根节点，此后构造二叉树的过程中，只需要 O(1) 的时间就可以对根节点进行定位。
 *
 */
class Solution {

    private HashMap<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        for (int i = 0; i < length; ++i) {
            indexMap.put(inorder[i], i);
        }
        return null;
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder,
                                 int preorderLeft, int preorderRight,
                                 int inorderLeft, int inorderRight) {
        // 递归条件：前序或中序数组为空。
        // 这里为了避免数组拷贝，使用数组指针和上下标代替有效数组。因此数组为空的意义即上下标定位的区间为空。
        // 这里的上下标都是闭区间，因此递归结束条件为左边界小于右边界
        if (preorderLeft > preorderRight) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点，因此构造根节点
        TreeNode root = new TreeNode(preorder[preorderLeft]);

        // 在中序遍历中定位根节点
        int inorderRoot = indexMap.get(preorder[preorderLeft]);

        // 得到左子树的节点个数
        int leftTreeSize = inorderRoot - inorderLeft;

        // 递归地构造左右子树
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder,
                preorderLeft + 1, preorderLeft + leftTreeSize,
                inorderLeft, inorderRoot - 1);

        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder,
                preorderLeft + leftTreeSize + 1, preorderRight,
                inorderRoot + 1, inorderRight);

        return root;
    }

    // 第二种递归写法
    private TreeNode myBuildTree2(int[] preorder, int[] inorder,
                                 int preorderLeft, int preorderRight,
                                 int inorderLeft, int inorderRight) {

        // 前序遍历中的第一个节点就是根节点，因此构造根节点
        TreeNode root = new TreeNode(preorder[preorderLeft]);

        // 在中序遍历中定位根节点
        int inorderRoot = indexMap.get(preorder[preorderLeft]);

        // 得到左右子树的节点个数
        int leftTreeSize = inorderRoot - inorderLeft;
        int rightTreeSize = inorderRight - inorderRoot;

        // 递归地构造左右子树
        if (leftTreeSize > 0) {
            root.left = myBuildTree(preorder, inorder,
                    preorderLeft + 1, preorderLeft + leftTreeSize,
                    inorderLeft, inorderRoot - 1);
        }

        if (rightTreeSize > 0) {
            root.right = myBuildTree(preorder, inorder,
                    preorderLeft + leftTreeSize + 1, preorderRight,
                    inorderRoot + 1, inorderRight);
        }

        return root;
    }
}