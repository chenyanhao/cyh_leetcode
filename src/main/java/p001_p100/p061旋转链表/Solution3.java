package p001_p100.p061旋转链表;

class Solution3 {

    /**
     * 思路：递归处理
     *
     * 考虑 rotate 一次的情况，例如，1->2->3->4->5，假设递归函数为 f，
     * f(2->3->4->5) = 5->2->3->4，再将头结点 1 插入到节点 5 和 2 之间即可
     *
     * 此种原版解法会超时，例如 1->2->3，k=200000，所以可以优化k来提高效率，即 k = k % length，见解法4
     *
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode pre = new ListNode(-1);
        pre.next = head;
        for (int i = 0; i < k; ++i) {
            pre.next = dfs(pre.next);
        }
        return pre.next;
    }

    private ListNode dfs(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode newHead = dfs(head.next);
        ListNode next = newHead.next;

        newHead.next = head;
        head.next = next;

        return newHead;
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

        ListNode ans = new Solution3().rotateRight(l1, 2);
        System.out.println(ans);
    }
}