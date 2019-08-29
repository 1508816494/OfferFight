package leetcode;

public class SortColors75 {
    public void sortColors(int[] nums) {
        //[0, zero]的值都为0
        int zero = -1;
        //[two, length-1]的值都为2
        int two = nums.length;

        //i的位置到two索引的前一位
        for(int i = 0; i < two; ) {
            if(nums[i] == 1) {
                i++;
            } else if(nums[i] == 2) {
                //交换后此时的i位置的值不确定，需要继续判断，不能++
                two--;
                swap(nums, two, i);
            } else {
                assert (nums[i] == 0);
                zero++;
                swap(nums, zero, i);
                i++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
