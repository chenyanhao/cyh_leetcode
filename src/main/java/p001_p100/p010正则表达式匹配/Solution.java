package p001_p100.p010正则表达式匹配;

import java.util.*;

public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
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

    public static void main(String[] args) {
        int[] nums = new int[]{-4, 0, 0, 1, 2, 3, 4, 4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

}
