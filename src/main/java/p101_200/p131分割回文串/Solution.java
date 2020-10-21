package p101_200.p131分割回文串;

import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s, 0, new LinkedList<>(), res);
        return res;
    }

    private void dfs(String s, int start, LinkedList<String> path, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        List<Integer> selectionList = getSelections(s, start);
        for (Integer selection : selectionList) {
            path.addLast(s.substring(start, selection + 1));
            dfs(s, selection + 1, path, res);
            path.removeLast();
        }
    }

    private List<Integer> getSelections(String s, int start) {
        List<Integer> endList = new ArrayList<>();
        for (int i = start; i < s.length(); ++i) {
            if (isPalindrome(s, start, i)) {
                endList.add(i);
            }
        }
        return endList;
    }

    /**
     * 判断 [start,end] 是否为回文串，这里的复杂度是 O(N)。
     * 可以利用空间换时间，定义并提前计算好 boolean dp[i][j] 数组，表示 [i,j] 是否为回文串，
     * 这样就可以将判断是否为回文串的复杂度优化到 O(1)
     */
    private boolean isPalindrome(String s, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                ++i;
                --j;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aabcbd";
        List<List<String>> res = new Solution().partition(s);
        System.out.println(res.size());
        System.out.println(res);
    }

}