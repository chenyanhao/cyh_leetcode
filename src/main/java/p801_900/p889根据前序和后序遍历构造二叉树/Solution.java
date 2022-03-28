package p801_900.p889根据前序和后序遍历构造二叉树;

import java.util.HashMap;

/**
 * 前序遍历：[ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
 * 后序遍历：[ [左子树的中序遍历结果], [右子树的中序遍历结果], 根节点 ]
 *
 * 假设左分支的 root 节点为 leftTreeRoot，该节点在 postorder 数组中的索引为 index，那么，
 * 左子树分支由 preorder[preorderLeft+1 : preorderLeft+1 + (index-postorderLeft)] 和 post[postorderLeft : index] 决定，
 * 右子树分支由 preorder[preorderLeft+1 + (index-postorderLeft) + 1 : preorderRight] 和 postorder[index+1 : postorderRight-1] 决定。
 *
 */
class Solution {

    private HashMap<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int length = preorder.length;
        for (int i = 0; i < length; ++i) {
            indexMap.put(postorder[i], i);
        }
        return dfs(preorder, postorder, 0, length-1, 0, length-1);
    }

    private TreeNode dfs(int[] preorder, int[] postorder,
                         int preorderLeft, int preorderRight,
                         int postorderLeft, int postorderRight) {
        // 递归条件：前序或后序数组为空。
        if (preorderLeft > preorderRight) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorderLeft]);
        if (preorderLeft == preorderRight) { // 注意这里需要提前判断
            return root;
        }

        int index = indexMap.get(preorder[preorderLeft+1]);

        root.left = dfs(preorder, postorder,
                preorderLeft+1, preorderLeft+1 + (index-postorderLeft),
                postorderLeft, index);
        root.right = dfs(preorder, postorder,
                preorderLeft+1 + (index-postorderLeft) + 1, preorderRight,
                index+1, postorderRight-1);
        return root;
    }
}