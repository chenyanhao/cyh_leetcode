package p001_p100.p024两两交换链表中的节点;

/**
 * 循环迭代写法
 */
class Solution3 {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode tmp = pre;
        while (tmp.next != null && tmp.next.next != null) {
            ListNode start = tmp.next;
            ListNode end = tmp.next.next;
            tmp.next = end;
            start.next = end.next;
            end.next = start;

            tmp = start;
        }
        return pre.next;
    }
}