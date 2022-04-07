package p201_300.p207课程表;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 将每门课程抽象为图的一个节点，先修课程之间存在一条有向边，那么该问题可转化为：有向图中是否存在环。
 *
 * 用拓扑排序来求解。本解法用 DFS，几个可以帮助理解的小细节如下，
 * 1) 用一个栈来存储所有已经搜索完成的节点
 * 2) 对于一个节点 u，如果它的所有相邻节点都已经搜索完成，那么在搜索回溯到 u 的时候，u 本身也会变成一个已经搜索完成的节点。
 * 3) 假设当前搜索到了节点 u，如果它的所有相邻节点都已经搜索完成，那么这些节点都已经在栈中了，此时把 u 入栈。
 *    可以发现，如果从栈顶往栈底的顺序看，由于 u 处于栈顶的位置，那么 u 出现在所有 u 的相邻节点的前面。
 *    因此对于 u 这个节点而言，它是满足拓扑排序的要求的。
 *    这样一来就有 DFS 递归的感觉了：对图进行一遍深度优先搜索。当每个节点进行回溯的时候，把该节点放入栈中。最终从栈顶到栈底的序列就是一种拓扑排序。
 * 4) 对于图中的任意一个节点，它在搜索的过程中有三种状态，即：
 *    「未搜索」：还没有搜索到这个节点；
 *    「搜索中」：搜索过这个节点，但还没有回溯到该节点，即该节点还没有入栈，还有相邻的节点没有搜索完成；
 *    「已完成」：搜索过并且回溯过这个节点，即该节点已经入栈，并且所有该节点的相邻节点都出现在栈的更底部的位置，满足拓扑排序的要求。
 *
 * 因此 DFS 几个关键点如下：
 * 1) 将当前搜索的节点 u 标记为「搜索中」，遍历该节点的每一个相邻节点 v：
 *    - v 为「未搜索」，那么开始搜索 v，待搜索完成回溯到 u
 *    - v 为「搜索中」，那么就找到了图中的一个环，因此是不存在拓扑排序的
 *    - v 为「已完成」，那么说明 v 已经在栈中了，而 u 还不在栈中，因此 u 无论何时入栈都不会影响到 (u,v) 之前的拓扑关系，以及不用进行任何操作
 * 2) 当 u 的所有相邻节点都为「已完成」时，将 u 放入栈中，并将其标记为「已完成」。
 * 3) 在整个深度优先搜索的过程结束后，如果没有找到图中的环，那么栈中存储这所有的 n 个节点，从栈顶到栈底的顺序即为一种拓扑排序。
 * 4) 由于本题只需要判断是否存在一种拓扑排序，而栈的作用仅仅是存放最终的拓扑排序结果，因此可以只记录每个节点的状态，而省去对应的栈。
 *
 * 具体求解思路点如下，
 * 1) 借助一个标志列表 flags，用于判断每个节点 i 的状态：
 *     flags[i] == 0:  未被 DFS 访问，相当于「未搜索」
 *     flags[i] == -1: 已被其他节点启动的 DFS 访问，相当于「已完成」
 *     flags[i] == 1:  已被当前节点启动的 DFS 访问，相当于「搜索中」
 * 2) 对 numCourses 个节点依次执行 DFS，判断每个节点起步 DFS 是否存在环，若存在环直接返回 False
 *
 * 其中 DFS 流程为：
 * 1）终止条件
 *  - flags[i] == -1: 说明当前访问节点已被其他节点启动的 DFS 访问，无需再重复搜索，直接返回 True
 *  - flags[i] == 1:  说明在本轮 DFS 搜索中节点 i 被第 2 次访问，即图有环，直接返回 False
 * 2）将当前访问节点 i 对应 flag[i] 置 1，即标记其被本轮 DFS 访问过
 * 3）递归访问当前节点 i 的所有邻接节点 j，当发现环直接返回 False
 * 4）当前节点所有邻接节点已被遍历，并没有发现环，则将当前节点 flag 置为 −1 并返回 True
 *
 *
 * 时间复杂度 O(N+M)：遍历一个图需要访问所有节点和所有邻边，N 和 M 分别为节点数量和邻边数量；
 * 空间复杂度 O(N+M)：建立邻接表需额外空间，adjacency 长度为 N ，并存储 M 条邻边的数据。
 *
 */
class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for(int i = 0; i < numCourses; ++i) {
            adjacency.add(new ArrayList<>());
        }

        for(int[] cp : prerequisites) {
            adjacency.get(cp[1]).add(cp[0]);
        }

        int[] flags = new int[numCourses];
        for(int i = 0; i < numCourses; ++i) {
            if(!dfs(adjacency, flags, i)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 节点 i 是否存在一种拓扑排序。存在返回true，不存在返回false。
     */
    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if (flags[i] == 1) {
            return false;
        }
        if (flags[i] == -1) {
            return true;
        }

        flags[i] = 1;
        for (int adj : adjacency.get(i)) {
            if (! dfs(adjacency, flags, adj)) {
                return false;
            }
        }
        flags[i] = -1;
        return true;
    }
}