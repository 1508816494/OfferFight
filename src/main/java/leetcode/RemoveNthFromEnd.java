package leetcode;

public class RemoveNthFromEnd {

    //解法1，一次遍历获得长度，二次遍历删除其正数位置值
    public static ListNode removeNthFromEnd1 (ListNode head, int n) {
        if(head == null) {
            return null;
        }

        int count = 0;
        ListNode p = head;
        while (p != null) {
            count++;
            p = p.next;
        }

        int index = count - n + 1;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        ListNode cur = pre.next;

        while (cur != null && index > 1) {
            pre = pre.next;
            cur = cur.next;
            index--;
        }

        //delete
        pre.next = cur.next;
        return dummyHead.next;
    }

    //解法2：只遍历一遍，通过删除结点与尾结点之间的固定长度，找到删除结点的前驱结点
    public static ListNode removeNthFromEnd2 (ListNode head, int n) {
        if(head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        ListNode q = dummyHead;

        //使q指针与p指针保持n+1的距离
        for(int i = 0; i < n + 1; i++) {
            q = q.next;
        }

        //同步移动直到q为null，p即为要删除结点的前驱结点
        while (q != null) {
            q = q.next;
            p = p.next;
        }

        p.next = p.next.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        removeNthFromEnd1(node1, 2);
    }
}
