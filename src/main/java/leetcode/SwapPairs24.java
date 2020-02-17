package leetcode;

public class SwapPairs24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return null;
        }

        if(head.next == null) {
            return head;
        }

        //构建一个虚拟结点
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        //p为要移动结点的前一个结点
        ListNode p = dummyHead;

        while (p.next != null && p.next.next != null) {
            //保留各个指针
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            //swap
            node2.next = node1;
            node1.next = next;
            p.next = node2;

            p = node1;
        }
        return dummyHead.next;
    }
}
