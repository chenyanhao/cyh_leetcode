package p018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            if (i >= 1 && nums[i - 1] == nums[i]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; ++j) {
                if (j >= i + 2 && nums[j - 1] == nums[j]) {
                    continue;
                }

                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    int a = nums[i], b = nums[j], c = nums[left], d = nums[right];
                    int sum = a + b + c + d;
                    if (sum == target) {
                        res.add(Arrays.asList(a, b, c, d));

                        while (left < right && nums[left + 1] == nums[left]) {
                            ++left;
                        }
                        ++left;

                        while (left < right && nums[right - 1] == nums[right]) {
                            --right;
                        }
                        --right;

                    } else if (sum < target) {
                        ++left;
                    } else if (sum > target) {
                        --right;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        int target = -1;
        List<List<Integer>> result = fourSum(nums, target);
        System.out.println(result);
    }

}