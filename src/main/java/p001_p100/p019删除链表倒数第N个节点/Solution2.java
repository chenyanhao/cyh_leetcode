package p001_p100.p019删除链表倒数第N个节点;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * 用双指针 first 和 second，first 在前，second 在后，两者都初始化为哑结点。
 * 让两者之间相差 n+1 步(若 n 从 1 开始计数)；
 * 当 first 走到头时（first == nullptr），second 所处的位置刚好就是倒数第 n 个节点的前置节点。
 */
class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 都初始化为哑结点
        ListNode first = dummy, second = dummy;

        // first 节点先走 n+1 步（若 n 从 1 开始计数）
        for (int i = 0; i <= n; ++i) {
            first = first.next;
        }

        // 两节点同时走，直到 first 走到头
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // 此时 second 指向倒数第 n 个节点的前置节点
        ListNode deleted = second.next;
        second.next = deleted.next;
        deleted.next = null;

        return dummy.next;
    }
}