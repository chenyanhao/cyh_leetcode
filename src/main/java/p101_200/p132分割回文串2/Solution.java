package p101_200.p132分割回文串2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 整体思路和解法参考p131题，还是通过递归解决问题，但是本题需要求出最小的分割次数，反映在递归上面就是递归树的深度最小，或者说搜索路径最短。
 * 但是事先并不知道最短的路径长度是多少，所以需要一个全局变量来保存当前的最短路径长度，
 * 1）如果找到的新的路径的长度比之前的路径短，就把之前的结果清空，重新找；
 * 2）如果是最小的长度，就加入到结果中。
 *
 * 同时利用最短路径长度优化剪枝，即当前的遍历长度到达了目前已知的最短路径长度，但是递归还没结束，那么该路径就可以剪枝。
 *
 * 这种解法还是会超时，需要继续优化
 *
 */
class Solution {

    private int minLength = Integer.MAX_VALUE;

    public int minCut(String s) {
        dfs(s, 0, new LinkedList<>());
        return minLength - 1;
    }

    private void dfs(String s, int start, LinkedList<String> path) {
        if (start == s.length()) {
            minLength = Math.min(minLength, path.size());
            return;
        }

        // 当前的长度到达了 min，还是递归没有结束，所以剪枝
        if (path.size() >= minLength) {
            return;
        }

        List<Integer> selectionList = getSelections(s, start);
        for (Integer selection : selectionList) {
            path.addLast(s.substring(start, selection + 1));
            dfs(s, selection + 1, path);
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
        int res = new Solution().minCut(s);
        System.out.println(res);
    }


}