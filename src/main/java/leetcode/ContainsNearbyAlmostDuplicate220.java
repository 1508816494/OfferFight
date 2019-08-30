package leetcode;

import java.util.Set;
import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();

        for( int i = 0; i < nums.length; i++ ) {
            //若不存在则返回null，返回类型为long
            Long val = set.ceiling( (long)nums[i] - (long)t );

            //次数nums[i]+t可能出现整型溢出，所以转为long 注意应该相加之前强转，而不是之后
            if( val != null && val <= (long)nums[i] + (long)t ) {
                return true;
            } else {
                set.add((long) nums[i]);
            }

            //判断长度
            if( set.size() == k + 1 ) {
                set.remove( (long)nums[i-k] );
            }
        }
        return false;
    }
}
