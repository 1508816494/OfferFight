package leetcode;

public class Palindrome125 {
    public static boolean isPalindrome(String s) {
        //忽略大小写，统一转为小写
        s = s.toLowerCase();

        //将string转为character数组
        char[] chars = s.toCharArray();

        if(s.length() == 0) {
            return  true;
        }

        int i = 0;
        int j = chars.length - 1;

        while (i < j) {
            if(Character.isLetterOrDigit(chars[i])) {
                if(Character.isLetterOrDigit(chars[j])) {
                    if(chars[i] != chars[j]) {
                        return false;
                    } else {
                        i++;
                        j--;
                    }
                } else {
                    //字符不为数字或字母，则忽略
                    j--;
                }
            } else {
                //字符不为数字或字母，则忽略
                i++;
            }
        }
        return true;
    }
}
