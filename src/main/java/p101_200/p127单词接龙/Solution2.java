package p101_200.p127单词接龙;

import java.util.*;

class Solution2 {

    /**
     * 双向 dfs
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        wordList.add(beginWord);
        int start = wordList.size() - 1; // beginWord 的 index
        int end = wordList.indexOf(endWord); // endWord 的 index

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        Set<Integer> visited1 = new HashSet<>();
        Set<Integer> visited2 = new HashSet<>();

        // 自顶向下 dfs
        q1.offer(start);
        visited1.add(start);
        // 自底向上 dfs
        q2.offer(end);
        visited2.add(end);

        int count1 = 0;
        int count2 = 0;
        while (! q1.isEmpty() && ! q2.isEmpty()) {
            ++count1;
            int size1 = q1.size();
            while (size1 > 0) {
                String s = wordList.get(q1.poll());
                for (int i = 0; i < wordList.size(); ++i) {
                    if (visited1.contains(i)) {
                        continue;
                    }
                    if (! canConvert(s, wordList.get(i))) {
                        continue;
                    }
                    if (visited2.contains(i)) {
                        return count1 + count2 + 1;
                    }
                    visited1.add(i);
                    q1.offer(i);
                }
                --size1;
            }

            ++count2;
            int size2 = q2.size();
            while (size2 > 0) {
                String s = wordList.get(q2.poll());
                for (int i = 0; i < wordList.size(); ++i) {
                    if (visited2.contains(i)) {
                        continue;
                    }
                    if (! canConvert(s, wordList.get(i))) {
                        continue;
                    }
                    if (visited1.contains(i)) {
                        return count1 + count2 + 1;
                    }
                    visited2.add(i);
                    q2.offer(i);
                }
                --size2;
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
}