package leetcode;

public class RemoveDup {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int comIndex = 0;
        while (index < nums.length) {
            //从index的后一位开始比较
            comIndex = index + 1;
            //知道两者的值不等为值
            while (nums[comIndex] == nums[index]) {
                comIndex++;
            }
            int len = comIndex - index;
            if(len > 1) {
                moveElements(nums, comIndex, len - 1);
            }

        }
        for(Integer item : nums) {
            System.out.println(item);
        }
        return 0;
    }
    //定义move方法，表示从startIndex开始移动，每个元素移动len长度
    private void moveElements(int[] nums, int startIndex, int len) {
        for(int i = startIndex; i < nums.length; i++) {
            nums[i - len] = nums[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        RemoveDup re = new RemoveDup();
        re.removeDuplicates(nums);
    }
}
