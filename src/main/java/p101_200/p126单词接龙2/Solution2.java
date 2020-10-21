package p101_200.p126单词接龙2;

import java.util.*;

/**
 *
 * 使用标准 dfs 求解，该解法会超时
 *
 * 其实不管 BFS 还是 DFS，本题首先要解决的问题是怎么找到节点的所有孩子节点。
 * 大的来说有两种方式：
 * 1）遍历 wordList 来判断每个单词和当前单词是否只有一个字母不同。O(mn) 的复杂度
 * 2）将要找的节点单词的每个位置换一个字符，然后看更改后的单词在不在 wordList 中。整个计算量就是 26n，所以是 O(n)
 *
 * 还要解决的一个问题是，因为要找的是最短的路径，但是事先并不知道最短的路径是多少，
 * 所以需要一个全局变量来保存当前找到的路径的长度，
 * 1）如果找到的新的路径的长度比之前的路径短，就把之前的结果清空，重新找；
 * 2）如果是最小的长度，就加入到结果中。
 *
 */
class Solution2 {

    private int minLengh = Integer.MAX_VALUE;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        ArrayList<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(beginWord, endWord, wordList, path, res);
        return res;
    }

    private void dfs(String beginWord, String endWord, List<String> wordList,
                     ArrayList<String> path, List<List<String>> res) {
        // 递归终止条件 及 res 更新条件
        if (beginWord.equals(endWord)) {
            if (minLengh > path.size()) {
                res.clear();
                minLengh = path.size();
                res.add(new ArrayList<>(path));
            } else if (minLengh == path.size()) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        // 当前的长度到达了 min，还是没有到达结束单词就提前结束
        if (path.size() >= minLengh) {
            return;
        }

        //遍历当前所有的单词
        for (int i = 0; i < wordList.size(); ++i) {
            String curWord = wordList.get(i);

            // 剪枝：路径中已经含有当前单词，如果再把当前单词加到路径，那肯定会使得路径更长，所以跳过
            if (path.contains(curWord)) {
                continue;
            }

            //符合只有一个单词不同，就进入递归
            if (transformCheck(beginWord, curWord)) {
                path.add(curWord);
                dfs(curWord, endWord, wordList, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    // 两个字符串是否可以通过改变一个字母后相等
    private boolean transformCheck(String s1, String s2) {
        int differences = 0;
        for (int i = 0; i < s1.length() && differences < 2; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++differences;
            }
        }
        return differences == 1;
    }

}