package p701_800.p793阶乘函数后K个零;

/**
 *
 * 解法一使用暴力穷举，观察其代码逻辑后发现，代码分支主要是小于 K、大于 K、等于 K 分别怎么处理，这种形式可以利用二分查找优化
 *
 * 思路：
 *  搜索有多少个 n 满足 trailingZeroes(n) == K，
 *  其实就是求解，满足条件的 n 最小是多少，最大是多少。
 *  最大值和最小值一减，就可以算出来有多少个 n 满足条件了。
 *  用二分查找的话讲，就是二分查找「搜索左侧边界」和「搜索右侧边界」
 *
 * 关键点：确定二分查找的搜索区间，也就是上界和下界
 *  K 是在 [0, 10^9] 区间内的整数，所以，trailingZeroes(n) 的结果最多可以达到 10^9。
 *  trailingZeroes(Integer.MAX_VALUE) < 10^9；trailingZeroes(Long.MAX_VALUE) > 10^9。
 *  所以 Long.MAX_VALUE 可以作为搜索的上界。
 */
class Solution2 {
    public int preimageSizeFZF(int K) {
        // 左边界和右边界之差 + 1 就是答案
        return (int) (rightBound(K) - leftBound(K) + 1);
    }


    /* 搜索 trailingZeroes(n) == K 的左侧边界 */
    private long leftBound(int target) {
        long lo = 0, hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) < target) {
                lo = mid + 1;
            } else if (trailingZeroes(mid) > target) {
                hi = mid;
            } else {
                hi = mid;
            }
        }

        return lo;
    }

    /* 搜索 trailingZeroes(n) == K 的右侧边界 */
    private long rightBound(int target) {
        long lo = 0, hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) < target) {
                lo = mid + 1;
            } else if (trailingZeroes(mid) > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo - 1;
    }

    /* 所有数据类型为 long，防止溢出 */
    private long trailingZeroes(long n) {
        long res = 0;
        for (long d = n; d / 5 > 0; d = d / 5) {
            res += d / 5;
        }
        return res;
    }

}