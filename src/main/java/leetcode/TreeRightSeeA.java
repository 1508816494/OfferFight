package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeRightSeeA {
    public static List<Integer> rightSideView2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        //存储当前层的最后一个节点
        TreeNode levelLastNode = root;
        //入队的最后一个节点
        TreeNode lastNode = null;

        if(root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            if(currentNode.left != null) {
                queue.offer(currentNode.left);
                lastNode = currentNode.left;
            }
            if(currentNode.right != null) {
                queue.offer((currentNode.left));
                lastNode = currentNode.right;
            }
            if(currentNode == levelLastNode) {
                list.add(currentNode.val);
                levelLastNode = lastNode;
            }
        }
        return list;
    }
}
