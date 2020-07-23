package p084柱状图中最大的矩形;

import java.util.Stack;

class Solution {
    /**
     * 题目关键：对于位置 i，找到左右两侧和 i 相距最近，且高度小于 height[i] 的柱子
     *
     * left[i]: i 左边比 heights[i] 小的最近的索引
     * right[i]: i 右边比 heights[i] 大的最近的索引
     * i 处的矩形面积 = (right[i] - left[i] - 1) * heights[i]
     *
     * 接下来用单调栈来辅助构造 left[] 和 right[]
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];

        for (int i = 0; i < heights.length; ++i) {
            while (!stack.empty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.empty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        for (int i = heights.length - 1; i >=0; --i) {
            while (!stack.empty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.empty() ? heights.length : stack.peek();
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < heights.length; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }

        return ans;
    }
}