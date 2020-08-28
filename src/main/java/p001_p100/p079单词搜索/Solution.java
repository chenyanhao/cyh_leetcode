package p001_p100.p079单词搜索;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {

    private boolean[][] used;
    private int row, col;
    private char[][] board;
    private char[] ws;
    private int[][] direction = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        this.row = board.length;
        this.col = board[0].length;
        this.used = new boolean[row][col];
        for (boolean[] u : used) {
            Arrays.fill(u, false);
        }

        this.board = board;
        this.ws = word.toCharArray();

        List<LinkedList<int[]>> res = new ArrayList<>();
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                dfs(i, j, 0, new LinkedList<>(), res);
            }
        }
        return res.size() > 0;
    }

    /**
     * 非标准回溯模板，第一次进入该函数时，(i,j)未加入路径
     */
    private void dfs(int i, int j, int start, LinkedList<int[]> path, List<LinkedList<int[]>> res) {
        if (start == ws.length - 1) {
            if (board[i][j] == ws[start]) {
                LinkedList<int[]> tmp = new LinkedList<>(path);
                tmp.addLast(new int[] {i, j});
                res.add(new LinkedList<>(tmp));
            }
            return;
        }

        if (board[i][j] != ws[start]) {
            return;
        }

        path.addLast(new int[] {i, j});
        used[i][j] = true;
        for (int[] d : direction) {
            int newX = i + d[0];
            int newY = j + d[1];
            // 剪枝
            if (! inArea(newX, newY)) {
                continue;
            }
            if (used[newX][newY]) {
                continue;
            }

            dfs(newX, newY, start + 1, path, res);
        }
        used[i][j] = false;
        path.removeLast();
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.row && y >= 0 && y < this.col;
    }


    private void debug(List<int[]> list) {
        StringBuilder sb = new StringBuilder();
        for (int[] l : list) {
            sb.append("(" + l[0] + "," + l[1] + ")" + "\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        boolean exist = new Solution().exist(board, word);
        System.out.println(exist);
    }
}