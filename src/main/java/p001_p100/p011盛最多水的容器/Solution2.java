package p001_p100.p011盛最多水的容器;

/**
 * 双指针解法
 */
class Solution2 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int area = Integer.MIN_VALUE;

        while (left < right) {
            area = Math.max(area, (right-left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        return area;
    }
}