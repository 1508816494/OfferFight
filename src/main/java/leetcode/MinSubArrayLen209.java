package leetcode;

public class MinSubArrayLen209 {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0;
        int r = -1;
        //[l, r]为滑动窗口
        int sum = 0;
        //初始化为不可能取到的值
        int res = nums.length + 1;

        while (l < nums.length) {
            //窗口内的和不够则移动r
            //需要保证r+1不越界
            if(r + 1 < nums.length && sum < s) {
                r++;
                sum += nums[r];
            } else {
                sum -= nums[l];
                l++;
            }

            if(sum >= s) {
                res = Math.min(res, r-l+1);
            }
        }

        if(res == nums.length + 1) {
            return 0;
        }else {
            return res;
        }
    }

    public static void main(String[] args) {
        MinSubArrayLen209 ms = new MinSubArrayLen209();
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(ms.minSubArrayLen(7, nums));
    }
}
