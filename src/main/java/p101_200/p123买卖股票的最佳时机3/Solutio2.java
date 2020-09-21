package p101_200.p123买卖股票的最佳时机3;

class Solutio2 {

    /**
     * 解法一中，采用的是最通用的做法，对于该题，k=2，k 维的规模较小，可以穷举出来，因此可以进一步优化空间和时间复杂度。
     */
    public int maxProfit(int[] prices) {
        return -1;
    }

    public static void main(String[] args) {
        int[] prices = new int[] {
                3,3,5,0,0,3,1,4
        };
        int res = new Solutio2().maxProfit(prices);
        System.out.println(res);
    }

}