package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsNearbyDuplicate219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for( int i = 0; i < nums.length; i++ ) {
            //包含，则返回true
            if( set.contains(nums[i]) ) {
                return true;
            } else {
                set.add(nums[i]);
            }

            //判断长度是否超过k
            if( set.size() == k + 1 ) {
                //删除首元素
                set.remove( nums[i-k] );
            }
        }
        return false;
    }
}
