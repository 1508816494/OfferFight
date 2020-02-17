package exam;

import java.util.Scanner;

public class Main0920_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        while (in.hasNext()) {
            int n = in.nextInt();

            int[] arr = new int[n];

            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
            }

            insertSort(arr);

            int left = 0;
            int right = 0;

            int l = 0;
            int r = arr.length - 1;

            while (l < r) {
                if((l + 1) != r ) {
                    left = left + arr[l++] + arr[r--];
                    right = right + arr[l++] + arr[r--];
                } else {
                    left = left + arr[l];
                    right = right + arr[l+1];
                    l++;
                }
            }
            if(left < right) {
                System.out.print(left);
                System.out.print(" ");
                System.out.print(right);
                System.out.println();
            } else {
                System.out.print(right);
                System.out.print(" ");
                System.out.print(left);
            }

        }

    }

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

    public static void swap(int[] list, int p, int q) {
        int temp = list[p];
        list[p] = list[q];
        list[q] = temp;
    }
}
