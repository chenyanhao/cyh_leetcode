package p001_p100.p056合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][];
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for (int i = 1; i < intervals.length; ++i) {
            int[] curInterval = intervals[i];
            int[] peek = merged.get(merged.size() - 1);
            if (curInterval[0] <= peek[1]) { // 该区间需要合并进已有区间
                peek[1] = Math.max(curInterval[1], peek[1]);
            } else { // 需要重建新区间
                merged.add(intervals[i]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}