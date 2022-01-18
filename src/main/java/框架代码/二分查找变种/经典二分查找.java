package 框架代码.二分查找变种;

public class 经典二分查找 {

    /**
     * 升序数组二分查找，找到返回对应元素下标，没找到返回target插入位置使得数组依然有序
     *
     * 返回值的值域为[0, nums.length]，即返回值不会越左边界，可能会越右边界。
     * 越右边界的含义为target比nums中任何值都要大。
     */
    public int binarySearchAscending(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 降序数组二分查找，找到返回对应元素下标，没找到返回target插入位置使得数组依然有序
     *
     * 返回值的值域为[0, nums.length]，即返回值不会越左边界，可能会越右边界。
     * 越右边界的含义为target比nums中任何值都要小。
     */
    public int binarySearchDescending(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (int) Math.ceil(new Double(left + right) / 2);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
//        int[] nums = new int[] {1, 3, 5, 7, 9};
        int[] nums = new int[] {9, 7, 5, 3, 1};
        int ans = new 经典二分查找().binarySearchDescending(nums, 2);
        System.out.println(ans);
    }

}
