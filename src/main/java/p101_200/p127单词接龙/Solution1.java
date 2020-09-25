package p101_200.p127单词接龙;

import java.util.*;

class Solution1 {
    /**
     * 通用、朴素的 dfs
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (! wordList.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(beginWord);
        visited.add(beginWord);

        int level = 0;
        while (! q.isEmpty()) {
            ++level;
            int size = q.size();
            for (int i = 0; i < size; ++i) { // i 不使用，仅仅是控制循环次数
                String start = q.poll();
                for (String s : wordList) {
                    if (visited.contains(s)) {
                        continue;
                    }
                    if (! canConvert(start, s)) {
                        continue;
                    }
                    if (s.equals(endWord)) {
                        return level + 1;
                    }
                    visited.add(s);
                    q.offer(s);
                }
            }
        }

        return 0;
    }

    private boolean canConvert(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) != b.charAt(i)) {
                ++count;
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        int res = new Solution1().ladderLength(beginWord, endWord, wordList);
        System.out.println(res);
    }
}