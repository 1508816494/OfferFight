package leetcode;

import java.util.PriorityQueue;

public class FindKthLargest {
    /**
     * 快速选择法
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        return quickSelect(nums, l, r, k);
    }

    public static int quickSelect(int[] list, int l, int r, int k) {
        int index = partition(list, l, r);
        int rank = list.length - index;
        if(rank == k) {
            return list[index];
            //名次值较小，到左边找
        }else if(rank < k) {
            return quickSelect(list, l, index - 1, k);
            //名次值较大，到右边找
        } else {
            return quickSelect(list, index + 1, r, k);
        }
    }


    public static int partition(int[] list, int l, int r) {
        int index = (int)Math.random()*(r - l) + l;
        int seed = list[index];
        swap(list, l, index);

        int j = l;
        for(int i = l + 1; i <= r; i++) {
            if(list[i] < seed) {
                swap(list, i, j+1);
                j++;
            }
        }
        swap(list, l, j);
        return j;
    }

    public static void swap(int[] list, int p, int q) {
        int temp = list[p];
        list[p] = list[q];
        list[q] = temp;
    }

    /**
     * 小顶堆法
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2)->n1 - n2);
        for(int n : nums) {
            heap.add(n);
            if(heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }


    public static void main(String[] args) {
        int[] nums = {5,3,1,7,9,4};
        System.out.println(FindKthLargest.findKthLargest2(nums, 5));

    }
}
