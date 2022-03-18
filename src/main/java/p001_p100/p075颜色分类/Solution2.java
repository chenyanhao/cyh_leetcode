package p001_p100.p075颜色分类;

/**
 * 模仿快速排序partition的过程。
 * 定义三个指针 p0/i/p2，其中
 *  [0, p0) = 0
 *  [p0, i) = 1
 *  [p2, len-1] = 2
 *
 *  len = nums.length，表示数组长度
 */
class Solution2 {
    public void sortColors(int[] nums) {
        // 为了保证初始化的时候 [0, p0) 为空，设置 p0 = 0，
        // 所以下面while循环遍历到 0 的时候，先交换，再加
        int p0 = 0;

        // 为了保证初始化的时候 [p2, len-1] 为空，设置 p2 = len
        // 所以下面while循环遍历到 2 的时候，先减，再交换
        int p2 = nums.length;

        int i = 0;
        while (i < p2) {
            if (nums[i] == 0) {
                swap(nums, i, p0);
                ++p0;

                // 注意：这里需要 ++i。因为左闭右开区间 [p0, i) 表示所有为1的元素，循环中操作变量时候不能改变这一条件
                ++i;
            } else if (nums[i] == 1) {
                ++i;
            } else if (nums[i] == 2) {
                --p2;
                swap(nums, i, p2);

                // 注意：这里不能再 ++i。因为左闭右开区间 [p0, i) 表示所有为1的元素，循环中操作变量时候不能改变这一条件
                // ++i;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}