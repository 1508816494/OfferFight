package leetcode;

import java.math.BigDecimal;

public class BigValue {
    private int[] weight;
    private int[] value;

    private int[][] memo;

    //考虑将[0, index]的物品填充容量为cap的背包
    public int tryBigValue(int index, int cap) {
        //终止条件
        if(index < 0 || cap <= 0) {
            return 0;
        }
        //记忆化搜索
        if(memo[index][cap] != -1) {
            return memo[index][cap];
        }
        //不放入该index下的物品
        int res = tryBigValue(index-1, cap);
        //放入该物品,前提保证得能放得下
        if(cap >= weight[index]) {
            res = Math.max(res, value[index] + tryBigValue(index-1, cap - weight[index]));
        }
        memo[index][cap] = res;
        return res;
    }
    public int bigValue(int[] weight, int[] value, int initCap) {
        this.weight = weight;
        this.value = value;
        int num = weight.length;
        //数量为num，容量数组大小为initCap+1（包含0）
        memo = new int[num][initCap + 1];
        for(int i = 0; i < num; i++) {
            for(int j = 0; j < initCap+1; j++) {
                memo[i][j] = -1;
            }
        }
        return tryBigValue(num-1, initCap);
    }

    public static void main(String[] args) {
        BigValue bg = new BigValue();
        int[] weight = {1, 2, 3};
        int[] value = {6, 10, 12};
        System.out.println(bg.bigValue(weight, value, 5));
    }
}
