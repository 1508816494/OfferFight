package leetcode;

public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if( l1 != null && l2 != null ) {
            ListNode cur1 = l1;
            ListNode cur2 = l2;
            ListNode res = new ListNode(0);
            int odd = 0;
            ListNode resCur;

            //单独处理头节点
            if( cur1.val + cur2.val < 10 ) {
                res.val = cur1.val + cur2.val;
            } else {
                res.val = cur1.val + cur2.val - 10;
                odd = 1;
            }
            if(cur1.next != null || cur2.next != null || odd != 0) {
                if(cur1.next != null) {
                    cur1 = cur1.next;
                }
                if(cur2.next != null) {
                    cur2 = cur2.next;
                }
                res.next = new ListNode(0);
                //当前结点
                resCur = res.next;
            } else {
                return res;
            }

            while ( cur1 != null || cur2 != null || odd != 0) {
                int val1 = 0;
                int val2 = 0;
                if(cur1 != null) {
                    //取值
                    val1 = cur1.val;
                    //移动
                    cur1 = cur1.next;
                }
                if(cur2 != null) {
                    val2 = cur2.val;
                    cur2 = cur2.next;
                }
                if(val1 + val2 + odd < 10) {
                    resCur.val = val1 + val2 + odd;
                    odd = 0;
                } else {
                    resCur.val = val1 + val2 + odd - 10;
                    odd = 1;
                }

                if(cur1!= null || cur2 != null) {
                    resCur.next = new ListNode(0);
                    resCur = resCur.next;
                }
            }
            return res;
        } else if( l1 != null && l2 == null) {
            return l1;
        } else if ( l1 == null && l2 != null) {
            return  l2;
        } else {
            return null;
        }

    }
}
