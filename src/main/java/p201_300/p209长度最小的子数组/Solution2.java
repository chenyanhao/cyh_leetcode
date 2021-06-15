package p201_300.p209长度最小的子数组;

/**
 * 解法：滑动窗口
 */
class Solution2 {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;

        int left = 0, right = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) { // 一旦 sum 大于等于 target，就不断地走左指针
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                ++left;
            }
            ++right;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = new int[]{2,3,1,2,4,3};

        int i = new Solution2().minSubArrayLen(target, nums);
        System.out.println(i);
    }

}