package leetcode;

import java.util.Arrays;
import java.util.Collections;

public class AssignCookies455 {
    private Integer[] g;
    private Integer[] s;

    public int findContentChildren(int[] g, int[] s) {
//        this.g = g;
//        this.s = s;
        this.g = new Integer[g.length];
        for(int i = 0; i < g.length; i++) {
            this.g[i] = g[i];
        }
        this.s = new Integer[s.length];
        for(int i = 0; i < s.length; i++) {
            this.s[i] = s[i];
        }

        Arrays.sort(this.g, Collections.reverseOrder());
        Arrays.sort(this.s, Collections.reverseOrder());

        int gi = 0;
        int si = 0;
        int res = 0;
        while (gi < this.g.length && si < this.s.length) {
            //当前最大的饼干可以满足当前最贪心的小朋友
            if(this.s[si] >= this.g[gi]) {
                res++;
                si++;
                gi++;
            } else {
                gi++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        AssignCookies455 as = new AssignCookies455();
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        System.out.println(as.findContentChildren(g, s));
    }
}
