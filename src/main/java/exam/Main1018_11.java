package exam;

import java.util.Scanner;

public class Main1018_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();

            FibonacciCir(n);
        }
    }
    public static void FibonacciCir(int n) {
        int arr[] = {0,1};
        if(n < 2) {
            System.out.println(arr[n]);
        }

        //存f(n-1)和f(n-2)的参数
        int fibMinus1 = 1;
        int fibMinus2 = 0;
        //存当前计算值
        int result = 0;

        //从f(2)算到f(n)
        for(int i = 1; i <= n; i++) {
            result = fibMinus1 + fibMinus2;

            fibMinus2 = fibMinus1;
            fibMinus1 = result;
        }
        System.out.println(result);;
    }
}
