package 框架代码.链表;

/**
 * 快慢指针返回中间节点，奇数个节点找到中点，偶数个节点找到中心左边的节点，例如，
 *  - 奇数：1 -> 2 -> 3，返回节点 2
 *  - 偶数：1 -> 2 -> 3 -> 4，返回节点 2
 *
 * 如果只有一个节点，那么直接返回该节点
 *
 */
public class 快慢指针返回中间节点 {

    /**
     * 跟推荐 getMid1 这种写法
     *
     */
    private ListNode getMid1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode getMid2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
