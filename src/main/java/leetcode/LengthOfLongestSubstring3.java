package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring3 {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = -1;
        int res = 0;

        Set<Character> set = new HashSet<>();

        while(l < s.length()) {
            //r向前一位为新值，不重复
            if(r+1 < s.length() && set.add(s.charAt(r+1))) {
                r++;
            } else {
                set.remove(s.charAt(l));
                l++;
            }

            res = Math.max(res, r - l + 1);
        }
        return res;
    }

}
