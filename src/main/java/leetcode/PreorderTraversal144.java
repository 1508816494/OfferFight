package leetcode;

import java.util.*;
import javafx.util.Pair;

public class PreorderTraversal144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack();
        boolean isAdd = false;
        if(root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
             //取出栈顶元素
            TreeNode node = stack.peek();
            stack.pop();
            if(isAdd) {
                list.add(node.val);
            }else {
                if(node.right != null) {
                    stack.push(node.right);
                }
                if(node.left != null) {
                    stack.push(node.left);
                }
                stack.push(node);
            }
            isAdd = !isAdd;
        }
        return list;

    }
}
