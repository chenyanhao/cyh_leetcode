package p201_300.p230二叉搜索树中第K小的元素;

import sun.jvm.hotspot.oops.BranchData;

import java.util.Stack;

/**
 * 对二叉搜索树进行中序遍历，得到的遍历序列为有序序列。因此该题用中序遍历可解。
 */
class Solution2 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            --k;
            if (k == 0) {
                break;
            }

            root = root.right;
        }
        return root.val;
    }

}