package p094二叉树的中序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution2 {
    /**
     * 颜色标记法：
     *  1. 兼具栈迭代方法的高效，又像递归方法一样简洁易懂；
     *  2. 这种方法对于前序、中序、后序遍历，能够写出完全一致的代码。
     *
     * 思路：
     *  1. 使用颜色标记节点的状态，新节点为 0，已访问的节点为 1。
     *  2. 如果遇到的节点为 0，则将其标记为 1，然后将其右子节点、自身、左子节点依次入栈。
     *  3. 如果遇到的节点为 1，则将节点的值输出。
     *
     * 颜色的本质：记录节点的访问次数，节点第二次访问会被输出。
     * 因此使用 hash 表来记录节点的访问次数也可以
     *
     */
    class FlagNode {
        TreeNode node;
        int flag;
        FlagNode(TreeNode node, int flag){
            this.node = node;
            this.flag = flag;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<FlagNode> stack = new Stack<>();
        stack.push(new FlagNode(root, 0));
        while (! stack.isEmpty()) {
            FlagNode top = stack.pop();
            if (top.node == null) {
                continue;
            }
            if (top.flag == 0) {
                stack.push(new FlagNode(top.node.right, 0));
                stack.push(new FlagNode(top.node, 1));
                stack.push(new FlagNode(top.node.left, 0));
            } else if (top.flag == 1) {
                res.add(top.node.val);
            }
        }

        return res;
    }
}