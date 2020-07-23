package p081搜索旋转排序数组2;

class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] > nums[mid]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[left] < nums[mid]){
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] == nums[mid]) { // 因为数组有重复数字，分不清到底是前面有序还是后面有序，此时 left++，相当于去掉一个重复的干扰项。
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 1, 1};
        boolean search = new Solution().search(nums, 3);
        System.out.println(search);
    }
}