package offerSpring;

public class RemoveElement27 {
    public int removeElement(int[] nums, int val) {
//        int count = 0;
        int index = 0;
        //[0,index]存储非val值,count即为index的值
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                swap(nums, i, index);
                index++;
//                count++;
            }
        }
        return index;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
