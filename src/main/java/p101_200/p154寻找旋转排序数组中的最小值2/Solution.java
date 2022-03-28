package p101_200.p154寻找旋转排序数组中的最小值2;

/**
 *
 * 注意：
 * 按照 p153 的解法就无法求解了，因为有重复元素就可能有这种 case，例如 nums = [10, 10, 10, 10, 10, 1, 2, 10, 10]。
 * 因此此题的关键既不是判断「左长右短」还是「右长左短」，也不是判断哪个区间单调递增。
 *
 *
 * 题目要求找出最小的点，具体点就是数组中第一个小于 nums[right] 的数字，
 * 这里注意：为什么不能是第一个小于 nums[left] 的数字呢，考虑特殊情况，
 * 那就是当数组元素严格递增时，没有比 nums[left] 更小的数字了。
 * 因此本题得用右指针作为比较条件。
 *
 * 假设旋转数组的分界点索引为 i，即第 2 个数组的首元素的索引
 *
 * 1) nums[mid] > nums[right]：mid 一定在第 1 个数组中，i 一定满足 mid < i <= right，因此执行 left = mid + 1；
 * 2) nums[mid] < nums[right]：mid 一定在第 2 个数组中，i 一定满足 left < i <= mid，因此执行 right = mid；
 * 3) nums[mid] == nums[right]：此时不能简单地调整 right 的位置到 mid 处，此时唯一知道的是 i 在 right 的左边，
 *      二分的实质就是将区间不断缩小最终锁定答案，所以此时只能通过将 right 左移一位来缩小区间的长度，这也是本题的关键点。
 *
 */
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right = right - 1;
            }
        }
        return nums[left];
    }
}