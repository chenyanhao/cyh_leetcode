package p701_800.p793阶乘函数后K个零;


class Solution {
    /**
     * 暴力穷举，随着 n 的增加，n! 肯定是递增的，trailingZeroes(n!) 肯定也是递增的
     *
     */
    public int preimageSizeFZF(int K) {
        int res = 0;
        for (int n = 0; n < Integer.MAX_VALUE; n++) {
            if (trailingZeroes(n) < K) {
                continue;
            }
            if (trailingZeroes(n) > K) {
                break;
            }
            if (trailingZeroes(n) == K) {
                res++;
            }
        }
        return res;
    }

    private long trailingZeroes(long n) {
        long res = 0;
        for (long d = n; d / 5 > 0; d = d / 5) {
            res += d / 5;
        }
        return res;
    }

}