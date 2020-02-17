package exam;

import java.util.Scanner;

public class Main0922_2 {
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            int sum = 0;

            for(int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            boolean allOposite = true;

            for(int i = 0; i < n; i++) {
                if(a[i] >= 0) {
                    allOposite = false;
                }
            }

            int sum1 = getMax(a, n);

            for(int i = 0; i < n; i++) {
                b[i] =- a[i];
                sum += a[i];
            }

            if(!allOposite) {
                int temp = getMax(b, n);
                int sum2 = sum + temp;

                max = Math.max(sum1, sum2);
                System.out.println(max);
            } else {
                System.out.println(sum1);
            }

        }
    }

    public static int getMax(int[] a, int n) {
        if(a == null) {
            return 0;
        }

        int sum = 0;
        int res = 0;

        for(int i = 0; i < n; i++) {
            sum += a[i];
            res = Math.max(res, sum);
            if(sum < 0) {
                sum = 0;
            }
        }
        return res;
    }
}
