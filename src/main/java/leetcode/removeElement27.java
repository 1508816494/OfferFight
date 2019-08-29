package leetcode;

public class removeElement27 {
    //删除数组中值为val的值（可将val的值放到末尾）
    public int removeElement(int[] nums, int val) {
        int valIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                swap(nums, valIndex, i);
                valIndex++;
            }
        }
        return valIndex;
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
