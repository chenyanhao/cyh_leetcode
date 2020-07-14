package p025;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head;
        for (int i = 0; i < k; ++i) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }

        ListNode newHead = reverse(head, tail);
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    /**
     * 反转链表，左闭右开，即 [head, tail)
     * @param head
     * @param tail
     * @return
     */
    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode next = null;
        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}