package p201_300.p238除自身以外数组的乘积;

/**
 *
 * 将 res 数组列成乘积形式，形成一个矩阵，可以发现矩阵主对角线全部为1（当前数字不相乘，等价为乘 1）；
 *
 * 因此，分别计算矩阵的 下三角 和 上三角，并且在计算过程中储存过程值，最终可以在遍历 2 遍 nums 下完成结果计算。
 *
 * res
 * res[0] = 	1 	    num[1] 	... 	num[n-2] 	num[n-1]
 * res[1] = 	num[0] 	1 	    ... 	num[n-2] 	num[n-1]
 *  ... 	    ... 	... 	... 	num[n-2] 	num[n-1]
 * res[n-2] = 	num[0] 	num[1] 	... 	1 	        num[n-1]
 * res[n-1] = 	num[0] 	num[1] 	... 	num[n-2] 	1
 *
 *
 * 上面矩阵例子不太好理解的话，举个平面的例子理解，
 * 原数组：        6       2       3       4
 * 左部分的乘积：   1       6      6*2    6*2*3
 * 右部分的乘积： 2*3*4    3*4      4      1
 * 结果：       1*2*3*4  6*3*4   6*2*4  6*2*3*1
 *
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int p = 1, q = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = p;
            p *= nums[i];
        }
        for (int i = nums.length - 1; i > 0 ; i--) {
            q *= nums[i];
            res[i - 1] *= q;
        }
        return res;
    }
}