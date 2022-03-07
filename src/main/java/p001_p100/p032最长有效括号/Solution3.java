package p001_p100.p032最长有效括号;

import java.util.Arrays;
import java.util.Stack;

/**
 * 用栈+数组实现，相比解法二更好理解，思路是：用一个栈来检查括号的有效性，用一个辅助数组 valid 来记录匹配括号对的位置。
 * 整体过程如下，
 * 1）遇到左括号，就入栈。（入栈的不是左括号，而是其下标）
 * 2）遇到右括号，就从栈中弹出一个元素，这个元素就是右括号对应的左括号的下标
 * 3）在 valid 中，这两个下标对应的位置做个标识 1，说明这里找到了一对有效括号
 * 4）等遍历结束之后，在 valid 中找到连续最长的 1 序列。
 *
 */
class Solution3 {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] valid = new int[s.length()];
        Arrays.fill(valid, 0); // 初始化都填0

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
                continue;
            }

            // 代码至此，说明遇到了右括号

            if (! stack.isEmpty()) { // 如果栈不为空，也就是此时栈中有左括号
                valid[i] = 1;
                valid[stack.pop()] = 1;
            }
        }

        int ans = 0;
        int count = 0;
        for (int i : valid) {
            if (i == 1) {
                ++count;
            } else if (i == 0) {
                count = 0;
            }

            ans = Math.max(ans, count);
        }
        return ans;
    }

    public static void main(String[] args) {
//        String s = "()(()";
//        String s = "()(())";
        String s = ")(()))";
        int ans = new Solution3().longestValidParentheses(s);
        System.out.println(ans);
    }
}