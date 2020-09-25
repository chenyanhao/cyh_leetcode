package p101_200.p127单词接龙;

import java.util.*;

class Solution3 {

    /**
     * 优化上一版双向 dfs，每次遍历一层时，从节点更少的一端遍历。
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

        int count = 0;
        while (! q1.isEmpty() && ! q2.isEmpty()) {
            ++count;
            if (q1.size() > q2.size()) {
                // 交换 q1 和 q2，使得 q1 始终是 size 更小的一方
                Queue<Integer> tmp1 = q1;
                q1 = q2;
                q2 = tmp1;

                // 交换 visited1 和 visited2
                Set<Integer> tmp2 = visited1;
                visited1 = visited2;
                visited2 = tmp2;
            }

            // 至此就可以保证 q1 size 是更小的一方，即接下来的遍历始终从更小 size 的队列出发
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
                        return count + 1;
                    }
                    visited1.add(i);
                    q1.offer(i);
                }
                --size1;
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