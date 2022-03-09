package p001_p100.p061旋转链表;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.val);

        ListNode p = this.next;
        while (p != null) {
            sb.append(" -> ");
            sb.append(p.val);
            p = p.next;
        }
        return sb.toString();
    }
}
