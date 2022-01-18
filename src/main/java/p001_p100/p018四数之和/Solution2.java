package p001_p100.p018四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * nSum 问题的通用解法
 */
class Solution2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, 4, 0, target);
    }

    private List<List<Integer>> nSum(int[] nums, int n, int start, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        /**
         * 不符合预期的边界情况
         * 1) 至少是 2Sum
         * 2) 数组大小不小于 n
         */
        if (n < 2 || n > nums.length) {
            return ans;
        }

        // 递归结束条件：问题规模降到 2 时，即 n == 2 时
        if (n == 2) {
            return twoSum(nums, start, target);
        }

        // n >= 3 时，递归计算
        for (int i = start; i < nums.length; ++i) {
            List<List<Integer>> littleSum = nSum(nums, n-1, i+1, target-nums[i]);
            for (List<Integer> r : littleSum) {
                // Java 语言不支持集合在迭代时修改元素，所以这里需要这么写
                List<Integer> tmp = new ArrayList<>(r);
                tmp.add(nums[i]);
                ans.add(tmp);
            }

            // 跳过重复元素
            while (i+1 <= nums.length-1 && nums[i] == nums[i+1]) {
                ++i;
            }
        }

        return ans;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int left = start, right = nums.length - 1;
        while (left < right) {
            int leftElem = nums[left], rightElem = nums[right];
            int sum = leftElem + rightElem;
            if (sum == target) {
                ans.add(Arrays.asList(nums[left], nums[right]));

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
        List<List<Integer>> result = new Solution2().fourSum(nums, target);
        System.out.println(result);
    }

}