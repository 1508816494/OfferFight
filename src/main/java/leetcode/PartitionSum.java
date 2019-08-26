package leetcode;

public class PartitionSum {
    private int[] nums;
    //定义为int，因为需要表示三种状态，-1未计算，0不满足，1满足
    private int[][] memo;

    public boolean canPartition(int[] nums) {
        this.nums = nums;
        int n = nums.length;

        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            assert (nums[i] >= 0);
            sum += nums[i];
        }
        if(sum % 2 != 0) {
            return  false;
        }

        memo = new int[n][sum/2 + 1];
        for(int i = 0; i < n; i++) {
            //注意此处存储sum的容量+1
            for(int j = 0;j < sum/2 + 1; j++) {
                memo[i][j] = -1;
            }
        }

        return tryPartition(n-1, sum/2);
    }

    //尝试使用[0, index]完全填满一个容量为sum的包
    private boolean tryPartition(int index, int sum) {
        //剩余容量为0,说明刚好填满
        if(sum == 0) {
            return true;
        }
        //没有数字可选或者剩余和不足都无法填满
        if(index < 0 || sum < 0) {
            return false;
        }

        if(memo[index][sum] != -1) {
            //注意此处将int转为boolean返回
            return memo[index][sum] == 1;
        }

        //将boolean转为int存入，三目运算
        memo[index][sum] = (tryPartition(index-1, sum) || tryPartition(index-1, sum - nums[index])) ? 1 : 0;
        return memo[index][sum] == 1;
    }

    public static void main(String[] args) {
        PartitionSum ps = new PartitionSum();
        int[] nums = {1, 5, 11, 5};
        System.out.println(ps.canPartition(nums));
    }
}
