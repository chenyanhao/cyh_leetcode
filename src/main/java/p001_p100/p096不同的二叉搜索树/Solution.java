package p001_p100.p096不同的二叉搜索树;

class Solution {
    /**
     * 卡特兰数问题
     * G(n): 1..n 为节点存在二叉搜索树的个数
     * f(i): 以 i 为根的二叉搜索树的个数
     *
     * 容易推导出：G(n)=f(1)+f(2)+f(3)+...+f(n)
     *
     * 当 i 为根节点时，其左子树节点个数为 i-1 个，右子树节点为 n-i，则可以推导出：f(i)=G(i−1)∗G(n−i)
     *
     * 综合可以得到：G(n)=G(0)∗G(n−1) + G(1)∗(n−2) + ... + G(n−1)∗G(0)
     *  G(n) 的值依赖于  G(0) 到 G(n−1)
     *  另外对于边界情况，当序列长度为 1（只有根）或为 0（空树）时，只有一种情况，即：G(0)=1,G(1)=1
     *
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}