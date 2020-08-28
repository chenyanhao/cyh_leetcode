package p101_200.p142环形链表2;

public class Solution {

    /**
     * 设入环前距离为【D】，慢指针入环后走过的距离为【S1】，环剩下距离为【S2】
     *
     * 首次相遇
     *  1.慢指针 S = D + S1
     *  2.快指针 F = D + n(S1 + S2) + S1 （其中n>=1,快指针起码走了一圈以上才可能相遇）
     *  3.又因为慢指针走一步，快指针走两步，所以 F = 2 * S
     *  4.代入1，2 可得 2(D + S1) = D + n(S1 + S2) + S1
     *  5.移项可得 D = (n-1)S1 + nS2 = (n-1)(S1 + S2) + S2
     *  6.其中 n 为快指针绕的圈数
     *      n=1 D = S2
     *      n=2 D = 一圈 + S2
     *      n=3 D = 两圈 + S2
     *      .....
     *      其实并不关心绕了多少圈，就知道 n 圈 + S2 就是入环点了
     *  7.人为构造碰撞机会，让某个指针重新出发，且快慢指针这次一次都只走一步，两指针碰撞的位置就是入环位置
     *
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }
}