package 框架代码.二分查找变种;

public class 旋转二分查找 {

    /**
     * 旋转数组 nums 为两段升序，例如 nums=[4,5,6,7,0,1,2]，第一段升序为 [4,5,6,7]，第二段升序为 [0,1,2]
     *
     * 旋转数组大体分两种情况：
     * 1）第一段升序长、第二段升序短，例如 nums=[4,5,6,7,8,9,10,11,0,1,2]
     * 2）第一段升序短、第二段升序长，例如 nums=[9,10,11,0,1,2,4,5,6,7,8]
     *
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
     */
    public int binarySearchAscendDescend(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // 注意，这里if条件必须带等号，下面的 else-if 中不可以带
            if (nums[left] <= nums[mid]) { // 第一段升序长、第二段升序短
                if (target >= nums[left] && target < nums[mid]) { // 区间 [left,mid] 连续递增，target 处于连续递增区间，退化成普通二分查找
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]) { // 第一段升序短、第二段升序长
                if (target > nums[mid] && target <= nums[right]) { // 区间 [mid,right] 连续递增
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


    /**
     * 旋转数组 nums 为两段降序，例如 nums=[2,1,0,7,6,5,4]，第一段降序为 [2,1,0]，第二段降序为 [7,6,5,4]
     *
     * 思路和写法都同上
     */
    public int binarySearchDescendAscend(int[] nums, int target) {
        return -1;
    }
}
