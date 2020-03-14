package leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber202 {
    public static boolean isHappy(int n) {
        String str = String.valueOf(n);
        int val = 0;

        Set<Integer> set = new HashSet<>();

        while (str.length() >= 1) {
            for(int i = 0; i < str.length(); i++) {
                int temp = Integer.valueOf(String.valueOf(str.charAt(i)));
                val = val + temp * temp;
            }
            if(val == 1) {
                return true;
            } else {
                if(set.contains(val)) {
                    return false;
                } else {
                    set.add(val);
                    str = String.valueOf(val);
                    val = 0;
                }
            }
        }
       return false;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
