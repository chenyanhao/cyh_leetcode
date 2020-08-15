package p001_p100.p037解数独;

class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int i, int j) {
        int m = 9, n = 9;

        // 穷举到最后一列的话就换到下一行重新开始
        if (j == n) {
            return dfs(board, i + 1, 0);
        }

        if (i == m) {
            // 找到一个可行解，结束递归
            return true;
        }

        // 如果该位置有预填的数字，则直接对下一个位置填充
        if (board[i][j] != '.') {
            return dfs(board, i, j + 1);
        }

        for (char ch = '1'; ch <= '9'; ++ch) {
            // 如果遇到不合法的数字，就跳过
            if (!isValid(board, i, j, ch)) {
                continue;
            }
            board[i][j] = ch;
            if (dfs(board, i, j + 1)) {
                return true;
            }
            board[i][j] = '.';
        }

        // 穷举完 1~9，依然没有找到可行解
        return false;
    }

    // 判断 board[row][col] 是否可以填入 num
    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; ++i) {
            // 判断行是否重复
            if (board[row][i] == num) {
                return false;
            }

            // 判断列是否重复
            if (board[i][col] == num) {
                return false;
            }

            // 判断 3*3 方框内是否存在重复
            if (board[(row/3)*3 + i/3][(col/3)*3 + i%3] == num) {
                return false;
            }
        }
        return true;
    }
}