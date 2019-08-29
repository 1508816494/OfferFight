package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        int[] res = new int[2];

        while (l < r) {
            if(numbers[l] + numbers[r] == target) {
                res[0] = l + 1;
                res[1] = r + 1;
                return res;
            } else if(numbers[l] + numbers[r] > target) {
                r--;
            } else  {
                l++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = 0;
        int target = 0;
        int[] nums;

        while (in.hasNext()) {
            size = in.nextInt();
            nums = new int[size];
            target = in.nextInt();

            for(int i = 0; i < size; i++) {
                nums[i] = in.nextInt();
            }

            TwoSum ts = new TwoSum();
            int[] res = ts.twoSum(nums, target);
            for(Integer item : res) {
                System.out.println(item);
            }
        }
    }
}
