package p029两数相除;

class Solution {
    public static int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == 0) {
            return 0;
        }

        if (divisor == 1) {
            return dividend;
        }

        if (divisor == -1) {
            if(dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE; // 是最小的，除法结果溢出，因此返回最大的整数
            }
            return -dividend; // 只要不是最小的整数，都是直接返回相反数就好啦
        }

        boolean positive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);

        // 都改为负号是因为 int 的范围是[2^32, 2^32-1]，如果dividend是-2^32，转为正数时将会溢出
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;

        int res = doDivide(dividend, divisor);
        return positive ? res : -res;
    }

    private static int doDivide(int dividend, int divisor) { // 除数，被除数
        if (dividend > divisor) {
            return 0;
        }
        int count = 1;
        int tmp = divisor;
        while (dividend <= 2 * tmp && 2 * tmp < 0) {
            count = 2 * count;
            tmp = 2 * tmp; // 这里可能溢出，因此需要在循环中判断是否溢出
            System.out.println(tmp + " " + count + " ");
        }
        return count + doDivide(dividend - tmp, divisor);
    }

    public static void main(String[] args) {
        int dividend = 2147483647;

        int divisor = 2;
        int res = divide(dividend, divisor);
        System.out.println(res);
    }
}