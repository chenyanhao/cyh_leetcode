package p101_200.p133克隆图;

import java.util.*;

class Solution2 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> visited = new HashMap<>();
        LinkedList<Node> q = new LinkedList<>();
        q.offer(node);
        visited.put(node, new Node(node.val, new ArrayList<>()));

        while (! q.isEmpty()) {
            Node cur = q.poll();
            List<Node> curClonedNeighbors = visited.get(cur).neighbors;
            for (Node neighbor : cur.neighbors) {
                if (visited.containsKey(neighbor)) {
                    curClonedNeighbors.add(visited.get(neighbor));
                } else {
                    Node clonedNeighbor = new Node(neighbor.val, new ArrayList<>());
                    curClonedNeighbors.add(clonedNeighbor);

                    q.offer(neighbor);
                    visited.put(neighbor, clonedNeighbor);
                }
            }
        }

        return visited.get(node);
    }
}