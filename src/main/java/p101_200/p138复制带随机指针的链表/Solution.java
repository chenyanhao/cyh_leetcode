package p101_200.p138复制带随机指针的链表;

import java.util.HashMap;
import java.util.Map;

class Solution {

    private Map<Node, Node> visited = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        if (visited.containsKey(head)) {
            return visited.get(head);
        }

        Node node = new Node(head.val);
        visited.put(head, node);

        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }
}