package p004寻找两个正序数组的中位数;

/**
 * 用 len 表示合并后数组的长度，
 * 如果是奇数，那么第 （len+1）/2 个数就是中位数，如果遍历的话需要遍历 int(len/2) + 1 次。
 * 如果是偶数，那么需要知道第 len/2 和 len/2+1 个数，也是需要遍历 len/2+1 次。
 * 所以遍历的话，奇数和偶数都是 len/2+1 次。
 *
 * 返回中位数的话，奇数需要最后一次遍历的结果就可以了，偶数需要最后一次和上一次遍历的结果。
 * 所以用两个变量 left 和 right，right 保存当前循环的结果，在每次循环前将 right 的值赋给 left。
 * 这样在最后一次循环的时候，left 将得到 right 的值，也就是上一次循环的结果，接下来 right 更新为最后一次的结果。
 */
class Solution2 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int len = m + n;
        double left = Double.MIN_VALUE, right = Double.MIN_VALUE;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len/2; ++i) {
            left = right;
            if (aStart == m) { // a 走到头了，所以需要移动 b
                right = nums2[bStart++];
            } else if (bStart == n) { // b 走到头了，所以需要移动 a
                right = nums1[aStart++];
            } else { // a、b 都没走到头，谁对应位置的值小就移动谁
                if (nums1[aStart] < nums2[bStart]) {
                    right = nums1[aStart++];
                } else {
                    right = nums2[bStart++];
                }
            }
        }

        if ((len % 2) == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2, 4};
        double middle = findMedianSortedArrays(nums1, nums2);
        System.out.println(middle);
    }
}