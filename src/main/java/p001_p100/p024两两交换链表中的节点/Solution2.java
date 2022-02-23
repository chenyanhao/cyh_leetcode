package p001_p100.p024两两交换链表中的节点;

/**
 * 含哑节点的递归写法
 */
class Solution2 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) { // 递归结束条件
            return head;
        }

        // 递归操作头两个节点之后的节点
        ListNode newHead = swapPairs(head.next.next);
        head.next.next = null;

        // 交换头两个节点
        ListNode pre = new ListNode(-1);
        pre.next = head.next;
        pre.next.next = head;

        // 两部分相连
        head.next = newHead;

        return pre.next;
    }

}