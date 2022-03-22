package p101_200.p153寻找旋转排序数组中的最小值;

/**
 * 利用两个区间必有一个区间有序的性质
 */
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        int ans = nums[0];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[left]) { // 此时旋转二分数组为「左长右短」型，[left, mid] 单增，此区间内 left 最小
                ans = Math.min(ans, nums[left]);
                left = mid + 1;
            } else { // 此时旋转二分数组为「左短右长」型，[mid, right] 单增，此区间内 mid 最小
                ans = Math.min(ans, nums[mid]);
                right = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3, 4, 5, 1, 2};
        int min = new Solution().findMin(nums);
        System.out.println(min);
    }
}