package leetcode;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class ReverseList206 {
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;

        while ( cur != null ) {
            //反转(当前指针反转)
            cur.next = pre;

            //维护其他指针(顺序移动pre,cur)
            pre = cur;
            //此处不能用pre.next，因为此时pre.next已经指向前一个
            cur = next;
            if( cur != null) {
                next = cur.next;
            }
        }
        return pre;
    }

    //构建链表
    public ListNode createLinkedList( int[] arr ) {
        int len = arr.length;
        if(len == 0) {
            return  null;
        }

        //头节点需要单独保留
        ListNode head = new ListNode(arr[0]);
        ListNode curNode = head;
        for( int i = 1; i < len; i++ ) {
            curNode.next = new ListNode( arr[i]);
            curNode = curNode.next;
        }
        return head;
    }

    //打印链表
    public void printLinkedList( ListNode head ) {
        if( head == null ) {
            System.out.println("null");
        } else {
            ListNode curNode = head;
            while ( curNode != null ) {
                System.out.print(curNode.val);
                System.out.print("->");
                curNode = curNode.next;
            }
            System.out.println("null");
        }
    }

    ArrayList<Integer> arrayList = new ArrayList<>();
    //反转
    public ArrayList<Integer> print(ListNode listNode) {
        if(listNode != null) {
            print(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }


    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        ReverseList206 rs = new ReverseList206();
        ListNode node = rs.createLinkedList(arr);
//        rs.printLinkedList(node);
//        node = rs.reverseList(node);
//        rs.printLinkedList(node);

        System.out.println(rs.print(node).toString());
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
    ListNode() {

    }
}