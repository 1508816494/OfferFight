package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern290 {
    public boolean wordPattern(String pattern, String str) {
        String[] strArr = str.split(" ");

        Map<Character, String> map = new HashMap<>();

        //存放map中已有的value，不同的key对应的value必须不同
        Set<String> set = new HashSet<>();

        if(pattern.length() != strArr.length) {
            return false;
        }

        for(int i = 0; i < pattern.length(); i++) {
            char key = pattern.charAt(i);
            String val = strArr[i];

            //如果出现新key，而对应的val值已经出现过，则直接返回false
            if(!map.containsKey(key) && set.contains(val)) {
                return false;
            }

            if(!map.containsKey(key)) {
                map.put(key, val);
                set.add(val);
            } else {
                String temp = map.get(key);
                if(val.equals(temp)) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
