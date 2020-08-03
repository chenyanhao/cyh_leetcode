package p001_p100.p052N皇后2;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int totalNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] = '.';
            }
        }
        dfs(board, 0, res);
        return res.size();
    }

    private void dfs(char[][] board, int row, List<List<String>> res) {
        if (row == board.length) {
            res.add(convert(board));
            return;
        }

        char[] rols = board[row];
        for (int col = 0; col < rols.length; ++col) {
            if (!valid(board, row, col)) {
                continue;
            }

            board[row][col] = 'Q';
            dfs(board, row + 1, res);
            board[row][col] = '.';
        }
    }

    /**
     * 是否可以在 board[row][col] 放置皇后
     *
     * @param board
     * @param row
     * @param col
     * @return
     */
    private boolean valid(char[][] board, int row, int col) {
        // 检查列是否冲突
        for (int i = 0; i < board.length; ++i) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 检查右上方方向是否冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; --i, ++j) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 检查左上方方向是否冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    /**
     * char[][] 转换为 List<String>
     *
     * @param board
     * @return
     */
    private List<String> convert(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; ++i) {
            res.add(String.valueOf(board[i]));
        }
        return res;
    }
}