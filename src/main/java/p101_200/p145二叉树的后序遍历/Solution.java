package p101_200.p145二叉树的后序遍历;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, Integer> countMap = new HashMap<>();
        if (root != null) {
            stack.push(root);
            countMap.put(root, 1);
        }
        while (! stack.empty()) {
            TreeNode top = stack.pop();
            if (countMap.get(top) == 1) {
                stack.push(top);
                countMap.put(top, 2);

                if (top.right != null) {
                    stack.push(top.right);
                    countMap.put(top.right, 1);
                }

                if (top.left != null) {
                    stack.push(top.left);
                    countMap.put(top.left, 1);
                }
            } else {
                res.add(top.val);
            }
        }
        return res;
    }
}