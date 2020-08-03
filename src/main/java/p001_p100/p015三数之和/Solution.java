package p001_p100.p015三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (i >= 1 && nums[i] == nums[i - 1]) { // 防止重复，跳过
                continue;
            }

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int a = nums[i], b = nums[left], c = nums[right];
                int sum = a + b + c;
                if (sum == 0) {
                    res.add(Arrays.asList(a, b, c));
                    while (left < right && left + 1 < nums.length && nums[left + 1] == nums[left]) { // 防止重复，跳过
                        ++left;
                    }
                    ++left;

                    while (left < right && right - 1 >= 0 && nums[right - 1] == nums[right]) { // 防止重复，跳过
                        --right;
                    }
                    --right;
                } else if (sum > 0) {
                    --right;
                } else if (sum < 0) {
                    ++left;
                }
            }
        }
        return res;
    }
}