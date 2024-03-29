package p001_p100.p034在排序数组中查找元素的第一个和最后一个位置;

class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = leftBound(nums, target);
        ans[1] = rightBound(nums, target);
        return ans;
    }

    private static int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }
        }

        /**
         * mid=(left+right)/2 中除法是取下界，所以只有在搜索到仅剩一个数的时候，left == right == mid，
         * 此时无论进入if-else的哪一个分支，都会使得left > right，
         * 而这最后一个数就是决定taget是否在数组中存在的最后希望，所以这里需要单独判断
         */
        if (left > nums.length - 1 || nums[left] != target) {
            return -1;
        }
        return left;
    }

    private static int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                left = mid + 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }
        }

        if (right < 0 || nums[right] != target) {
            return -1;
        }

        return right;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;
        int left = leftBound(nums, target);
        int right = rightBound(nums, target);
        System.out.println(left);
        System.out.println(right);
    }
}