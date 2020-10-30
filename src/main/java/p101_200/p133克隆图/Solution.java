package p101_200.p133克隆图;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> visited = new HashMap<>();
        return dfs(node, visited);
    }

    private Node dfs(Node node, Map<Node, Node> visited) {
        if (node == null) {
            return null;
        }

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // clone 本节点，为了深拷贝我们不克隆它的邻居的列表
        Node clone = new Node(node.val, new ArrayList<>());
        /**
         * 注意：
         * 在进入递归之前，必须先创建克隆节点并保存在哈希表中。
         * 如果不保证这种顺序，可能会在递归中再次遇到同一个节点，再次遍历该节点时，陷入死循环。
         */
        visited.put(node, clone);
        for (Node n : node.neighbors) {
            clone.neighbors.add(dfs(n, visited)); // clone 邻居节点
        }
        return clone;
    }
}