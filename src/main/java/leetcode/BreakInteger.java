package leetcode;

public class BreakInteger {
    private int[] memo;

    public int integerBreak (int n) {
        if(n < 2) {
            return 0;
        }
        memo = new int[n+1];
        return breakInteger(n);
    }
    //将n分割至少两部分，可以获得的最大乘积
    private int breakInteger(int n) {
        //递归终止条件
        if(n == 1) {
            return 1;
        }
        if(memo[n] != 0) {
            return memo[n];
        }

        int res = -1;
        //可分割的范围为n到size-1
        for(int i = 1; i <= n-1; i++) {
            //三种分割情况
            res = Math.max(res, Math.max(i*(n-i), i*breakInteger(n-i)));
        }
        memo[n] = res;
        return res;
    }
    public static void main(String[] args) {
        BreakInteger br = new BreakInteger();
        System.out.println(br.integerBreak(10));
    }
}
