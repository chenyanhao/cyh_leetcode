package p001_p100.p016最接近的三数之和;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            // 防止twoSumClosest数组越界
            if (i+1 >= nums.length-1) {
                continue;
            }
            int twoSumClosest = twoSumClosest(nums, i+1, target-nums[i]);
            if (Math.abs(twoSumClosest+nums[i]-target) < Math.abs(ans-target)) {
                ans = twoSumClosest+nums[i];
            }
        }
        return ans;
    }

    private int twoSumClosest(int[] nums, int start, int target) {
        int ans = nums[start]+nums[start+1];

        int left = start, right = nums.length - 1;
        while (left < right) {
            int leftElem = nums[left], rightElem = nums[right];
            int sum = leftElem + rightElem;
            if (Math.abs(sum-target) < Math.abs(ans-target)) {
                ans = sum;
            }

            if (sum == target) {
                return sum;
            } else if (sum > target) {
                --right;
            } else if (sum < target) {
                ++left;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,2,1,-3};
        int ans = new Solution().threeSumClosest(nums, 1);
        System.out.println(ans);
    }
}