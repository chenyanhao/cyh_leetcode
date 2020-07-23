package p033搜索旋转排序数组;

class Solution {
    /**
     * 解法关键：数组「被旋转」，左侧或者右侧区间不一定是连续的，需要将其转换为连续区间的二分查找
     *
     * 1）若 target == nums[mid]，直接返回
     * 2）若 nums[left] <= nums[mid]，说明左侧区间 [left,mid]「连续递增」。此时：
     *      若 nums[left] <= target <= nums[mid]，说明 target 位于左侧。令 right = mid-1，在左侧区间查找
     *      否则，令 left = mid+1，在右侧区间查找
     *
     * 3）否则，说明右侧区间 [mid,right]「连续递增」。此时：
     *      若 nums[mid] <= target <= nums[right]，说明 target 位于右侧区间。令 left = mid+1，在右侧区间查找
     *      否则，令 right = mid-1，在左侧区间查找
     *
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[left] <= nums[mid]) { // 注意，应该再这里带等号，下面的 else-if 中不可以带
                if (target >= nums[left] && target < nums[mid]) { // 左侧区间 [left,mid] 连续递增，target 处于连续递增区间，退化成普通二分查找
                    right = mid - 1;
                } else { // 其余情况，处于非连续区间中
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]) { // 注意，这里不能带等号
                if (target > nums[mid] && target <= nums[right]) { // 左侧区间 [mid,right] 连续递增
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


    /**
     * 对于旋转数组 nums = [4,5,6,7,0,1,2]
     * 首先根据 nums[0] 与 target 的关系判断 target 是在左段还是右段。
     *     例如 target = 5, 目标值在左半段，因此在 [4, 5, 6, 7, inf, inf, inf] 这个有序数组里找就行了；
     *     例如 target = 1, 目标值在右半段，因此在 [-inf, -inf, -inf, -inf, 0, 1, 2] 这个有序数组里找就行了。
     *
     * 如此，将「旋转数组中找目标值」 转化成了 「有序数组中找目标值」
     *
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (target >= nums[0]) { // 目标值在左半段
                // 若 mid 在右半段，则将 mid 索引的值改成 inf
                if (nums[mid] < nums[0]) {
                    nums[mid] = Integer.MAX_VALUE;
                }
            } else if (target < nums[0]){ // 目标值在右半段
                // 若 mid 在左半段，则将 mid 索引的值改成 -inf
                if (nums[mid] >= nums[0]) {
                    nums[mid] = Integer.MIN_VALUE;
                }
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

}