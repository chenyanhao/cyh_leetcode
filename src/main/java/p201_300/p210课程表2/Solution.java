package p201_300.p210课程表2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>(); // 邻接表
        for (int i = 0; i < numCourses; ++i) {
            adjacency.add(new ArrayList<>());
        }

        int[] inDegrees = new int[numCourses]; // 入度数组
        for (int[] cp : prerequisites) {
            inDegrees[cp[0]] += 1;
            adjacency.get(cp[1]).add(cp[0]);
        }

        Queue<Integer> queue = new LinkedList<>(); // BFS 队列
        for (int i = 0; i < numCourses; ++i) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        int[] res = new int[numCourses]; // 存储拓扑排序结果
        int count = 0; // 当前结果集列表里的元素个数，正好可以作为下标

        // 拓扑排序
        while (! queue.isEmpty()) {
            int cur = queue.poll();

            // 入结果集
            res[count] = cur;
            ++count;

            for (int adj : adjacency.get(cur)) {
                inDegrees[adj] -= 1; // cur 节点对应所有邻接节点的入度 −1
                if (inDegrees[adj] == 0) { // 入度 −1 后，若邻接节点的入度为 0，则加入队列
                    queue.add(adj);
                }
            }
        }

        // 如果结果集中的数量不等于结点的数量，就不能完成课程任务，这一点是拓扑排序的结论
        if (count == numCourses) {
            return res;
        }

        return new int[]{};
    }
}