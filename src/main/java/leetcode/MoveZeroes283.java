package leetcode;

public class MoveZeroes283 {
    public void moveZeroes(int[] nums) {
        //维持在nums中[0……k)的元素都非零值
        int zeroIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                //如果用例中无零值，则每个元素都会跟自身交换一遍
                if(zeroIndex != i) {
                    swap(nums, zeroIndex, i);
                }
                zeroIndex++;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print("");
        }
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        MoveZeroes283 mz = new MoveZeroes283();
        mz.moveZeroes(nums);
    }
}
