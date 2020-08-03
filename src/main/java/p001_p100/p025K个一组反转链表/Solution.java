package p001_p100.p025K个一组反转链表;

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

    /**
     * 递归反转链表，左闭右开，即 [head, tail)
     *
     * @param head
     * @param tail
     * @return
     */
    private ListNode reverse2(ListNode head, ListNode tail) {
        if (head == tail || head.next == tail) {
            return head;
        }

        ListNode next = head.next;
        ListNode newHead = reverse(next, tail);
        next.next = head;
        head.next = null; // 这一步不可少

        return newHead;
    }
}