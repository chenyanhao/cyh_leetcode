package p001_p100.p057插入区间;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        // 查找插入的位置
        int insertIndex = findInsertIndex(intervals, newInterval);

        // 数组合并
        int[][] merged = new int[intervals.length + 1][];
        int p = 0, q = 0;
        while (p < merged.length) {
            if (p == insertIndex) {
                merged[p++] = newInterval;
            } else {
                merged[p++] = intervals[q++];
            }
        }

        // 区间合并
        List<int[]> res = new ArrayList<>();
        res.add(merged[0]);
        for (int i = 1; i < merged.length; ++i) {
            int[] curInterval = merged[i];
            int[] peek = res.get(res.size() - 1);
            if (curInterval[0] <= peek[1]) { // 该区间需要合并进已有区间
                peek[1] = Math.max(curInterval[1], peek[1]);
            } else { // 需要重建新区间
                res.add(merged[i]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    private static int findInsertIndex(int[][] intervals, int[] newInterval) {
        int left = 0, right = intervals.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (intervals[mid][0] == newInterval[0]) {
                return mid;
            } else if (intervals[mid][0] > newInterval[0]) {
                right = mid - 1;
            } else if (intervals[mid][0] < newInterval[0]) {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] {
                {1, 3},
                {6, 9}
        };
        int[] newInterval = new int[] {2, 5};
        int[][] result = insert(intervals, newInterval);
        System.out.println(result.length);
    }
}