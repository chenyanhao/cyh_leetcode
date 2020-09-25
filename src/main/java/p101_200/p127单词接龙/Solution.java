package p101_200.p127单词接龙;

import javafx.util.Pair;

import java.util.*;

class Solution {
    /**
     * 将问题抽象在一个无向无权图中，每个单词作为节点，差距只有一个字母的两个单词之间连一条边。
     * 问题变成找到从起点到终点的最短路径，因此可以使用广度优先搜索方法。
     *
     * 广度优先搜索的模板代码中，有一步是找到节点的所有邻接节点，因此接下来的问题就是：如何高效地找出某节点的邻接节点。
     * 当然可以用穷举的办法，对于每个单词都遍历一下整个字母表，查看是否存在一个单词与该单词只相差一个字母。
     *
     * 这里有一种高效的处理办法，例如，在广搜时要访问 Dug 的所有邻接点，可以先生成 Dug 的所有通用状态：
     *  1)Dug => *ug
     *  2)Dug => D*g
     *  3)Dug => Du*
     *
     * 将这些通用状态保存在 hashMap 中，以空间换时间。
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length(); // 因为所有单词具有相同的长度

        // 构造 dict，以空间换时间
        Map<String, List<String>> dict = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < len; ++i) {
                String commonKey = word.substring(0, i) + "*" + word.substring(i + 1, len);
                List<String> list = dict.getOrDefault(commonKey, new ArrayList<>());
                list.add(word);
                dict.put(commonKey, list);
            }
        }

        // Pair 中，第一个表示具体的 word，第二个表示遍历时该单词图中的 depth
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        Map<String, Boolean> visited = new HashMap<>();
        q.add(new Pair<>(beginWord, 1));
        visited.put(beginWord, true);
        while (! q.isEmpty()) {
            Pair<String, Integer> node = q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < len; ++i) {
                String commonKey = word.substring(0, i) + "*" + word.substring(i + 1, len);
                List<String> adjacentList = dict.getOrDefault(commonKey, new ArrayList<>());
                for (String adj : adjacentList) {
                    if (adj.equals(endWord)) {
                        return level + 1;
                    }
                    if (! visited.containsKey(adj)) {
                        q.add(new Pair<>(adj, level + 1));
                        visited.put(adj, true);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        int res = new Solution().ladderLength(beginWord, endWord, wordList);
        System.out.println(res);
    }
}