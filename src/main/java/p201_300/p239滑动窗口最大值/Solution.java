package p201_300.p239滑动窗口最大值;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 用单调队列来解
 */
class Solution {

    private class MonotoneStack {
        private Stack<Integer> datas;

        // 向栈中添加元素n
        private void push(int n) {
            while (!datas.isEmpty() && datas.peek() < n) {
                datas.pop();
            }

            datas.push(n);
        }

        // 返回datas中的最大值
        private int max() {
            return datas.peek();
        }

        // 栈顶元素如果是 n，删除它
        private void pop(int n) {
            if (!datas.isEmpty() && datas.peek() == n) {
                datas.pop();
            }
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotoneStack window = new MonotoneStack();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            if (i < k - 1) { //先填满窗口的前 k - 1
                window.push(nums[i]);
            } else { // 窗口向前滑动
                window.push(nums[i]);
                ans.add(window.max());
                window.pop(nums[i - k + 1]); // nums[i - k + 1] 是窗口最左端的元素
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}