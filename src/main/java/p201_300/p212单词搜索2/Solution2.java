package p201_300.p212单词搜索2;

import java.util.*;

/**
 * 该题的解法大框架还是 DFS 回溯，需要改进的地方是判断匹配的过程，也就是递归树可以进一步剪枝。
 *
 * 解法一超时的原因是，匹配多个字符串是否存在，把字符的所有排序可能都列了出来，复杂度过高了。
 * 因此这里需要用前缀树来优化，整体思路为，
 * 1）根据字典中的单词构建一个 TrieNode，稍后将用于匹配过程来对递归剪枝
 * 2）从每个单元格开始，如果字典中存在以单元格中的字母开头的单词，则开始回溯
 *
 *
 */
class Solution2 {

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
                dfs(board, used, i, j, root, res);
            }
        }

        return res;
    }

    // 三个剪枝条件：出边界、已访问、字符不匹配
    private void dfs(char[][] board, boolean[][] used, int i, int j, TrieNode root, List<String> res) {
        if (used[i][j]) {
            return;
        }

        char ch = board[i][j];
        if (root.next[ch - 'a'] == null) {
            return;
        }

        root = root.next[ch - 'a'];
        if (root.word != null) {
            res.add(root.word);
            root.word = null;
        }

        used[i][j] = true;
        for (int k = 0; k < direction.length; ++k) {
            int newX = i + direction[k][0];
            int newY = j + direction[k][1];
            if (! inArea(newX, newY)) {
                continue;
            }
            dfs(board, used, newX, newY, root, res);
        }
        used[i][j] = false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.row && y >= 0 && y < this.col;
    }

}



