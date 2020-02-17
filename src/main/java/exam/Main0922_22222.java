package exam;

import java.util.Scanner;

public class Main0922_22222 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max;
        int max1 = 0;
        int len = scanner.nextInt();
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] arr1 = new int[len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                arr1[j] = arr[(j + i) % len];
            }

            max = findMaxArr(arr1);

            if(max > max1) {
                max1 = max;
            }
        }

        System.out.println(max1);
    }

    private static int findMaxArr(int[] arr) {
        int Arr = 0;
        int maxArr = 0;
        int A = arr.length;
        int l1 = 0;
        int l2 = 0;
        int i;
        for (int i1 = 0; i1 < A; i1++) {
            Arr += arr[i1];
            if(Arr < 0) {
                Arr = 0;
            }

            if(Arr > maxArr) {
                maxArr = Arr;
                l2 = i1;
            }
        }

        for(i = l2; i >= 0; i--) {
            if(maxArr - arr[i] == 0) {
                l1 = i;
                break;
            }
        }
        if(maxArr == 0) {
            for(i = 0; i < A; i++) {
                if(i == 0) {
                    maxArr = arr[i];
                }
                if(arr[i] > maxArr) {
                    maxArr = arr[i];
                }
            }
        }
        return maxArr;
    }
}

