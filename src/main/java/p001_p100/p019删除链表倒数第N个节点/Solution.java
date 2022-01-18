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
 * 注意，可能把头节点删掉，例如 [1, 2]，删掉倒数第二个。所以需要置一个空节点，其 next 指向 head
 * 过程中注意防止各种空指针，例如 right.next 为空等。
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode curr = pre;

        // 求出链表长度
        int length = 0;
        while (curr.next != null) {
            ++length;
            curr = curr.next;
        }

        // 找到待删除节点的前一个节点
        curr = pre;
        for (int i = 0; i < length - n; ++i) {
            curr = curr.next;
        }

        // 执行删除操作
        ListNode deleted = curr.next;
        curr.next = deleted.next;
        deleted.next = null;

        return pre.next;
    }
}