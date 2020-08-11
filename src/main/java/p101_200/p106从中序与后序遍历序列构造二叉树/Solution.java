package p101_200.p106从中序与后序遍历序列构造二叉树;

import java.util.HashMap;
import java.util.Map;

class Solution {

    private Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        for (int i = 0; i < length; ++i) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(inorder, 0, length - 1,
                postorder, 0, length - 1);
    }

    private TreeNode myBuildTree(int[] inorder, int inorderLeft, int inorderRight,
                                 int[] postorder, int postorderLeft, int postorderRight) {

        if (inorderLeft > inorderRight) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postorderRight]);

        Integer rootIndex = indexMap.get(postorder[postorderRight]);
        int leftTreeSize = rootIndex - inorderLeft;

        root.left = myBuildTree(inorder, inorderLeft, rootIndex - 1,
                postorder, postorderLeft, postorderLeft + leftTreeSize - 1);

        root.right = myBuildTree(inorder, rootIndex + 1, inorderRight,
                postorder, postorderLeft + leftTreeSize, postorderRight - 1);
        return root;
    }

}