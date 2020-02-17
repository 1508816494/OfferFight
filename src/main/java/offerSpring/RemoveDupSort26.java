package offerSpring;

public class RemoveDupSort26 {

    public static int removeDupSort(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[index] != nums[i]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index+1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(removeDupSort(nums));
    }
}
