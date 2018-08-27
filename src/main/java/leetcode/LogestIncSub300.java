package leetcode;

public class LogestIncSub300 {
    private int[] nums;
    private int[] memo;

    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        this.memo = new int[nums.length];
        this.nums = nums;

        for(int i = 0; i < nums.length; i++) {
            memo[i] = 1;
            tryFind(i);
        }
        int res = 1;
        for(int i = 0; i < memo.length; i++) {
            if(memo[i] > res ) {
                res = memo[i];
            }
        }
        return res;
    }
    //以nums[index]为结尾的最长子序列的长度
    private void tryFind(int index) {
        int max = 1;
        for(int i = 0; i < index; i++) {
            //最大值不一定是距离该值最近的nums[index]
            //当前值不仅满足小于index的值，还需要大于max
            if(nums[i] < nums[index] && memo[i] >= max) {
                memo[index] = memo[i] + 1;
            }

            if(memo[index] >= max) {
                max = memo[index];
            }
        }
    }

    public static void main(String[] args) {
        LogestIncSub300 lg = new LogestIncSub300();
        int[] arr = {10,9,2,5,3,4};
        System.out.println(lg.lengthOfLIS(arr));
    }
}
