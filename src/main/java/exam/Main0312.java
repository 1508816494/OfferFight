package exam;

import java.util.Scanner;

public class Main0312 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        while (scanner.hasNext()) {
//            int len = scanner.nextInt();
//            int x = scanner.nextInt();

            int len = 5;
            int x = 2;
            int[] test = {3,1,3,2,5};

            //存储最大值
            int max = 0;
            int maxIndex = 0;

            //存储每个元素出现的次数
            int[] arr = new int[100000];

            for(int i = 0; i < len; i++) {
//                int val = scanner.nextInt();
                int val = test[i];
                arr[val]++;

                if(arr[val] > max) {
                    max = arr[val];
                    maxIndex = val;
                }
//                max = Math.max(max, arr[val]);
            }


            //其他数操作
            for(int i = 0; i < arr.length; i++) {
                int[] arrtemp = new int[100000];
                for(int j = 0; j < arr.length; j++) {
                    arrtemp[j] = arr[j];
                }

                if(arrtemp[i] == 0) {
                    continue;
                }

                int temp = i | x;
                if(temp != arrtemp[i]) {
                    arrtemp[temp]++;
                }
                if(arrtemp[temp] > max) {
                    max = arrtemp[temp];
                    maxIndex = temp;
                }
            }

            System.out.println(maxIndex);
//            //当前的众数按位与
//            int change = maxIndex | x;
//            if(change != maxIndex) {
//                for(int j = 0; j < max; j++) {
//                    arr[change]++;
//                }
//            }
//
//            if(arr[change] > max) {
//                System.out.println(arr[change]);
//            } else {
//                System.out.println(max);
//            }
        }
//    }
}
