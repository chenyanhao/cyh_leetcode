package p001_p100.p042接雨水;

class Solution3 {

    /**
     * 双指针
     */
    public int trap(int[] height) {
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