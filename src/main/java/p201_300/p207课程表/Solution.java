package p201_300.p207课程表;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 将每门课程抽象为图的一个节点，先修课程之间存在一条有向边，那么该问题可转化为：有向图中是否存在环。
 *
 * 用拓扑排序来求解。本解法用 BFS，步骤如下，
 * 1）统计图中每个节点的入度，生成入度表 inDegrees
 * 2）借助一个队列 queue，将所有入度为 0 的节点入队
 * 3）当 queue 非空时，依次将首节点出队，将此节点对应所有邻接节点的入度 −1
 *  - 若入度 −1 后，邻接节点 adj 的入度为 0，说明 adj 所有的前驱节点已经被"删除"，此时将 adj 入队
 * 4）在每次节点出队时，执行 numCourses--
 *  - 若整个图无环，则所有节点一定都入队并出队过，即完成拓扑排序
 *  - 若图中存在环，一定有节点的入度始终不为 0。
 * 5）拓扑排序出队次数等于课程个数，返回 numCourses == 0 判断课程是否可以成功安排
 *
 * 时间复杂度 O(N+M)：遍历一个图需要访问所有节点和所有邻边，N 和 M 分别为节点数量和邻边数量；
 * 空间复杂度 O(N+M)：建立邻接表需额外空间，adjacency 长度为 N ，并存储 M 条邻边的数据。
 *
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

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

        int visited = 0;
        // 拓扑排序
        while (! queue.isEmpty()) {
            int cur = queue.poll();
            ++visited;
            for (int adj : adjacency.get(cur)) {
                inDegrees[adj] -= 1; // cur 节点对应所有邻接节点的入度 −1
                if (inDegrees[adj] == 0) { // 入度 −1 后，若邻接节点的入度为 0，则加入队列
                    queue.add(adj);
                }
            }
        }

        return numCourses == visited;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{new int[] {0, 1}}; // [[0, 1]]
        boolean canFinish = new Solution().canFinish(numCourses, prerequisites);
        System.out.println(canFinish);
    }

}