package p001_p100.p050快速幂;

/**
 * 折半计算，每次把 n 缩小一半
 *
 * 解法二为迭代
 */
class Solution2 {
    public double myPow(double x, int n) {
        long N = n;
        if (n >= 0) {
            return powHelperdouble(x, N);
        } else {
            return 1.0 / powHelperdouble(x, -N); // 取 -n 可能导致溢出，因此辅助函数的入参n类型为long
        }
    }

    private double powHelperdouble(double x, long n) {
        double ans = 1.0;
        while (n > 0) {
            if (n % 2 == 1) {
                ans *= x;
            }
            x = x * x;
            n = n / 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        double ans = new Solution2().myPow(2.0, -2147483648);
        System.out.println(ans);
    }
}