package p001_p100.p062不同路径;

class Solution2 {

    public int uniquePaths(int m, int n) {
        return dfs(0, 0, m, n, 0);
    }

    private int dfs(int i, int j, int row, int col, int res) {
        if (i == row - 1 && j == col - 1) {
            return res + 1;
        }

        if (i >= row || j >= col) {
            return 0;
        }

        int r1 = dfs(i + 1, j, row, col, res);
        int r2 = dfs(i, j + 1, row, col, res);
        return r1 + r2;
    }

}