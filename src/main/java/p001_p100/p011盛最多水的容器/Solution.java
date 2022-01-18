package p001_p100.p011盛最多水的容器;

/**
 *
 * 首先想到的是单调栈。但是结合此题，用单调数组会更方便求解，写出来代码也更好懂。
 *
 * 整个过程如下：
 * 对于 height[i]，分别求其左边的单调数组 leftArr 和右边的单调数组 rightArr，即，
 * 1）从位置 i 往左边看，找到左边众元素中的最左边的最大值对应下标 left
 * 2）从位置 i 往右边看，找到左边众元素中的最右边的最大值对应下标 right
 * 则包含位置 i 的最大容纳水的 area = (right - left) * min(height[left], height[right])
 * 迭代遍历各位置 i 即可得到全局最大值。
 *
 * 例如，
 * height   = [1,8,6,2,5,4,8,3,7]，则
 * leftArr  = [1,8,8,8,8,8,8,8,8]
 * rightArr = [8,8,8,8,8,8,8,7,7]
 *
 * 考虑到 leftArr 和 rightArr 都单调有序，所以查找值的时候可以用上二分查找降低时间复杂度。
 *
 */
class Solution {
    public int maxArea(int[] height) {
        int[] leftArr = new int[height.length];
        for (int i = 0; i < height.length; ++i) {
            if (i == 0) {
                leftArr[i] = height[i];
                continue;
            }
            leftArr[i] = Math.max(height[i], leftArr[i-1]);
        }

        int[] rightArr = new int[height.length];
        for (int i = height.length-1; i >= 0; --i) {
            if (i == height.length - 1) {
                rightArr[i] = height[i];
                continue;
            }
            rightArr[i] = Math.max(height[i], rightArr[i+1]);
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; ++i) {
            int left = binarySearchLeft(leftArr, height[i]);
            int right = binarySearchRight(rightArr, height[i]);
            int area = (right - left) * height[i];
            ans = Math.max(ans, area);
        }

        return ans;
    }

    /**
     * 找到升序序数组 nums 中大于等于 target 的最左侧的值
     */
    private int binarySearchLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                right = mid;
            }  else if (target < nums[mid]) {
                right = mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 找到降序数组 nums 中大于等于 target 的最右侧的值
     *
     * 注意降序数组查找时，mid 的写法和升序数组不同。
     * 升序数组相当于是 (left+right)/2 结果向下取整，降序数组需要向上取整。
     */
    private int binarySearchRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (int) Math.ceil(new Double(left + right) / 2);
            if (target == nums[mid]) {
                left = mid;
            } else if (target < nums[mid]) {
                left = mid;
            } else if (target > nums[mid]) {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        int ans = new Solution().maxArea(height);
        System.out.println(ans);
    }
}