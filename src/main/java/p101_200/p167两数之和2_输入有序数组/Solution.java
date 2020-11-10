package p101_200.p167两数之和2_输入有序数组;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length <= 1) {
            return null;
        }

        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {left+1, right+1};
            } else if (sum > target) {
                --right;
            } else if (sum < target) {
                ++left;
            }
        }
        return null;
    }
}