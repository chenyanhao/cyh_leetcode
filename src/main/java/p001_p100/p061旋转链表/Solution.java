package p001_p100.p061旋转链表;

class Solution {
    /**
     * 将原链表转化为循环链表来处理
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        // 1. 得到链表长度，并转化为循环链表
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            ++len;
            tail = tail.next;
        }
        tail.next = head;

        // 2. 循环链表上移动指针
        int step = len - k % len;
        ListNode cur = head, pre = tail;
        while (step > 0) {
            cur = cur.next;
            pre = pre.next;
            --step;
        }
        pre.next = null;

        return cur;
    }

}