package p001_p100.p061旋转链表;

class Solution2 {


    /**
     * 思路：转化为寻找链表倒数第 k%n 个元素
     *
     * 1. 原链表的倒数第k个元素(当k<=head.length)，然后将它变为新的head
     * 2. 断开它与前一个元素的链接
     * 3. 将原链表的最后一个节点指向原链表的head
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        // 初始化哑结点
        ListNode pre = new ListNode(-1);
        pre.next = head;

        // 得到链表长度（计数从1开始），同时得到最后一个节点的指针
        int length = 0;
        ListNode tail = pre;
        while (tail.next != null) {
            tail = tail.next;
            ++length;
        }

        // k 值归一化
        k = k % length;
        if (k == 0) { // 注意这里 badcase 判断
            return head;
        }

        // 循环结束后，newHeadPre指向倒数第k个元素的前一个节点
        // 例如，1->2->3->4->5，k=2 时，newHeadPre 指向 3
        ListNode newHeadPre = pre;
        for (int i = 0; i < length-k; ++i) {
            newHeadPre = newHeadPre.next;
        }

        // 断开 newHead 与前面的链接
        ListNode newHead = newHeadPre.next;
        newHeadPre.next = null;

        // 两部分链表拼接
        tail.next = head;
        pre.next = newHead;

        return pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode ans = new Solution2().rotateRight(l1, 2);
        System.out.println(ans);
    }
}