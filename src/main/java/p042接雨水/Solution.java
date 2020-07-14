package p042接雨水;

class Solution {

    /**
     * 位置 i 能装的水为
     * water[i] = min(
     *      max(height[0..i]),  // 左边最高的柱子
     *      max(height[i..end])  // 右边最高的柱子
     *  ) - height[i]
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int ans = 0;
        for (int i = 1; i < height.length - 1; ++i) {
            int leftMax = 0, rightMax = 0;
            for (int j = i; j >= 0; --j) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i; j < height.length; ++j) {
                rightMax = Math.max(rightMax, height[j]);
            }

            ans += Math.min(leftMax, rightMax) - height[i];
        }
        return ans;
    }

    /**
     *
     * 开两个数组 r_max 和 l_max 充当备忘录，
     * l_max[i] 表示位置 i 左边最高的柱子高度，r_max[i] 表示位置 i 右边最高的柱子高度。
     * 预先把这两个数组计算好，避免重复计算
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        rightMax[len - 1] = height[len - 1];
        for (int i = 1; i < height.length; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int i = len - 1 - 1; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < len - 1; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    /**
     * 双指针
     *
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int len = height.length;
        int left = 0, right = len - 1;
        int ans = 0;
        int leftMax = height[0], rightMax = height[len - 1];
        while (left <= right) {

            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            // ans += min(leftMax, rightMax) - height[i]
            if (leftMax < rightMax) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }
}