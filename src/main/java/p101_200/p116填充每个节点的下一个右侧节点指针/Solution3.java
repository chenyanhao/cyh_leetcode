package p101_200.p116填充每个节点的下一个右侧节点指针;

class Solution3 {

    /**
     * 优化 bfs 解法的复杂度，当第 N 层节点的 next 指针全部建立完成后，
     * 借助已建立好的 next 指针，建立第 N+1 层节点的 next 指针。
     *
     * 此时分两种情况，同递归解法：
     *  1）node.left.next = node.right
     *  2）node.right.next = node.next.left
     *
     *  时间复杂度：O(N)
     *  空间复杂度：O(1)
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node leftmost = root;
        while (leftmost.left != null) {
            // 每一层可以看做一个链表，head 指针初始化时指向每层链表的头结点，leftmost 指向每一层的最左节点
            Node head = leftmost;
            while (head != null) {
                head.left.next = head.right;

                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                head = head.next;
            }
            leftmost = leftmost.left;
        }

        return root;
    }

}