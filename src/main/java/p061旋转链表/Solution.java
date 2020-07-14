package p061旋转链表;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 将原链表转化为循环链表来处理
     *
     * @param head
     * @param k
     * @return
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

    /**
     * 思路：转化为寻找链表倒数第 k%n 个元素
     *
     * 1. 原链表的倒数第k个元素(当k<=head.length)，然后将它变为新的head
     * 2. 断开它与前一个元素的链接
     * 3. 将原链表的最后一个节点指向原链表的head
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight2(ListNode head, int k) {
        return null;
    }
}