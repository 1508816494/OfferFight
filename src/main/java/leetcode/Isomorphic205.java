package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Isomorphic205 {
    public boolean isIsomorphic(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Map<Character, Character> map = new HashMap<>();

        //存放map中已有的value，不同的key对应的value必须不同
        Set<Character> set = new HashSet<>();

        if(sArr.length != tArr.length) {
            return false;
        }

        for(int i = 0; i < sArr.length; i++) {
            char key = sArr[i];
            char val = tArr[i];

            //如果出现新key，而对应的val值已经出现过，则直接返回false
            if(!map.containsKey(key) && set.contains(val)) {
                return false;
            }

            if(!map.containsKey(key)) {
                map.put(key, val);
                set.add(val);
            } else {
                char temp = map.get(key);
                if(temp == val) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
