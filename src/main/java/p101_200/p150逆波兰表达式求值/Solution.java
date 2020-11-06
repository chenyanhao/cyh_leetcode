package p101_200.p150逆波兰表达式求值;

import java.util.Stack;

/**
 * 1) 遇数字压栈
 * 2) 遇运算符弹两数字，运算后再压栈
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int op1, op2;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 + op2);
                    break;
                case "-":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 - op2);
                    break;
                case "*":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 * op2);
                    break;
                case "/":
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 / op2);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
                    break;
            }
        }

        return stack.pop();
    }
}