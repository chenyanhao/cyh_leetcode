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
        int newStart = newInterval[0], newEnd = newInterval[1];
        int idx = 0, n = intervals.length;
        LinkedList<int[]> output = new LinkedList<>();

        while (idx < n && newStart > intervals[idx][0]) {
            output.add(intervals[idx]);
            ++idx;
        }

        if (output.isEmpty() || output.getLast()[1] < newStart) {
            output.add(newInterval);
        } else {
            int[] interval = output.removeLast();
            interval[1] = Math.max(newEnd, interval[1]);
            output.add(interval);
        }

        while (idx < n) {
            int[] interval = intervals[idx++];
            int start = interval[0], end = interval[1];
            if (output.getLast()[1] < start) {
                output.add(interval);
            } else {
                interval = output.removeLast();
                interval[1] = Math.max(end, interval[1]);
                output.add(interval);
            }
        }

        return output.toArray(new int[output.size()][2]);
    }
}
