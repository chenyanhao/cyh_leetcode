package p101_200.p114二叉树展开为链表;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> inorder = new ArrayList<>();
        flatten(root, inorder);

        for (int i = 1; i < inorder.size(); ++i) {
            TreeNode curr = inorder.get(i);
            TreeNode prev = inorder.get(i - 1);
            prev.left = null;
            prev.right = curr;
        }
    }

    private void flatten(TreeNode root, List<TreeNode> inorder) {
        if (root == null) {
            return;
        }
        inorder.add(root);
        flatten(root.left, inorder);
        flatten(root.right, inorder);
    }
}