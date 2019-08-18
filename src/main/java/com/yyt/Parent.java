package com.yyt;

import java.util.*;

public class Parent implements ParentInterface{
    List<Node> list = new ArrayList();
    NavigableSet set = new TreeSet(Comparator.comparing(Node::getData)); //Comparator.comparing静态方法，传入类名和方法名，返回一个比较器
    Node[] arr = list.toArray(new Node[0]);

    List linkedlist = new LinkedList();

    ArrayDeque arrayDeque = new ArrayDeque();

    SortedMap sortedMap = Collections.synchronizedSortedMap(new TreeMap<>());
    Map map = new HashMap();
    PriorityQueue priorityQueue = new PriorityQueue();



    public void test() {
        list.add(null); //ArrayList可以放入null
        linkedlist.add(null);//Linkedlist可放入null
        pp();

    }



    @Override
    public void pp() {

    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Parent parent = Parent.class.newInstance();
        parent.test();
    }
}
