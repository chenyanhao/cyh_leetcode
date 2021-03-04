package p101_200.p172阶乘后的零;

/**
 * 含有 2 的因子每两个出现一次，含有 5 的因子每 5 个出现一次。
 * 所有 2 出现的个数远远多于 5，换言之找到一个 5，一定能找到一个 2 与之配对。
 * 所以只需要找有多少个 5
 */
class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        for (int d = n; d / 5 > 0; d = d / 5) {
            res += d / 5;
        }
        return res;
    }
}