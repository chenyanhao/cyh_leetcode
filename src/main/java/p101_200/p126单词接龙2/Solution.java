package p101_200.p126单词接龙2;

import java.util.*;

class Solution {

    private Map<String, Integer> wordId = new HashMap<>();
    private ArrayList<String> idWord = new ArrayList<>();

    /**
     * 可以把每个单词都抽象为一个点，如果两个单词可以只改变一个字母进行转换，
     * 那么说明他们之间有一条双向边。因此只需要把满足转换条件的点相连，就形成了一张图。
     * 于是，本题很自然的转换成了一个 BFS 的问题。
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int id = 0;
        // 将wordList所有单词加入wordId中 相同的只保留一个 // 并为每一个单词分配一个id
        for (String word : wordList) {
            if (! wordId.containsKey(word)) {
                wordId.put(word, id);
                ++id;
                idWord.add(word);
            }
        }

        // 若endWord不在wordList中 则无解
        if (! wordId.containsKey(endWord)) {
            return new ArrayList<>();
        }

        // 把beginWord也加入wordId中
        if (! wordId.containsKey(beginWord)) {
            wordId.put(beginWord, id);
            ++id;
            idWord.add(beginWord);
        }

        // 初始化存边用的数组
        ArrayList<Integer>[] edges = initEdges();

        List<List<String>> res = new ArrayList<>(); // 存答案
        int[] cost = new int[id]; // // 到每个点的代价
        for (int i = 0; i < cost.length; ++i) {
            cost[i] = Integer.MAX_VALUE; // 每个点的代价初始化为无穷大
        }

        // 将起点加入队列 并将其cost设为0
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        q.add(new ArrayList<>(Arrays.asList(wordId.get(beginWord))));
        cost[wordId.get(beginWord)] = 0;

        // 开始广度优先搜索
        int dest = wordId.get(endWord); // 目的ID
        while (! q.isEmpty()) {
            ArrayList<Integer> now = q.poll();
            int last = now.get(now.size() - 1);
            if (last == dest) { // 若该点为终点则将其存入答案res中
                ArrayList<String> tmp = new ArrayList<>();
                for (int index : now) {
                    tmp.add(idWord.get(index));
                }
                res.add(tmp);
            } else { // 该点不为终点 继续搜索
                for (int i = 0; i < edges[last].size(); ++i) {
                    int to = edges[last].get(i);
                    if (cost[last] + 1 <= cost[to]) { // 把代价相同的不同路径全部保留下来
                        cost[to] = cost[last] + 1;
                        // 把to加入路径中
                        ArrayList<Integer> tmp = new ArrayList<>(now);
                        tmp.add(to);
                        q.add(tmp); // 把这个路径加入队列
                    }
                }
            }
        }

        return res;
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

    private ArrayList<Integer>[] initEdges() {
        ArrayList<Integer>[] edges = new ArrayList[idWord.size()];
        for (int i = 0; i < idWord.size(); ++i) {
            edges[i] = new ArrayList<>();
        }
        // 添加边
        for (int i = 0; i < idWord.size(); ++i) {
            for (int j = i + 1; j < idWord.size(); ++j) {
                if (transformCheck(idWord.get(i), idWord.get(j))) {
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }
        return edges;
    }

}