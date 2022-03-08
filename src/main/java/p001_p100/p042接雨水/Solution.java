package p001_p100.p042接雨水;

class Solution {

    /**
     * 位置 i 能装的水为
     * water[i] = min(
     *      max(height[0..i]),  // 左边最高的柱子
     *      max(height[i..end])  // 右边最高的柱子
     *  ) - height[i]
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

}