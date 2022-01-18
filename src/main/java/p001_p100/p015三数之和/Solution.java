package p001_p100.p015三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 双指针解法。
 *
 * 时间复杂度：O(N^2)
 * 空间复杂度：O(1)
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return threeSum(nums, 0);
    }

    private List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            List<int[]> twoSum = twoSum(nums, i+1, target-nums[i]);
            for (int[] r : twoSum) {
                ans.add(Arrays.asList(nums[i], r[0], r[1]));
            }

            // 跳过重复元素
            while (i <= nums.length-2 && nums[i] == nums[i+1]) {
                ++i;
            }
        }
        return ans;
    }

    private List<int[]> twoSum(int[] nums, int start, int target) {
        List<int[]> ans = new ArrayList<>();
        int left = start, right = nums.length - 1;
        while (left < right) {
            int leftElem = nums[left], rightElem = nums[right];
            int sum = leftElem + rightElem;
            if (sum == target) {
                ans.add(new int[]{nums[left], nums[right]});

                // 跳过重复元素
                while (left < right && nums[left] == leftElem) {
                    ++left;
                }
                while (right > left && nums[right] == rightElem) {
                    --right;
                }
            } else if (sum > target) {
                while (right > left && nums[right] == rightElem) {
                    --right;
                }
            } else if (sum < target) {
                while (left < right && nums[left] == leftElem) {
                    ++left;
                }
            }
        }
        return ans;
    }
}