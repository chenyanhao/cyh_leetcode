package p001_p100.p075颜色分类;

/**
 * 模仿快速排序partition的过程。
 *
 * 该解法和解法二对比，体会初始化变量、循环中变量值变化时的规律。
 * 牢记「循环不变量」，即循环中操作变量时，不可以改变条件变量在初始化时的含义。
 *
 * 定义三个指针 p0/i/p2，其中
 *  [0, p0] = 0
 *  (p0, i) = 1
 *  (p2, len-1] = 2
 *
 *  len = nums.length，表示数组长度
 */
class Solution3 {
    public void sortColors(int[] nums) {
        // 为了保证初始化的时候 [0, p0] 为空，设置 p0 = -1，
        // 所以下面while循环遍历到 0 的时候，先加，再交换
        int p0 = -1;

        // 为了保证初始化的时候 (p2, len-1] 为空，设置 p2 = len-1
        // 所以下面while循环遍历到 2 的时候，先交换，再减
        int p2 = nums.length - 1;

        int i = 0;
        while (i <= p2) { // 注意循环结束条件和解法二也不同
            if (nums[i] == 0) {
                ++p0;
                swap(nums, i, p0);

                // 注意：这里需要 ++i。因为左闭右开区间 (p0, i) 表示所有为1的元素，循环中操作变量时候不能改变这一条件
                ++i;
            } else if (nums[i] == 1) {
                ++i;
            } else if (nums[i] == 2) {
                swap(nums, i, p2);
                --p2;

                // 注意：这里不能再 ++i。因为左闭右开区间 (p0, i) 表示所有为1的元素，循环中操作变量时候不能改变这一条件
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