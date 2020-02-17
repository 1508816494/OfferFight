package exam;

import java.util.Scanner;

public class Main0920_04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n = in.nextInt();
            int k = in.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            for (int j = 0; j < k; j++) {

                //min
                int min = Integer.MAX_VALUE;
                for (int m = 0; m < n; m++) {
                    if(arr[m] < min && arr[m] != 0) {
                        min = arr[m];
                    }
                }

                System.out.println(min);

                //-max
                for (int p = 0; p < n; p++) {
                    if(arr[p] == 0) {
                        continue;
                    }
                    arr[p] = arr[p] - min;
                }

            }
        }
    }
}
