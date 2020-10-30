package p101_200.p138复制带随机指针的链表;

import java.util.HashMap;
import java.util.Map;

class Solution2 {

    private Map<Node, Node> visited = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node oldNode = head;
        Node newNode = new Node(oldNode.val);
        visited.put(oldNode, newNode);
        while (oldNode != null) {
            newNode.next = doClone(oldNode.next);
            newNode.random = doClone(oldNode.random);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }

        return visited.get(head);
    }

    private Node doClone(Node node) {
        if (node == null) {
            return null;
        }

        if (visited.containsKey(node)) {
            return visited.get(node);
        } else {
            Node cloned = new Node(node.val);
            visited.put(node, cloned);
            return cloned;
        }
    }
}