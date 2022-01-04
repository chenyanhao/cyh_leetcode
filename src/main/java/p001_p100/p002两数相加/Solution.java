package p001_p100.p002两数相加;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode();
        ListNode cur = pre;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(sum);
            cur.next = node;

            cur = cur.next;
            l1 = (l1 != null ? l1.next : l1);
            l2 = (l2 != null ? l2.next : l2);
        }

        if (carry > 0) {
            ListNode node = new ListNode(carry);
            cur.next = node;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(9);
        ListNode l7 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        ListNode l8 = new ListNode(9);
        ListNode l9 = new ListNode(9);
        ListNode l10 = new ListNode(9);
        ListNode l11 = new ListNode(9);
        l8.next = l9;
        l9.next = l10;
        l10.next = l11;

        ListNode ans = new Solution().addTwoNumbers(l1, l8);
        System.out.println(ans);
    }
}