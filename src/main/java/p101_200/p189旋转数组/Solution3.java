package p101_200.p189旋转数组;

/**
 * 将被替换的元素保存在变量 temp 中，避免额外数组的开销，以优化空间复杂度。
 * 原数组下标为 i 的元素放至新数组下标为 (i+k) mod n 的位置，然后不断绕着数组转圈循环。
 *
 * 算法步骤为：
 * 1）从位置 0 开始，最初令 temp=nums[0]，位置 0 的元素会放至 (0+k) mod n 的位置
 *    不妨令 x=(0+k) mod n，此时交换 temp 和 nums[x]，完成位置 x 的更新。
 * 2) 然后考察位置 x，并交换 temp 和 nums[(x+k) mod n]，从而完成下一个位置的更新。
 * 3) 需要注意的是，如果 (x+k)%n==x 导致转了一圈回到了原点，为了避免这种原地打转，需要把 x+1 来继续移动下一个有效的数字
 * 4) 在遍历过程中，使用单独的变量 count 跟踪当前已经访问的元素数量，当 count=n 时，即完成了整个翻转。
 *
 * 时间复杂度： O(n)
 * 空间复杂度： O(1)
 */
class Solution3 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int temp = nums[0];

        int x = 0;
        int start = x; // 用于判断是否原地打转

        int count = 0;
        while (count < n) {
            x = (x + k) % n;

            // swap nums[x] and temp
            int tmpVal = nums[x];
            nums[x] = temp;
            temp = tmpVal;

            if (x == start) { // 原地打转时，需要更新 x、start、temp
                x = (x + 1) % n;
                start = x;
                temp = nums[x];
            }

            ++count;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7};
        new Solution3().rotate(nums, 3);
        for (int n : nums) {
            System.out.println(n);
        }
    }

}