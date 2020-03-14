package leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            boolean hasKey = map.containsKey(s.charAt(i));
            if(!hasKey) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        for(int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            if(map.containsKey(key)) {
                map.put(key, map.get(key) - 1);
            } else {
                return false;
            }
        }

        for(char key : map.keySet()) {
            if(map.get(key) != 0) {
                return false;
            }
        }
        return true;
    }
}
