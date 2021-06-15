package p201_300.p212单词搜索2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 解法三：另一种回溯写法，可以和 p079 的写法对比，并体会两种回溯写法的异同
 *
 */
class Solution3 {

    private class TrieNode {

        TrieNode[] next = new TrieNode[26];

        String word = null;

        public TrieNode() {}

        public void insert(String word) {
            TrieNode node = this;
            for (char ch : word.toCharArray()) {
                if (node.next[ch - 'a'] == null) {
                    node.next[ch - 'a'] = new TrieNode();
                }
                node = node.next[ch - 'a'];
            }
            node.word = word;
        }
    }


    private int row, col;
    private boolean[][] used;
    private int[][] direction = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        this.row = board.length;
        this.col = board[0].length;

        this.used = new boolean[row][col];
        for (boolean[] u : used) {
            Arrays.fill(u, false);
        }

        // 构建前缀树
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.insert(word);
        }

        // 回溯
        List<String> res = new ArrayList<>();
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (root.next[board[i][j] - 'a'] == null) {
                    continue;
                }
                used[i][j] = true;
                dfs(board, used, i, j, root.next[board[i][j] - 'a'], res);
                used[i][j] = false;
            }
        }

        return res;
    }

    private void dfs(char[][] board, boolean[][] used, int i, int j, TrieNode root, List<String> res) {
        if (root.word != null) {
            res.add(root.word);
            root.word = null;
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

            TrieNode node = root.next[board[newX][newY] - 'a'];
            if (node == null) {
                continue;
            }

            used[newX][newY] = true;
            dfs(board, used, newX, newY, node, res);
            used[newX][newY] = false;
        }

    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.row && y >= 0 && y < this.col;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{new char[]{'a', 'a'}};
        String[] words = new String[] {"aaa"};
        List<String> res = new Solution3().findWords(board, words);
        System.out.println(res);
    }

}



