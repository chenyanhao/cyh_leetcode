package p101_200.p153寻找旋转排序数组中的最小值;

class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0, right = nums.length - 1;
        if (nums[right] > nums[0]) { // good case，原数组直接是一个升序数组
            return nums[0];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 停止搜索的条件
            if (nums[mid] > nums[mid + 1]) { // 当前 mid 比其下一个数大
                return nums[mid + 1];
            }
            if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) { // 当前 mid 比其前一个数小
                return nums[mid];
            }

            // 缩减左右边界的条件
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3, 4, 5, 1, 2};
        int min = new Solution().findMin(nums);
        System.out.println(min);
    }
}