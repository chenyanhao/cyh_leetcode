package p001_p100.p042接雨水;

class Solution2 {

    /**
     *
     * 开两个数组 r_max 和 l_max 充当备忘录，
     * l_max[i] 表示位置 i 左边最高的柱子高度，r_max[i] 表示位置 i 右边最高的柱子高度。
     * 预先把这两个数组计算好，避免重复计算
     */
    public int trap(int[] height) {
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

}