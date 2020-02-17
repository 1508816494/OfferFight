package com.yyt;

    public class MianShi {
        public static void main(String[] args) {
            System.out.println("helloworld");
        }
        //选择排序
        public static void  selectSort(int[] arr) {
            for(int i = 0; i < arr.length; i++) {
                for(int j = i + 1; j < arr.length; j++) {
                    if(arr[j] < arr[i]) {
                        swap(arr, i, j);
                    }
                }
            }
        }

        //插入排序
        public static void insertSort(int[] arr) {
            for(int i = 1; i < arr.length; i++) {
                for(int j = i; j > 0; j--) {
                    if(arr[j] < arr[j-1]) {
                        swap(arr, j , j-1);
                    } else{
                        break;
                    }
                }
            }
        }

        //直接插入排序
        public static void insertSortSimp(int[] arr) {
            for(int i = 1; i < arr.length; i++) {
                for(int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                    swap(arr, j, j + 1);
                }
            }
        }

        //希尔排序
        public static void shellSort(int[] arr) {
            int len = arr.length;
            for(int gap = len/2; gap >= 1; gap = gap/2) {

                for(int i = gap; i < arr.length; i++) {
                    for(int j = i - gap; j >= 0 && arr[j] > arr[j + gap]; j = j - gap) {
                        swap(arr, j, j + gap);
                    }
                }
            }
        }

        //冒泡排序
        public static void bubbleSort(int[] arr) {
            int n = arr.length;
            //此处不能用变量n
            for(int i = 0; i < arr.length - 1; i++) {

                for(int j = 0; j < n - 1; j++) {
                    if(arr[j] > arr[j+1]) {
                        swap(arr, j, j+1);
                    }
                }
                n--;
            }
        }

        //快排
        public static void quickSort(int[] arr, int l, int r) {
            if(l >= r) {
                return;
            }
            int p = partition(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }

        private static int partition(int[] arr, int l, int r) {
            int seed = arr[l];
            //j指向小于seed的最后一个值
            int j = l;
            for(int i = l+1; i <= r; i++) {
                if(arr[i] < seed) {
                    swap(arr, i, j + 1);
                    j++;
                }
            }
            swap(arr, l, j);
            return j;
        }

        //桶排序
        public static void bucketSort(int[] arr) {
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < arr.length; i++) {
                max = Math.max(max, arr[i]);
            }

            int[] newArr = new int[max + 1];

            for(int i = 0; i < arr.length; i++) {
                newArr[arr[i]]++;
            }

            int index = 0;
            for(int i = 0; i < newArr.length; i++) {
                while(newArr[i]-- > 0) {
                    arr[index++] = i;
                }
            }
        }

        public static void swap(int[] list, int p, int q) {
            int temp = list[p];
            list[p] = list[q];
            list[q] = temp;
        }


    }
