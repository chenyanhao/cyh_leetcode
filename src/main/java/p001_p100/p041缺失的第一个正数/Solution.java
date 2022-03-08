package p001_p100.p041缺失的第一个正数;

/**
 * 将数组视为哈希表。
 *
 * 把 1 这个数放到下标为 0 的位置，2 这个数放到下标为 1 的位置，按照这种思路整理一遍数组。
 * 再遍历一次数组，第 1 个遇到的它的值不等于下标的那个数，就是要找的缺失的第一个正数。
 * 这个思想就相当于自己编写哈希函数，这个哈希函数的规则特别简单，那就是数值为 i 的数映射到下标为 i - 1 的位置。
 *
 */
class Solution {
    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                // 例如：数值 3 应该放在索引 2 的位置上
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {7, 4, -1, 1, 3};
        int i = firstMissingPositive(nums);
        System.out.println(i);
    }
}