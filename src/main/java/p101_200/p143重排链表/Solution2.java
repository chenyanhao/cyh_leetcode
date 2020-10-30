package p101_200.p143重排链表;

/**
 * 优化空间复杂度。
 *
 * 原问题等价于三个子问题：寻找链表中点 + 链表逆序 + 合并链表
 * 1）快慢指针来找链表中点；
 * 2）右半端链表反转；
 * 3）链表合并。
 */
class Solution2 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode mid = getMid(head);

        ListNode head2 = mid.next;
        mid.next = null;
        head2 = reverse(head2);

        merge(head, head2);
    }

    /**
     * 快慢指针返回中间节点
     * 奇数：1 -> 2 -> 3，返回节点 2
     * 偶数：1 -> 2 -> 3 -> 4，返回节点 2
     */
    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 递归反转单链表
     */
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        ListNode newHead = reverse(head.next);
        next.next = head;
        head.next = null; // 这一步不可少
        return newHead;
    }

    private void merge(ListNode l1, ListNode l2) {
        ListNode l1Next, l2Next;
        while (l1 != null && l2 != null) {
            l1Next = l1.next;
            l2Next = l2.next;

            l1.next = l2;
            l2.next = l1Next;

            l1 = l1Next;
            l2 = l2Next;
        }
    }
}