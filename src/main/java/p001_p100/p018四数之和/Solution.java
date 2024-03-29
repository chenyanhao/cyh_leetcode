package p001_p100.p018四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 之前一题（p015三数之和）写过一个通用的threeSum方法，这里可以直接借鉴过来用。
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            List<int[]> threeSum = threeSum(nums, i + 1, target - nums[i]);
            for (int[] r : threeSum) {
                ans.add(Arrays.asList(nums[i], r[0], r[1], r[2]));
            }

            // 跳过重复元素
            while (i <= nums.length-2 && nums[i] == nums[i+1]) {
                ++i;
            }
        }
        return ans;
    }

    private List<int[]> threeSum(int[] nums, int start, int target) {
        List<int[]> ans = new ArrayList<>();
        for (int i = start; i < nums.length; ++i) {
            List<int[]> twoSum = twoSum(nums, i+1, target-nums[i]);
            for (int[] r : twoSum) {
                ans.add(new int[]{nums[i], r[0], r[1]});
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

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        int target = -1;
        List<List<Integer>> result = new Solution().fourSum(nums, target);
        System.out.println(result);
    }

}