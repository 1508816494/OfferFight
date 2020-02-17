package com.yyt;

import java.util.*;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    /**
     * 递归方式实现插入
     * @param data
     */
    public void insert(int data) {
        if(root == null) {
            root = new Node(data);
        }else{
            insert(root, data);
        }
    }

    /**
     * 向以node为根结点的树中插入值
     * 返回插入值之后的根
     * @param node
     * @param data
     * @return
     */
    private Node insert(Node node, int data) {
        //递归最终状态
        if(node == null) {
            return new Node(data);
        }
        if(data == node.data) {
            node.data = data;
        }
        if(data < node.data) {
            node.left = insert(node.left, data);
        }
        if(data > node.data) {
            node.right = insert(node.right, data);
        }
        return node;
    }

    /**
     * 非递归方式将一个值插入二叉搜索树 重复值不插入
     * @param data
     */
    public void insert1(int data) {
        Node newNode = new Node(data);
        if(root == null) {
            root = newNode;
        } else {
            Node current = root;
            //记录当前节点的父节点
            Node parent;
            while (true) {
                parent = current;
                if(data == current.data) {
                    return;
                } else if (data < current.data) {
                    //移动当前节点,若左子树存在，则确定将当前节点移到左孩子，继续循环判断大小
                    current = current.left;
                    if(current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if(current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * 查找方法，内部采用递归实现
     * @param data
     * @return
     */
    public boolean contain(int data) {
        return contain(root, data);
    }

    /**
     * 递归方法
     * @param node
     * @param data
     * @return
     */
    private boolean contain(Node node, int data) {
        //递归最终状态的处理,查到最后一个节点为空
        if(node == null) {
            return false;
        }
        if(data == node.data) {
            return true;
        } else if (data < node.data) {
            return contain(node.left, data);
        } else {
            return contain(node.right, data);
        }
    }

    public void  preOrder() {
        this.preOrder(root);
    }

    /**
     * 前序遍历的递归方式
     * @param node
     */
    private void preOrder(Node node) {
        if(node != null) {
            System.out.print(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder() {
        this.inOrder(root);
    }

    /**
     * 中序遍历的递归实现
     * @param node
     */
    public void inOrder(Node node) {
        if(node != null) {
            inOrder(node.left);
            System.out.print(node.data);
            inOrder(node.right);
        }
    }

    public void postOrder() {
        this.postOrder(root);
    }

    /**
     * 后序遍历的递归实现
     * @param node
     */
    public void postOrder(Node node) {
        if(node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data);
        }
    }

    /**
     * 利用队列实现层序遍历，将左右孩子分别入队
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while ( !queue.isEmpty() ) {
            Node node = queue.peek();
            queue.poll();
            System.out.print(node.data);
            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * 递归求二叉树的最大深度
     * @param node
     * @return
     */
        public static int findDeep(Node node)
        {
            if(node == null) {
                return 0;
            }

            int lchilddeep = findDeep(node.left);
            int rchilddeep = findDeep(node.right);
            return Math.max(lchilddeep, rchilddeep) + 1;
        }

        public static void main(String[] args) {
        BinarySearchTree test = new BinarySearchTree();
        test.insert1(3);
        test.insert1(8);
        test.insert1(5);
        test.insert1(11);
        test.insert1(7);
        test.insert1(5);

        System.out.println(test.root);
        System.out.println(findDeep(test.root));

//        System.out.println(test.contain(4));
//        System.out.println(test.root.toString());
//
//        test.preOrder();
//        System.out.println("====");
//        test.inOrder();
//        System.out.println("====");
//        test.postOrder();
//        System.out.println();
//        test.levelOrder();
    }
}
