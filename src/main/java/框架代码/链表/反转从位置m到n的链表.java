package 框架代码.链表;

public class 反转从位置m到n的链表 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseFirstN(head, n);
        }

        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    /**
     * 递归反转以 head 为起点的 n 个节点，返回新的头结点
     */
    private static ListNode reverseFirstN(ListNode head, int n) {
        if (n == 1) {
            return head;
        }
        ListNode newHead = reverseFirstN(head.next, n - 1);
        ListNode tmp = head.next.next;
        head.next.next = head;
        head.next = tmp;
        return newHead;
    }


    /**
     *
     * 思路：通过删除链表节点的思想来达到反转链表的目的。
     * 定义两个指针，分别称之为 guard(守卫)和 point(当前指针)。
     * 1、根据方法的参数 m 确定 guard 和 point 的位置：将 guard 移动到第一个要反转的节点的前面，将 point 移动到第一个要反转的节点的位置上。
     * 2、将 point 后面的元素删除（即下面代码中的 removed）（注意，不是真删除了，只是改变了一些节点的指向关系，用删除一词是为了方便理解），然后添加到 guard 的后面，也即头插法。
     * 3、根据 m 和 n 重复步骤 2
     *
     */
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode headFirst = new ListNode(-1);
        headFirst.next = head;
        ListNode guard = headFirst;
        ListNode point = headFirst.next;

        int step = 1;
        while (step <= m - 1) { // 一共循环 (m - 1) 次，循环结束后，step = m
            guard = guard.next;
            point = point.next;
            ++step;
        }

        while (step <= n - 1) { // 一共循环 (n - m) 次
            ListNode removed = point.next;
            point.next = point.next.next;

            removed.next = guard.next;
            guard.next = removed;

            ++step;
        }

        return headFirst.next;
    }

}
