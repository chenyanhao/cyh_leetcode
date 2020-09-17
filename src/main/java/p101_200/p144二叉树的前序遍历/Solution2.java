package p101_200.p144二叉树的前序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution2 {
    /**
     * 使用传统的迭代法实现先中后序遍历，很难写出统一的代码，
     * 不像是递归法，实现了其中的一种遍历方式，其他两种只要稍稍改一下节点顺序就可以了。
     * 而迭代法，貌似需要每一种遍历都要写出不同风格的代码。
     *
     * 1)在迭代的过程中，其实我们有两个操作，一个是处理，即将元素放进result数组中；一个是访问，即遍历节点。
     * 2)前序遍历的顺序是中左右，要先访问的元素是中间节点，要处理的元素也是中间节点，
     *  要访问的元素和要处理的元素顺序是一致的，都是中间节点，所以传统的迭代法前序遍历代码非常简洁。
     * 3)再看看中序遍历，中序遍历是左中右，先访问的是二叉树顶部的节点，然后一层一层向下访问，直到到达树左面的最底部，
     *  再开始处理节点（也就是在把节点的数值放进result数组中），这就造成了处理顺序和访问顺序是不一致的。
     *
     * 传统迭代写法，无法同时解决处理过程和访问过程不一致的情况。
     * 改进的方法就是，将访问的节点放入栈中，把要处理的节点也放入栈中但是要做标记，
     * 标记就是要处理的节点放入栈之后，紧接着放入一个空指针作为标记。
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (! stack.empty()) {
            TreeNode top = stack.pop();
            if (top != null) {
                if (top.right != null) {
                    stack.push(top.right);
                }

                if (top.left != null) {
                    stack.push(top.left);
                }

                stack.push(top);
                stack.push(null);

            } else {
                top = stack.pop();
                res.add(top.val);
            }
        }

        return res;
    }
}