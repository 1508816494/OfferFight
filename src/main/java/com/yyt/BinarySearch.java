package com.yyt;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length-1; //在[l,r]内寻找target，时刻维护l和r的含义

        while (l <= r) {
            int mid = (l + r)/2; //整型溢出问题，避免使用加法
//          int mid = l + (r - l)/2;
            if(target == arr[mid]) {
                return mid;
            }
            if(target < arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,5,6,7,9,11};
        System.out.println(binarySearch(arr, 10));
    }
}
