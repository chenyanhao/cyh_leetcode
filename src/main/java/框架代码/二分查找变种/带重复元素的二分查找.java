package 框架代码.二分查找变种;

/**
 * 该专题主要处理：数组中有重复元素时，二分查找的思路和注意事项
 */
public class 带重复元素的二分查找 {

    /**
     * 升序数组nums中可能含有重复元素，若有等于target的，返回最左侧的；若没有，返回target的插入下标，使得数组依然有序。
     * 其实总结一下：找到升序序数组 nums 中大于等于 target 的最左侧的值
     *
     * 例如，nums=[2, 5, 7, 7, 7, 7, 8, 9]，target = 6，则返回数组中第一个7的下标 2
     * 例如，nums=[2, 5, 7, 7, 7, 7, 8, 9]，target = 7，则返回数组中第一个7的下标 2
     *
     * 该题相当于融合了两道题：
     * 1）升序数组nums中可能含有重复元素，查找 target，找到返回最左侧的值，没找到返回 -1。
     * 2）升序数组nums中可能含有重复元素，且不含等于 target 的元素，返回target的插入下标，使得数组依然有序。
     *
     */
    public int binarySearchLeft4Ascending(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) { // 注意，这里没带等号，和标准二分查找不同
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                right = mid;
            }  else if (target < nums[mid]) {
                right = mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }

        /**
         * 此时 left == right。
         *
         * 注意：在二分查找中，left == right 时，有且仅有两种情况：
         * 1）nums[left] == target；
         * 2）此时 left 即为使得数组依然有序的target的插入下标。
         */
        return left;
    }
    public int binarySearchLeft4Ascending2(int[] nums, int target) { // 另一种写法，套用标准二分查找模板
        int left = 0, right = nums.length - 1;
        while (left <= right) { // 注意，这里带了等号，和第一种写法不同
            /**
             * 如第一种解法中所述，该题相当于融合了两道题。
             * 当 nums 中包含等于 target 的元素时，此处需要额外判断，不然会死循环。
             */
            if (left == right && nums[left] == target) {
                return left;
            }
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                right = mid;
            }  else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }

        return left;
    }


    /**
     * 找到升序序数组 nums 中大于等于 target 的最右侧的值
     * 例如，nums=[2, 5, 7, 7, 7, 7, 8, 9]，target = 6，则返回数组中最后一个7的下标 5
     * 例如，nums=[2, 5, 7, 7, 7, 7, 8, 9]，target = 7，则返回数组中最后一个7的下标 5
     *
     * 无法使用标准二分查找模板来处理，因此这里只是列出，不求解。
     */
    public int binarySearchRight4Ascending(int[] nums, int target) {
        return -1;
    }


    /**
     * 找到降序数组 nums 中大于等于 target 的最左侧的值
     * 例如，nums=[9, 8, 7, 7, 7, 7, 5, 2]，target = 6，则返回数组中第一个7的下标 2
     * 例如，nums=[9, 8, 7, 7, 7, 7, 5, 2]，target = 7，则返回数组中第一个7的下标 2
     *
     * 无法使用标准二分查找模板来处理，因此这里只是列出，不求解。
     */
    public int binarySearchLeft4Descending(int[] nums, int target) {
        return -1;
    }


    /**
     * 找到降序数组 nums 中大于等于 target 的最右侧的值
     *
     * 例如，nums=[9, 8, 7, 7, 7, 7, 5, 2]，target = 6，则返回数组中最后一个7的下标 5
     * 例如，nums=[9, 8, 7, 7, 7, 7, 5, 2]，target = 7，则返回数组中最后一个7的下标 5
     *
     * 注意降序数组查找时，mid 的写法和升序数组不同。
     * 升序数组相当于是 (left+right)/2 结果向下取整，降序数组需要向上取整。
     */
    public int binarySearchRight4Descending(int[] nums, int target) {
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
        return right; // 此时 left == right
    }
    public int binarySearchRight4Descending2(int[] nums, int target) { // 另一种写法，套用标准二分查找模板
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (left == right) {
                return right;
            }
            int mid = (int) Math.ceil(new Double(left + right) / 2);
            if (target == nums[mid]) {
                left = mid;
            } else if (target < nums[mid]) {
                left = mid + 1;
            } else if (target > nums[mid]) {
                right = mid - 1;
            }
        }
        return right; // 此时 left-1 = right
    }

    public static void main(String[] args) {
//        int[] nums = new int[] {9, 8, 7, 7, 7, 7, 5, 2};
//        int[] nums = new int[] {2, 5, 7, 7, 7, 7, 8, 9};
        int[] nums = new int[] {7};
        int ans = new 带重复元素的二分查找().binarySearchRight4Descending2(nums, 7);
        System.out.println(ans);
    }
}
