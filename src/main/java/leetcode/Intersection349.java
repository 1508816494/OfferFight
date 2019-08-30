package leetcode;

import java.util.*;

public class Intersection349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet();
        Set<Integer> res = new HashSet<>();

        for(int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for(int j = 0; j < nums2.length; j++) {
            //采用set接收，可多次加入公共的数据
            if(set.contains(nums2[j])) {
                res.add(nums2[j]);
            }
        }
        int[] nums = res.stream().mapToInt(Number::intValue).toArray();
        return nums;
    }
}
