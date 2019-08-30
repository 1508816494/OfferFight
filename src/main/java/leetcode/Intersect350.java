package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersect350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums1.length; i++) {
            int key = nums1[i];
            if(!map.containsKey(key)) {
                map.put(nums1[i], 1);
            } else {
                int val = map.get(key);
                val++;
                map.put(key, val);
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int j = 0; j < nums2.length; j++) {
            int key = nums2[j];
            //此处不能用是否包含key，因为有可能包含key，但是值为0
            if(map.containsKey(key) && map.get(key) > 0) {
                list.add(nums2[j]);
                int val = map.get(key);
                val--;
                map.put(key, val);
            }
        }
        int[] res = list.stream().mapToInt(Number::intValue).toArray();
        return res;
    }
}
