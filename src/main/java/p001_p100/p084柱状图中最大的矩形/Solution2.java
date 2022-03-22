package p001_p100.p084柱状图中最大的矩形;

import java.util.Arrays;
import java.util.Stack;

class Solution2 {
    /**
     *
     * 解法一通过从左向右遍历得到了 left 数组，通过从右向左遍历得到了 right 数组。
     * 该解法通过一次遍历就得到 left 数组和 right 数组。
     *
     */
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Arrays.fill(right, heights.length);

        for (int i = 0; i < heights.length; ++i) {
            while (!stack.empty() && heights[stack.peek()] >= heights[i]) {
                // 当元素出栈时，说明当前元素 i，是出栈元素向后找到的、第一个比其小的元素。因此此时可以更新 right 数组
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = stack.empty() ? -1 : stack.peek();
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < heights.length; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }

        return ans;
    }
}