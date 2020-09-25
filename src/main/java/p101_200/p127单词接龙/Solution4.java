package p101_200.p127单词接龙;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Queue;
import java.util.Arrays;

class Solution4 {

    /**
     * 判断当前单词可以转换成哪些候选单词（未访问的单词），这里可以进行优化。
     * 一共两种办法：
     *  1) 遍历所有候选单词，判断当前单词是否可以转换成这个候选单词。判断的过程也就是前面的canConvert方法，逐个对比单词的字符。
     *  2) 因为单词是由a~z这有限数量的字符组成的，可以遍历当前单词能转换成的所有单词，判断其是否包含在候选单词中。候选单词用HashSet保存，O(1)的查找性能。
     *
     *  当单词总数量庞大的时候，之前代码用到的思路 1 耗时就会很长。
     *  而当单词的字符串数量、单词长度很大时，思路 2 耗时就会更长。
     *  实际情况下，一般单词不会很长，字符也是固定的26个小写字母，因此思路2的性能会好很多。
     *
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        wordList.add(beginWord);
        Set<String> allWords = new HashSet<>();

        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();

        // 自顶向下 dfs
        q1.offer(beginWord);
        visited1.add(beginWord);
        // 自底向上 dfs
        q2.offer(endWord);
        visited2.add(endWord);

        int level = 0;
        while (! q1.isEmpty() && ! q2.isEmpty()) {
            if (q1.size() > q2.size()) {
                // 交换 q1 和 q2，使得 q1 始终是 size 更小的一方
                Queue<String> tmp1 = q1;
                q1 = q2;
                q2 = tmp1;

                // 交换 visited1 和 visited2
                Set<String> tmp2 = visited1;
                visited1 = visited2;
                visited2 = tmp2;
            }

            // 至此就可以保证 q1 size 是更小的一方，即接下来的遍历始终从更小 size 的队列出发
            ++level;
            int size1 = q1.size();
            while (size1 > 0) {
                String s = q1.poll();
                char[] chars = s.toCharArray();
                for (int j = 0; j < s.length(); ++j) {
                    // 保存第j位的原始字符，以便后面恢复
                    char tmp = chars[j];

                    // 遍历当前单词能转换成的所有单词，判断其是否包含在候选单词中
                    for (char c = 'a'; c <= 'z'; ++c) {
                        chars[j] = c;
                        String newString = new String(chars);
                        if (visited1.contains(newString)) { // 已经访问过了，跳过
                            continue;
                        }
                        if (visited2.contains(newString)) { // 两端遍历相遇，结束遍历
                            return level + 1;
                        }
                        if (allWords.contains(newString)) {
                            q1.offer(newString);
                            visited1.add(newString);
                        }
                    }

                    // 恢复第j位的原始字符
                    chars[j] = tmp;
                }
                --size1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        int res = Solution4.ladderLength(beginWord, endWord, wordList);
        System.out.println(res);
    }

}