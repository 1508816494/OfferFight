package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for( int i = 0; i < nums.length; i++ ) {
            set.add( nums[i]);
        }

        if( set.size() != nums.length ) {
            return true;
        } else {
            return false;
        }
    }
}
