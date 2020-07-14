package p036有效的数独;

class Solution {
    /**
     * 分别建立哈希表或者数组来存储任一个数在相应维度上是否出现过。
     * 维度有3个：所在的行，所在的列，所在的box。注意box的下标也是从左往右、从上往下的。
     *
     * 遍历到每个数的时候，例如 boar[i][j]，判断其是否满足三个条件：
     *     在第 i 个行中是否出现过
     *     在第 j 个列中是否出现过
     *     在第 j/3 + (i/3)*3 个 box中是否出现过
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    continue;
                }
                int value = board[i][j] - '1';
                int boxIndex = (i / 3) * 3 + j / 3;
                if (rows[i][value] || cols[j][value] || boxes[boxIndex][value]) {
                    return false;
                }
                rows[i][value] = true;
                cols[j][value] = true;
                boxes[boxIndex][value] = true;
            }
        }
        return true;
    }
}