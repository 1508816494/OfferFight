package offer;

public class Fibonacci {
    /**
     * 斐波那契数列的递归实现
     * @param n
     * @return
     */
    public static int Fibonacci(int n) {
        if(n <= 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    /**
     * 斐波那契数列的非递归循环实现
     * @param n
     * @return
     */
    public static int FibonacciCir(int n) {
        int arr[] = {0,1};
        if(n < 2) {
            return arr[n];
        }

        //存f(n-1)和f(n-2)的参数
        int fibMinus1 = 1;
        int fibMinus2 = 0;
        //存当前计算值
        int result = 0;

        //从f(2)算到f(n)
        for(int i = 2; i <= n; i++) {
            result = fibMinus1 + fibMinus2;

            fibMinus2 = fibMinus1;
            fibMinus1 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(2));
        System.out.println(FibonacciCir(2));
    }
}
