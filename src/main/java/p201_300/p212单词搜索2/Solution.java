package p201_300.p212单词搜索2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 基于 p079，这种方式逻辑没问题，但是会超时
 */
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (exist(board, word)) {
                res.add(word);
            }
        }
        return res;
    }


    // ================== 以下代码均从 p079 copy 而来 =================

    private boolean[][] used;
    private int row, col;
    private char[][] board;
    private char[] ws;
    private int[][] direction = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private boolean exist(char[][] board, String word) {
        this.row = board.length;
        this.col = board[0].length;
        this.used = new boolean[row][col];
        for (boolean[] u : used) {
            Arrays.fill(u, false);
        }

        this.board = board;
        this.ws = word.toCharArray();

        List<LinkedList<int[]>> res = new ArrayList<>();
        LinkedList<int[]> path = new LinkedList<>();
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] == ws[0]) {
                    path.addLast(new int[] {i, j});
                    used[i][j] = true;
                    dfs(i, j, 1, path, res);
                    path.removeLast();
                    used[i][j] = false;
                }
            }
        }
        return res.size() > 0;
    }

    /**
     * 套用标准回溯模板，第一次进入该函数时，(i,j)已加入路径；接下来站在 (i,j) 上，将其邻居作为选择列表
     */
    private void dfs(int i, int j, int depth, LinkedList<int[]> path, List<LinkedList<int[]>> res) {
        if (depth == ws.length) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int k = 0; k < direction.length; ++k) {
            int newX = i + direction[k][0];
            int newY = j + direction[k][1];
            if (! inArea(newX, newY)) {
                continue;
            }
            if (used[newX][newY]) {
                continue;
            }
            if (board[newX][newY] != ws[depth]) {
                continue;
            }
            path.addLast(new int[] {newX, newY});
            used[newX][newY] = true;
            dfs(newX, newY, depth + 1, path, res);
            used[newX][newY] = false;
            path.removeLast();
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.row && y >= 0 && y < this.col;
    }
}