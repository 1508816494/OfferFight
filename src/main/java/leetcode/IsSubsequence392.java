package leetcode;

public class IsSubsequence392 {
    public boolean isSubsequence(String s, String t) {
        if(t.length() < s.length()) {
            return false;
        }
        boolean res = false;

        int len = s.length();
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            //匹配s的指针才会后移
            if(s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                len--;
            } else {
                //不匹配t指针后移尝试匹配
                j++;
            }
        }
        if(len == 0) {
            res = true;
        }
        return res;
    }

    public static void main(String[] args) {
        IsSubsequence392 is = new IsSubsequence392();
        String s  = "abc";
        String t = "ahbgdc";
        System.out.println(is.isSubsequence(s, t));
    }
}
