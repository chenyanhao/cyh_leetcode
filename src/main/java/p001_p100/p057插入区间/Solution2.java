package p001_p100.p057插入区间;

import java.util.LinkedList;

/**
 * 1. 将 newInterval 之前开始的区间添加到输出。
 * 2. 添加 newInterval 到输出，若 newInterval 与输出中的最后一个区间重合则合并他们。
 * 3. 一个个添加区间到输出，若有重叠部分则合并他们。
 *
 */
public class Solution2 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> ans = new LinkedList<>();

        // 将新区间左边且不相交的区间加入结果集
        // 例如：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
        // 循环执行完，ans=[[1, 2]] idx=1
        int idx = 0;
        while (idx < intervals.length && intervals[idx][1] < newInterval[0]) {
            ans.add(intervals[idx]);
            ++idx;
        }

        // 判断当前区间是否与新区间重叠，重叠就进行合并
        // 循环执行完，ans=[[1, 2], [3, 10]] idx=4
        int left = newInterval[0], right = newInterval[1];
        while (idx < intervals.length && intervals[idx][0] <= newInterval[1]) {
            left = Math.min(left, intervals[idx][0]);
            right = Math.max(right, intervals[idx][1]);
            ++idx;
        }
        ans.add(new int[]{left, right});

        // 将剩下的区间加入结果集
        while (idx < intervals.length) {
            ans.add(intervals[idx]);
            ++idx;
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}
