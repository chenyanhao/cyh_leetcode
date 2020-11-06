package p101_200.p151翻转字符串里的单词;

/**
 * 定义两个指针 left/right，闭区间 [left, right] 表示一个符合条件的单词。
 *
 * 算法步骤如下，
 * 1）从 s 结尾开始找，找到第一个不为空的字符，初始化为 left/right；
 * 2）left 往前找，找到第一个 left-1 位置为空的字符；
 * 3）[left, right] 即为符合条件的单词，添加到结果集中，同时添加空格；
 * 4）cur 指针更新为 left-1，继续下一轮循环。
 *
 */
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int cur = s.length() - 1;
        while (cur >= 0) {
            if (s.charAt(cur) == ' ') {
                --cur;
                continue;
            }

            int left = cur, right = cur;
            while (left - 1 >= 0 && s.charAt(left - 1) != ' ') {
                --left;
            }

            sb.append(s, left, right + 1);
            sb.append(" ");
            cur = left - 1;
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
//        String s = "  Bob    Loves  Alice   ";
        String s = "a";
        String res = new Solution().reverseWords(s);
        System.out.println(res);
    }
}