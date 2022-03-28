package p101_200.p160相交链表;

/**
 * 创建两个指针 pA 和 pB，分别初始化为链表 A 和 B 的头结点。然后让它们向后逐结点遍历。
 * 当 pA 到达链表的尾部时，将它重定位到链表 B 的头结点；类似的，当 pB 到达链表的尾部时，将它重定位到链表 A 的头结点。
 * 若在某一时刻 pA 和 pB 相遇，则 pA/pB 为相交结点。
 *
 * 用这种交叠的方式消除两个链表的长度差。若链表 A 和 B 不想交，则最终 pA == pB == null，也会退出 while 循环。
 *
 * 举例来理解的话，
 * pA: 1->2->3->4->5->6->null->9->5->6->null
 * pB: 9->5->6->null->1->2->3->4->5->6->null
 *
 * pA走过的路径为 A链+B链，pB走过的路径为B链+A链。
 * 如果相交，则会提前在相交点相遇。如果没有相交点，则会在最后null处相遇。
 *
 * 所以时间复杂度也就好分析了，就是 O(m+n)
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