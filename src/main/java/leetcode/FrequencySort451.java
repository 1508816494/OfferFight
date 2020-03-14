package leetcode;

import javafx.util.Pair;

import java.util.*;

public class FrequencySort451 {
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] sArr = s.toCharArray();

        for(char c : sArr) {
            if(!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        IdentityHashMap<String, Character> idMap =new IdentityHashMap<>();

        map.forEach((key, value)->{
            idMap.put(String.valueOf(value), key);
            list.add(value);
        });

        Collections.sort(list);

        StringBuilder res = new StringBuilder();

        for(int i = list.size() - 1; i >= 0; i--) {
            int val = list.get(i);
            char c = idMap.get(String.valueOf(val));
            for(int j = 0; j < val; j++) {
                res.append(c);
            }
        }
        return String.valueOf(res);

    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
}
