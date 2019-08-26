package leetcode;

public class Rob {
    private int[] nums;
    private int[] memo;

    public int Rob(int[] nums) {
        this.nums = nums;
        memo = new int[nums.length];
        for(int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        return tryRob(0);
    }
    //考虑抢劫[index, nums.size]的房子
    private int tryRob(int index) {
        if(index >= nums.length) {
            return 0;
        }
        if(memo[index] != -1) {
            return memo[index];
        }
        int res = 0;
        for(int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + tryRob(i + 2));
        }
        memo[index] = res;
        return res;
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        int[] arr = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(rob.Rob(arr));
    }
}
