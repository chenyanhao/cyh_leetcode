package p092反转链表2;

class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseFirstN(head, n);
        }

        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    /**
     * 递归反转以 head 为起点的 n 个节点，返回新的头结点
     */
    private static ListNode reverseFirstN(ListNode head, int n) {
        if (n == 1) {
            return head;
        }
        ListNode newHead = reverseFirstN(head.next, n - 1);
        ListNode tmp = head.next.next;
        head.next.next = head;
        head.next = tmp;
        return newHead;
    }
}