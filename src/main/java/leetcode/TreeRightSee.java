package leetcode;

import javafx.util.Pair;

import java.util.*;

public class TreeRightSee {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;

//        List<Integer> list = rightSideView(node1);
        List<Integer> list2 = TreeRightSeeA.rightSideView2(node1);
        for(Integer i: list2) {
            System.out.println(i);
        }

    }
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int lastLevel = 0;

        if(root == null) {
            return list;
        }

        //存储节点对信息
        Pair<TreeNode, Integer> pair = new Pair(root, 0);
        //入队根结点,记录层次
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(pair);

        while(!queue.isEmpty()) {
            Pair currentPair = queue.peek();
            int level = (int)currentPair.getValue();

            TreeNode node = (TreeNode)currentPair.getKey();
            queue.poll();

            if(level > lastLevel || level == 0) {
                list.add(node.val);
                lastLevel = level;
            }

            if(node.right != null) {
                queue.offer(new Pair(node.right, level+1));
            }
            if(node.left != null) {
                queue.offer(new Pair(node.left, level+1));
            }
        }

        return list;
    }
}
