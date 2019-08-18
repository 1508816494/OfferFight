package com.yyt;

import java.util.ArrayList;
import java.util.List;

import static sun.swing.MenuItemLayoutHelper.max;

public class MaxHeap {
    private List<Integer> list;
    private int index = 0;

    MaxHeap() {
        this.list = new ArrayList<Integer>();
        this.list.add(0);
    }

    MaxHeap(int[] arr) {
        this.list = new ArrayList<Integer>();
        list.add(0);
        for (int anArr : arr) {
            list.add(anArr);
        }
        heapify(list);
    }

    private void heapify(List list) {
        for(int i = list.size()/2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    public void insert(int item) {
        list.add(item);
        index++;
        shiftUp(index);
    }
    private void shiftUp(int index) {
        //此处要求index > 1使得该值处在根结点时（index = 1）退出循环，忽略index = 0
        while (list.get(index/2) < list.get(index) && index > 1) {
            swap(index, index/2);
            index = index/2;
         }
    }
    public int extractMax() {
        int topValue = list.get(1);
        list.set(1, list.get(list.size()-1));
        list.remove(list.size() - 1);
        shiftDown(1);
        return topValue;
    }
    private void shiftDown(int index) {
        //循环处在最后一个节点的时候退出，因为该节点必然没有孩子节点
        while (2*index < list.size() - 1) {
            //默认与左孩子交换
            int j = 2*index;
            if(list.get(j + 1) != null && list.get(j+1) > list.get(j)) {
                j = j + 1;
            }
            //如果父节点的值大于两个字节点，则退出
            if(list.get(index) > list.get(j)) {
                break;
            }
            swap(index, j);
            index = j;
        }
    }
    private void swap(int i, int j) {
        int temp = this.list.get(i);
        this.list.set(i, this.list.get(j));
        this.list.set(j, temp);

    }
    public void printList() {
        System.out.println();
        for(int i = 1; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }
}
