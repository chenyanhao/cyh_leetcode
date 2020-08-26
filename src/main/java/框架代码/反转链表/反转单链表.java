package 框架代码.反转链表;

public class 反转单链表 {

    /**
     * 循环反转链表
     */
    public ListNode reverse1(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;

            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 递归反转链表
     */
    public ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        ListNode newHead = reverse2(head.next);
        next.next = head;
        head.next = null;

        return newHead;
    }

    /**
     * 反转链表，左闭右开，即 [head, tail)
     */
    public ListNode reverse(ListNode head, ListNode tail) {
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
     */
    public ListNode reverse2(ListNode head, ListNode tail) {
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
