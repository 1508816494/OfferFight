package offerSpring;

public class SortColors75 {
    //计数排序
    public static void sortColors1(int[] nums) {
        int[] arr = {0, 0, 0};
        //计数
        for(int i = 0; i < nums.length; i++) {
            assert (nums[i] >=1 && nums[i] <= 2);
            arr[nums[i]]++;
        }

        //赋值

        //最外层表示排序索引，外层循环表示进行三次赋值，内层循环表示每次具体的赋值
        for(int i = 0; i < nums.length; ) {
            for(int j = 0; j < arr.length;j++) {
                for(int k = 0; k < arr[j]; k++) {
                    nums[i] = j;
                    i++;
                }
            }
        }

    }

    //三路快排
    public static void sortColors2(int[] nums) {
        int zero = -1; // nums[0,zero] == 0
        int two = nums.length; // nums[two, n-1] == 2

        for(int i = 0; i < two; ) {
            if(nums[i] == 1) {
                i++;
            } else if(nums[i] == 0) {
                zero++;
                swap(nums, zero, i);
                i++;
            } else {
                two--;
                swap(nums, i, two);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors2(nums);
    }
}
