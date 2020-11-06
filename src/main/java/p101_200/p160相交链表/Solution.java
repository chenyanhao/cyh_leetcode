package p101_200.p160相交链表;

/**
 * 创建两个指针 pA 和 pB，分别初始化为链表 A 和 B 的头结点。然后让它们向后逐结点遍历。
 * 当 pA 到达链表的尾部时，将它重定位到链表 B 的头结点；类似的，当 pB 到达链表的尾部时，将它重定位到链表 A 的头结点。
 * 若在某一时刻 pA 和 pB 相遇，则 pA/pB 为相交结点。
 *
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA != null ? pA.next : headB;
            pB = pB != null ? pB.next : headA;
        }
        return pA;
    }
}