package p101_200.p145二叉树的后序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (! stack.empty()) {
            TreeNode top = stack.pop();
            if (top != null) {
                stack.push(top);
                stack.push(null);

                if (top.right != null) {
                    stack.push(top.right);
                }

                if (top.left != null) {
                    stack.push(top.left);
                }

            } else {
                top = stack.pop();
                res.add(top.val);
            }
        }

        return res;
    }
}