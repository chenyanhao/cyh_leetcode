package p001_p100.p032最长有效括号;

import java.util.Stack;

/**
 * 用栈实现，将下标入栈。过程如下，
 * 1）用 start 来表示一个新的可能合法的子串的起始位置索引，初始化时设置为 0；用 i 表示当前遍历到索引；
 * 2）遇见左括号，入栈；
 * 3）遇见右括号，
 *  - 若栈为空。说明当前的 start 开始的子串不再可能为合法子串了，因此需要更新 start = i + 1。
 *  - 若栈不为空。则先弹出栈顶元素来匹配，
 *      - 弹出后栈为空。说明以当前右括号为右端点的合法括号序列的左端点为start，则更新答案 i-start+1
 *      - 弹出后栈不为空。说明以当前右括号为右端点的合法括号序列的左端点为栈顶元素的下一个元素，则更新答案 i-st.peek()
 *
 */
class Solution2 {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int start = 0;

        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // 栈为空说明组成不了有效括号，寻找下一个字串
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    ans = Math.max(ans, stack.isEmpty() ? i-start+1 : i-stack.peek());
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "()(()"; //  ()(())    )(()))
        int ans = new Solution2().longestValidParentheses(s);
        System.out.println(ans);
    }
}