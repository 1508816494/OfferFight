package leetcode;

public class DeleteNode237 {
    public void deleteNode(ListNode node) {
        //只传入要删除的结点，无法拿到该结点的前驱结点
        //考虑改变结点的值

        if(node == null) {
            return;
        }

        if(node.next == null) {
            node = null;
            return;
        }

        //将后一个赋值给要删除的结点，然后删除后一个结点
        node.val = node.next.val;
        node.next = node.next.next;

        return;
    }
}
