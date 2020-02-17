package offerSpring;

public class RemoveDupSort80 {

    public static int removeDupSort80(int[] nums) {
        int count = 1;
        int index = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[index]) {
                index++;
                nums[index] = nums[i];
                count = 1;
            }else if(nums[i] == nums[index] && count != 2) {
                index++;
                nums[index] = nums[i];
                count++;
            }
        }

        return index+1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDupSort80(nums));
    }

}
