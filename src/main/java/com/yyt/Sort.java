package com.yyt;

import java.util.List;

public class Sort {
    /**
     * 本类不允许产生任何实例
     */
    private Sort() {

    }

    /**
     * selectSort   每次循环寻找最值，依次放置到前面
     * @param mylist
     */
    public static void selectSort(int[] mylist) {
        for(int i = 0; i < mylist.length; i++) {
            for(int j = i; j < mylist.length; j++) {
                if(mylist[i] > mylist[j]) {
                    swap(mylist, i, j);
                }
            }
        }

    }

    /**
     * insertSort 将第二位以后的值依次跟前面的值比较，顺序不对则交换
     * @param mylist
     */
    public static void insertSort(int[] mylist) {
        for(int i = 1; i < mylist.length; i++) {
            for(int j = i; j > 0; j--) {
                if(mylist[j] < mylist[j-1]) {
                    swap(mylist, j, j-1);
                }
                else {
                    break;
                }
            }

        }
    }

    public static void optInsertSort(int[] mylist) {
        for(int i = 1; i < mylist.length; i++) {
            int copy = mylist[i];
            //j 存储正确位置的索引 将当前值依次与前面值相比较，前值大于插入值，则说明该值非正确位置，后移，若前值小于插入值，则插入该位置
            int j;
            for(j = i; j > 0 && mylist[j-1] > copy; j--) {
                mylist[j] = mylist[j-1];
            }
            mylist[j] = copy;
        }
    }

    /**
     * 希尔排序
     */
    public static void shellSort(int[] arr) {
        int len = arr.length;
        for(int gap = len/2; gap >= 1; gap = gap/2) {


            for(int i = gap; i < len; i++) {
                for(int j = i - gap; j >= 0 && arr[j] > arr[j + gap]; j = j - gap) {
                    swap(arr, j, j + gap);
                }
            }
        }
    }

    /**
     * 直接插入排序
     */
    public static void insertSort1(int[] arr) {
        for(int i = 1; i < arr.length; i++) {

            for(int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j+1);
            }
        }
    }

    /**
     * 桶排序
     */
    public static void buckedSort(int[] arr) {
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        int[] bucked = new int[max + 1];

        for(int i = 0; i < arr.length; i++) {
            bucked[arr[i]]++;
        }

        int k = 0;
        for(int j = 0; j < bucked.length; j++) {
            while (bucked[j]-- > 0) {
                arr[k++] = j;
            }
        }
    }

    /**
     * 归并排序 自顶向下使用递归，将左右部分拷贝后按大小逐个放入数组中
     * 优化1： merge前先判断一下目前的左右是否已经有序，适用于几乎有序的数组
     * 优化2：小数组时使用插入排序
     * @param mylist
     * @param l
     * @param r
     */
    public static void mergeSort(int[] mylist, int l, int r) {
        if(l >= r) {
            return;
        }
        //mid 中间位置索引
        int mid = (l + r)/2;
        mergeSort(mylist, l, mid);
        mergeSort(mylist, mid + 1, r);
        merge(mylist, l, mid, r);

    }

    public static void merge(int[] list, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        int i, j, k;

        //将list中该次左右部分分别拷贝
        for(i = 0,k = l; i < n1; i++, k++) {
            left[i] = list[k];
        }
        for(j = 0,k = mid + 1; j < n2; j++, k++) {
            right[j] = list[k];
        }

        //比较左右大小重新放置，此时满足左右边都有数
        for(k = l, i = 0, j = 0; i < n1 && j < n2;  k++) {
            if(left[i] < right[j]) {
                list[k] = left[i];
                i++;
            }else {
                list[k] = right[j];
                j++;
            }
        }

        //若跳出上述循环后,i仍然未排完，说明左边有剩余，右边无
        if(i < n1) {
            for(j = i; j < n1; j++, k++) {
                list[k] = left[j];
            }
        }
        if(j < n2) {
            for(i = j; i < n2; i++, k++) {
                list[k] = right[i];
            }
        }

    }

    /**
     * 快速排序 递归运行，每次选取第1个值为标准，将数组按照此值分为左边<seed，右边>seed，递归运行，直至每个排完。
     * @param mylist
     * @param l
     * @param r
     */
    public static void quickSort(int[] mylist, int l, int r) {
//        if(l >= r) {
//            return;
//        }
        //优化1：数量较小时采用插入排序
        if(r - l <= 15) {
            insertSort(mylist);
            return;
        }
//        int p = partition(mylist, l, r);
//        quickSort(mylist, l, p-1);
//        quickSort(mylist, p+1, r);

        int p = partitionOpt(mylist, l, r);
        quickSort(mylist, l, p-1);
        quickSort(mylist, p+1, r);
    }

    /**partition操作需要满足 l指向seed值，j指向<seed的最后值，i指向当前判断值
     * list[l+1,……,j]<seed
     * list[j+1,……,i)>seed
     * 维护指针的范围，j的初值为l,i的初值l+1 此时区间1为[l+1,……,l]不存在,区间2为[l+1,……,l+1)不存在
     *
     * @param list
     * @param l
     * @param r
     * @return p 返回p,使得list[l, p-1]<list[p], list[p+1, r]>list[p]
     */
    public static int partition(int[] list, int l, int r) {
//        int seed = list[l];
        //优化选取的值，不采用第一个，随机选取一个，数学期望为nlogn
        int index = (int)Math.random()*(r - l) + l;
        int seed = list[index];
        swap(list, l, index);

        int j = l;
        //此处i的初始值不能为l+2,虽然第二个值排序不动，但是指针j会+1，完成后面的swap(list[j], list[l]）
        for(int i = l + 1; i <= r; i++) {
            if(list[i] < seed) {
                swap(list, i, j+1);
                j++;
            }
        }
        swap(list, l, j);
        return j;
    }

    /** 双路快排 （能够避免大量重复值时不平衡的问题）
     * list[l+1,……,i) <= seed
     * list(j,……,r] >= seed
     * @param list
     * @param l
     * @param r
     * @return p 返回p,使得list[l, p-1]<list[p], list[p+1, r]>list[p]
     */
    public static int partitionOpt(int[] list, int l, int r) {
        int index = (int)Math.random()*(r - l) + l;
        int seed = list[index];
        swap(list, l, index);

        int i = l + 1;
        int j = r;

        while (i < j) {
            while (list[i] < seed) {
                i++;
            }
            while (list[j] > seed) {
                j++;
            }
            swap(list, i, j);
            i++;
            j++;
        }
        //循环结束时，i停在第一个>= seed的位置，j停在最后一个 <= seed的位置
        //要求返回的p属于最后一个<= seed的位置，所以将首位与j交换
        int temp = list[l];
        list[l] = list[j];
        list[j] = temp;
        return j;
    }

    /**
     * 三路快排
     * 将list[l,r]分为< seed, ==seed , >seed三个部分
     * 对 < seed 和 > seed两部分进行递归
     * @param mylist
     * @param l
     * @param r
     */
    public static void quickSort3Ways(int[] mylist, int l, int r) {
        if(r - l <= 15) {
            insertSort(mylist);
            return;
        }

        //partition
        int index = (int)Math.random()*(r - l) + l;
        int seed = mylist[index];

        int lt = l; // list[l+1,……,lt] < seed 保证初值为空
        int gt = r + 1; //list[gt,……,r] > seed
        int i = l + 1; //list[lt+1,……,i-1] == seed

        while (i < gt) {
            if(mylist[i] < seed) {
                swap(mylist, i, lt+1);
                lt++;
                i++;
            }else if(mylist[i] > seed) {
                swap(mylist, i, gt-1);
                gt--;
            }else {
                //mylist[i] == seed
                i++;
            }
        }
        swap(mylist, l, lt);
        //lt位置为==seed的值，所以左边范围为lt-1
        quickSort3Ways(mylist, l, lt-1);
        quickSort3Ways(mylist, gt, r);

    }

    /**
     * 堆排序 将数据组织成堆结构，依次取出最大或最小的那个数，即为排序过程
     * @param mylist
     * @param l
     * @param r
     */
    public static void heapSort(int[] mylist, int l, int r) {
        //使用heapify优化，传入一个数组，将数组转成堆O(n)，将数据插入空堆中O(nlogn)
        MaxHeap myheap = new MaxHeap(mylist);
//        for(int a: mylist) {
//            myheap.insert(a);
//        }
        for(int i = mylist.length - 1; i >= 0; i--) {
            mylist[i] = myheap.extractMax();
        }
    }

    /**
     * 原地堆排序 上述堆排序需要开辟额外的存储空间，本方法实现原数组上的堆排序
     * 由于heapify操作可以将数组变成堆，因此可以在数组上进行操作
     * @param mylist
     * @param l
     * @param r
     */
    public static void heapSortOpt(int[] mylist, int l, int r) {
        //heapify操作，将原数组变成堆,即首位存储最大值
        //由于在原数组上操作，所以堆的索引的开始值从0开始，各索引值如下：
        // parent(i) = (i - 1)/2  left child(i) = 2 * i + 1  right child(i) = 2 * i + 2  最后一个非叶子节点 (count - 1)/2
        for(int i = (mylist.length -1)/2; i >=0; i--) {
            shiftDown(mylist, mylist.length, i);
        }

        //利用堆进行原地排序 不断将首位的最大值与最后位逐个交换位置，交换之后首位不满足最大堆，则对首位进行shiftdown操作
        for(int i = (mylist.length - 1); i > 0; i--) {
            swap(mylist, i, 0);
            //每次交换之后，需要shiftdown的数组的长度 - 1
            shiftDown(mylist, i, 0);
        }

    }

    private static void shiftDown(int[] mylist, int num, int index) {
        //保证左孩子节点不越界
        while ((2*index + 1) < num - 1) {
            //默认与左孩子交换
            int j = 2*index + 1;
            //右孩子索引不越界 且 右孩子值大于左
            if((j + 1) < (num - 1) && mylist[j+1] > mylist[j]) {
                j = j + 1;
            }
            //如果父节点的值大于两个字节点，则退出
            if(mylist[index] > mylist[j]) {
                break;
            }
            swap(mylist, index, j);
            index = j;
        }
    }

    /**
     * 冒泡排序 每次遍历交换一次，会将此时的最大值冒到最后
     * @param mylist
     * @param l
     * @param r
     */
    public static void bubbleSort(int[] mylist, int l, int r) {
        int n = mylist.length;
        //i决定循环次数
        for(int i = 0; i < (mylist.length - 1); i++) {
            //j决定每次遍历范围 j+1注意范围
            for(int j = 0; j < n - 1; j++) {
                if(mylist[j] > mylist[j+1]) {
                    swap(mylist, j, j+1);
                }
            }
            n--;
        }
    }

    public static void swap(int[] list, int p, int q) {
        int temp = list[p];
        list[p] = list[q];
        list[q] = temp;
    }



    public static void main(String[] args) {
        int[] arr  = {5, 4, 2, 9, 8, 6, 7, 6, 0, 1, 3, 3, 2};
        for(int a : arr) {
            System.out.print(a);
        }
        System.out.println();
        insertSort(arr);
        for(int a : arr) {
            System.out.print(a);
        }
    }
}
