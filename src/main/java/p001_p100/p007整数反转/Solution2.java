package p001_p100.p007整数反转;

/**
 * 不断弹出末位数字：
 * pop = x % 10;
 * x = x / 10;
 *
 * rev = rev * 10 + pop; (rev初始化为0)
 *
 * 判断是否溢出： MIN_VALUE <= rev * 10 + pop <= MAX_VALUE，式子不成立需要立即返回 0
 * MIN_VALUE = -2^31 = -2147483648
 * MAX_VALUE = 2^31-1 = 2147483647
 *
 * 考查两边的溢出条件：
 * 右边溢出：
 * 1）当前 rev > MAX_VALUE / 10 时，此时还要加上 pop，那么必定溢出。
 * 2）当前 rev = MAX_VALUE / 10 时，如果 pop > 7，则必定溢出。
 *
 * 左边溢出：
 * 1）当前 rev < MIN_VALUE / 10 时，此时还要加上 pop，则必定溢出。
 * 2）当前 rev = MIN_VALUE / 10 时，如果 pop < -8，则必定溢出。
 *
 */
class Solution2 {
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            if (x > Integer.MAX_VALUE / 10 || (x == Integer.MAX_VALUE && pop > 7)) {
                return 0;
            }
            if (x < Integer.MIN_VALUE / 10 || (x == Integer.MIN_VALUE && pop < -8)) {
                return 0;
            }

            x = x / 10;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}


