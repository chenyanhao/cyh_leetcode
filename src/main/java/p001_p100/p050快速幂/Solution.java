package p001_p100.p050快速幂;

/**
 * 折半计算，每次把 n 缩小一半
 *
 * 解法一为递归，会超时
 */
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (n >= 0) {
            return dfs(x, N);
        } else {
            return 1.0 / dfs(x, -N); // 取 -n 可能导致溢出，因此辅助函数的入参n类型为long
        }
    }

    private double dfs(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        if (n % 2 == 0) { // 偶数
            return dfs(x, n/2) * dfs(x, n/2);
        } else { // 奇数
            return x * dfs(x, n/2) * dfs(x, n/2);
        }
    }
}