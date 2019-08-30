package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FourSumCount454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        //将C[i]和D[j]的和放入map,同时记录出现的次数，因为可能出现多种可能
        for(int i = 0; i < C.length; i++) {
            for(int j = 0; j < D.length; j++) {
                int key = C[i] + D[j];
                if(!map.containsKey(key)) {
                    map.put(key, 1);
                } else {
                    int val = map.get(key);
                    val++;
                    map.put(key, val);
                }
            }
        }

        int res = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < B.length; j++) {
                int val = 0 - A[i] - B[j];
                if(map.containsKey(val)) {
                    res += map.get(val);
                }
            }
        }
        return res;
    }
}
