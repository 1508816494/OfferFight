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
     * 记忆化搜索
     */
    private static int[] mem;
    public static int FibnacciMem(int n) {
        if(n <= 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        //为默认值0,说明未计算过，则递归计算，非0则直接返回计算值
        if(mem[n] == 0) {
            mem[n] = FibnacciMem(n-1) + FibnacciMem(n-2);
        }
        return mem[n];
    }

    /**
     * 动态规划 自下而上解决
     */
    public static int Fib(int n) {
        mem[0] = 0;
        mem[1] = 1;
        for(int i = 2; i <= n; i++) {
            mem[i] = mem[i-1] + mem[i-2];
        }
        return mem[n];
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
        int n = 40;
        //注意此处数组的容量应该为n+1,因为存储着0-n的斐波那契值
        mem = new int[n+1];

        //也可用默认值0作为判空条件，因为0以后值都大于0
//        for(int i = 0; i < n+1; i++) {
//            mem[i] = -1;
//        }

        System.out.println(Fibonacci(n));
        System.out.println(FibonacciCir(n));
        System.out.println(FibnacciMem(n));
        System.out.println(Fib(n));
    }
}
